package org.espn.tests;

import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
import org.espn.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static java.lang.String.format;

public class BaseTest {

    private Driver driver;
    protected HomePage homePage;
    protected final String EMAIL = "test.email.for.espn@gmail.com";
    protected final String PASSWORD = "testpassword202212";
    protected final String USER = "Test";
    protected final String USER_WELCOME = "Welcome" + USER + "!";

    @Parameters({"browser", "url"})
    @BeforeTest
    public void testSetUp(String browser, String url) {
        driver = new Driver();
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
}
