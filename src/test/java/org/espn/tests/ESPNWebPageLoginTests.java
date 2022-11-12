package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class ESPNWebPageLoginTests extends BaseTest {

    @Test
    public void validateElements() {
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
        checkThat("Login modal is visible", homePage.espnLogoIsDisplayed(), is(true));
        checkThat("ESPN logo is visible", homePage.espnLogoIsDisplayed(), is(true));
        checkThat("Log in button is visible", homePage.loginButtonIsDisplayed(), is(true));
        checkThat("Sign up button is visible", homePage.signUpButtonIsDisplayed(), is(true));
    }
}
