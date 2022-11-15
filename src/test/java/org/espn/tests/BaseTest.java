package org.espn.tests;

import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
import org.espn.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;

public class BaseTest {

    private static Driver driver;
    protected HomePage homePage;
    protected final String USER = "Test";
    protected static String email;
    protected final String PASSWORD = "testpassword2022";
    protected final String USER_WELCOME = "Welcome" + USER + "!";

    @Parameters({"url"})
    @BeforeSuite
    public void createAccount(String url) {
        driver = new Driver();
        setEmail();
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
        homePage.switchToBannerIframe();
        homePage.closeBanner();
        homePage.goOutFromBannerIframe();
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
        homePage.clickOnSignUpButtonIframe();
        homePage.typeOnFirstNameInput(USER);
        homePage.typeOnLastNameInput(USER);
        homePage.typeOnEmailInputForSignUp(email);
        homePage.typeOnPasswordInputForSignUp(PASSWORD);
        homePage.scrollDown();
        homePage.clickOnSignUpForSignUpButtonIframe();
        homePage.goOutFromIframe();
        homePage.waitForLogin();
        homePage.mouseOverUserIcon();
        checkThat("Welcome text is correct", homePage.getWelcomeText(), is(USER_WELCOME));
        homePage.clickOnLogoutLinkInHomePage();
        homePage.waitForLogout();
        homePage.mouseOverUserIcon();
        checkThat("Welcome text is correct", homePage.getWelcomeText(), is("Welcome!"));
    }

    @Parameters({"url"})
    @BeforeClass
    public void classSetUp(String url) {
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
    }

    @AfterTest
    public void tearDown() {
        driver.getDriver().quit();
    }

    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        Reporter.info(format("Checking that " + description.toLowerCase() + "[Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e) {
            Reporter.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }

    public void setEmail() {
        int randomValue = (int)(Math.random() * 1000);
        email = "test.email.espn" + randomValue + "@gmail.com";
    }

    protected void generalLoginSteps() {
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
        homePage.typeOnEmailInput(email);
        homePage.typeOnPasswordInput(PASSWORD);
        homePage.clickOnLoginButtonIframe();
        homePage.goOutFromIframe();
    }
}
