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

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement logOutLinkInHomePage;

    @FindBy (id = "oneid-iframe")
    private WebElement iframe;

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

    public void waitForMouseOverUserIcon() {
        if (waitForReload(this.userIcon)) {
            waitForVisibility(this.userIcon);
        }
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

    public void clickOnLoginButtonIframe() {
        clickElement(this.loginButtonIframe);
    }

    public WatchPage goToWatchPage() {
        if (super.waitForReload(this.watchLink)) {
            super.waitForVisibility(this.watchLink);
        }
        super.clickElement(this.watchLink);
        return new WatchPage(getDriver());
    }

    public String getWelcomeText() {
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }

    public void clickOnEspnProfileLink() {
        clickElement(this.espnProfileLink);
    }

    public void clickOnDeleteAccountLinkIframe() {
        clickElement(this.deleteAccountLinkIframe);
    }

    public void clickOnDeleteAccountButtonIframe() {
        clickElement(this.deleteAccountButtonIframe);
    }

    public void clickOnDeleteAccountConfirmationIframe() {
        clickElement(this.deleteAccountConfirmationIframe);
    }

    public String getDeleteAccountTitleIframeText() {
        waitForVisibility(deleteAccountTitleIframe);
        return this.deleteAccountTitleIframe.getText();
    }
}
