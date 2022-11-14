package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class ESPNWebPageLogoutTests extends BaseTest {

    @Test
    public void doingLogout() {
        loginSteps();
        homePage.clickOnLogoutLinkInHomePage();
        checkThat("Welcome text is correct", homePage.getWelcomeTextWhenLoggedOut(), is("Welcome!"));
    }
}
