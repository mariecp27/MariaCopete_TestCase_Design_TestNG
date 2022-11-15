package org.espn.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy (css = ".promo-banner-container iframe")
    private WebElement iframeBanner;

    @FindBy (css = "section.PromoBanner")
    private WebElement banner;

    @FindBy (css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    @FindBy (id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy (id = "sideLogin-left-rail")
    private WebElement loginBox;

    @FindBy (css = "li.user > div.global-user:last-child")
    private WebElement userOptionsContainer;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginLinkInHomePage;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement logOutLinkInHomePage;

    @FindBy (id = "oneid-iframe")
    private WebElement iframe;

    @FindBy (css = "div.view-starry-night > div:first-child")
    private WebElement loginModalIframe;

    @FindBy (id = "logo")
    private WebElement espnLogoIframe;

    @FindBy (id = "InputLoginValue")
    private WebElement emailInputIframe;

    @FindBy (id = "InputPassword")
    private WebElement passwordInputIframe;

    @FindBy (id = "InputFirstName")
    private WebElement firstNameInputIframe;

    @FindBy (id = "InputLastName")
    private WebElement lastNameInputIframe;

    @FindBy (id = "InputEmail")
    private WebElement emailForSignUpInputIframe;

    @FindBy (id = "password-new")
    private WebElement passwordForSignUpInputIframe;

    @FindBy (id = "BtnSubmit")
    private WebElement loginButtonIframe;

    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpButtonIframe;

    @FindBy (id = "BtnSubmit")
    private WebElement signUpButtonForSignUpIframe;

    @FindBy (css = "li.pillar.watch > a")
    private WebElement watchLink;

    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeText;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:nth-child(5) > a")
    private WebElement espnProfileLink;

    @FindBy (id = "AccountDeleteLink")
    private WebElement deleteAccountLinkIframe;

    @FindBy (css = "#TextBlock + #BtnSubmit")
    private  WebElement deleteAccountButtonIframe;

    @FindBy (css = "#TextError + #BtnSubmit")
    private  WebElement deleteAccountConfirmationIframe;

    @FindBy (css = ".account-deleted-gating + #Title")
    private  WebElement deleteAccountTitleIframe;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void switchToBannerIframe() {
        super.getDriver().switchTo().frame(this.iframeBanner);
    }

    public void goOutFromBannerIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    public boolean verifyBanner() {
        boolean isBanner = true;
        try {
            super.waitForVisibility(this.banner);
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    public void closeBanner() {
        if (this.verifyBanner()) {
            super.clickElement(this.bannerCloseButton);
        }
    }

    public void waitForLogin() {
        super.waitForInvisibility(loginModalIframe);
        super.waitForPresenceOfElement("#sideLogin-left-rail");
        super.waitForAttributeChange(loginBox, "style", "display: none;");
    }

    public void waitForLogout() {
        super.waitForInvisibility(loginModalIframe);
        super.waitForPresenceOfElement("#sideLogin-left-rail");
        super.waitForAttributeChange(loginBox, "style", "display: block;");
    }

    public void mouseOverUserIcon() {
        super.mouseOver(this.userIcon);
        super.waitForVisibility(this.userOptionsContainer);
    }

    public void clickOnLoginLinkInHomePage() {
        super.clickElement(this.loginLinkInHomePage);
    }

    public void clickOnLogoutLinkInHomePage() {
        super.clickElement(this.logOutLinkInHomePage);
    }

    public void switchToIframe() {
        super.getDriver().switchTo().frame(this.iframe);
    }

    public void goOutFromIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    public boolean modalIsDisplayed() {
        super.waitForVisibility(this.loginModalIframe);
        return this.loginModalIframe.isDisplayed();
    }

    public boolean espnLogoIsDisplayed() {
        super.waitForVisibility(this.espnLogoIframe);
        return this.espnLogoIframe.isDisplayed();
    }

    public boolean loginButtonIsDisplayed() {
        super.waitForVisibility(this.loginButtonIframe);
        return this.loginButtonIframe.isDisplayed();
    }

    public boolean signUpButtonIsDisplayed() {
        super.waitForVisibility(this.signUpButtonIframe);
        return this.signUpButtonIframe.isDisplayed();
    }

    public void typeOnEmailInput(String text) {
        super.waitForVisibility(this.emailInputIframe);
        super.typeOnInput(this.emailInputIframe, text);
    }

    public void typeOnPasswordInput(String text) {
        super.waitForVisibility(this.passwordInputIframe);
        super.typeOnInput(this.passwordInputIframe, text);
    }

    public void typeOnFirstNameInput(String text) {
        super.waitForVisibility(this.firstNameInputIframe);
        super.typeOnInput(this.firstNameInputIframe, text);
    }

    public void typeOnLastNameInput(String text) {
        super.waitForVisibility(this.lastNameInputIframe);
        super.typeOnInput(this.lastNameInputIframe, text);
    }

    public void typeOnEmailInputForSignUp(String text) {
        super.waitForVisibility(this.emailForSignUpInputIframe);
        super.typeOnInput(this.emailForSignUpInputIframe, text);
    }

    public void typeOnPasswordInputForSignUp(String text) {
        super.waitForVisibility(this.passwordForSignUpInputIframe);
        super.typeOnInput(this.passwordForSignUpInputIframe, text);
    }

    public void clickOnLoginButtonIframe() {
        super.clickElement(this.loginButtonIframe);
    }

    public void clickOnSignUpButtonIframe() {
        super.clickElement(this.signUpButtonIframe);
    }

    public void clickOnSignUpForSignUpButtonIframe() {
        super.clickElement(this.signUpButtonForSignUpIframe);
    }

    public WatchPage goToWatchPage() {
        super.clickElement(this.watchLink);
        return new WatchPage(getDriver());
    }

    public String getWelcomeText() {
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }

    public void clickOnEspnProfileLink() {
        super.clickElement(this.espnProfileLink);
    }

    public void clickOnDeleteAccountLinkIframe() {
        super.clickElement(this.deleteAccountLinkIframe);
    }

    public void clickOnDeleteAccountButtonIframe() {
        super.clickElement(this.deleteAccountButtonIframe);
    }

    public void clickOnDeleteAccountConfirmationIframe() {
        super.clickElement(this.deleteAccountConfirmationIframe);
    }

    public String getDeleteAccountTitleIframeText() {
        super.waitForVisibility(deleteAccountTitleIframe);
        return this.deleteAccountTitleIframe.getText();
    }
}
