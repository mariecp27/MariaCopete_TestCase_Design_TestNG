package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class ESPNWebPageLogoutTests extends BaseTest {

    @Test
    public void doingLogout() {
        generalLoginSteps();
        homePage.waitForMouseOverUserIcon();
        homePage.mouseOverUserIcon();
        homePage.clickOnLogoutLinkInHomePage();
        homePage.waitForMouseOverUserIcon();
        homePage.mouseOverUserIcon();
        checkThat("Welcome text is correct", homePage.getWelcomeText(), is("Welcome!"));
    }
}
