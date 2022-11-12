package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy (id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy (css = "li.user > div.global-user:last-child")
    private WebElement userOptionsContainer;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginLinkInHomePage;

    @FindBy (id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy (css = "div.view-starry-night >div:first-child")
    private WebElement loginModalIframe;

    @FindBy (id = "logo")
    private WebElement espnLogoIframe;

    @FindBy (id = "InputLoginValue")
    private WebElement emailInputIframe;

    @FindBy (id = "InputPassword")
    private WebElement passwordInputIframe;

    @FindBy (id = "BtnSubmit")
    private WebElement loginButtonIframe;

    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpButtonIframe;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLinkInHomePage() {
        clickElement(userIcon);
        waitForVisibility(userOptionsContainer);
        clickElement(loginLinkInHomePage);
    }

    public void switchToIframe() {
        getDriver().switchTo().frame(loginIframe);
    }

    public boolean modalIsDisplayed() {
        return loginModalIframe.isDisplayed();
    }

    public boolean espnLogoIsDisplayed() {
        return espnLogoIframe.isDisplayed();
    }

    public boolean loginButtonIsDisplayed() {
        return loginButtonIframe.isDisplayed();
    }

    public boolean signUpButtonIsDisplayed() {
        return signUpButtonIframe.isDisplayed();
    }

    public void goOutFromIframe() {
        getDriver().switchTo().defaultContent();
    }
}
