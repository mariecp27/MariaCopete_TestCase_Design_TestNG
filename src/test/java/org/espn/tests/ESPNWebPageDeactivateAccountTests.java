package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class ESPNWebPageDeactivateAccountTests extends BaseTest {

    @Test
    public void deactivateAccount() {
        generalLoginSteps();
        homePage.waitForLogin();
        homePage.mouseOverUserIcon();
        homePage.clickOnEspnProfileLink();
        homePage.switchToIframe();
        homePage.clickOnDeleteAccountLinkIframe();
        homePage.clickOnDeleteAccountButtonIframe();
        homePage.clickOnDeleteAccountConfirmationIframe();
        homePage.goOutFromIframe();
        homePage.waitForLogout();
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
        homePage.typeOnEmailInput(email);
        homePage.typeOnPasswordInput(PASSWORD);
        homePage.clickOnLoginButtonIframe();
        checkThat("Deactivated text is correct", homePage.getDeleteAccountTitleIframeText(), is("Account Deactivated"));
    }
}
