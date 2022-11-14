package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class ESPNWebPageDeactivateAccountTests extends BaseTest {

    @Test
    public void deactivateAccount() {
        generalLoginSteps();
        homePage.waitForMouseOverUserIcon();
        homePage.mouseOverUserIcon();
        homePage.clickOnEspnProfileLink();
        homePage.switchToIframe();
        homePage.clickOnDeleteAccountLinkIframe();
        homePage.clickOnDeleteAccountButtonIframe();
        homePage.clickOnDeleteAccountConfirmationIframe();
        homePage.goOutFromIframe();
        homePage.waitForMouseOverUserIcon();
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
        homePage.typeOnEmailInput(EMAIL);
        homePage.typeOnPasswordInput(PASSWORD);
        homePage.clickOnLoginButtonIframe();
        checkThat("Deactivated text is correct", homePage.getDeleteAccountTitleIframeText(), is("Account Deactivated!"));
    }
}
