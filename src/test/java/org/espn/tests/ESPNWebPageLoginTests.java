package org.espn.tests;

import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class ESPNWebPageLoginTests extends BaseTest {

    @Test
    public void doingLogin() {
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
        checkThat("Login modal is visible", homePage.modalIsDisplayed(), is(true));
        checkThat("ESPN logo is visible", homePage.espnLogoIsDisplayed(), is(true));
        checkThat("Log in button is visible", homePage.loginButtonIsDisplayed(), is(true));
        checkThat("Sign up button is visible", homePage.signUpButtonIsDisplayed(), is(true));
        homePage.typeOnEmailInput(EMAIL);
        homePage.typeOnPasswordInput(PASSWORD);
        homePage.clickOnLoginButtonIframe();
        homePage.goOutFromIframe();
        WatchPage watchPage = homePage.goToWatchPage();
        checkThat("At least one carousel is visible", watchPage.carouselIsDisplayed(), is(true));
        watchPage.clickCard();
        checkThat("Close button is visible", watchPage.switchToModal(), is(true));
        watchPage.returnToHomePage();
        homePage.mouseOverUserIcon();
        checkThat("Welcome text is correct", homePage.getWelcomeTextWhenLogged(), is(USER_WELCOME));
        homePage.clickOnLogoutLinkInHomePage();
        checkThat("Welcome text is correct", homePage.getWelcomeTextWhenLoggedOut(), is("Welcome!"));
    }
}
