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
        homePage.typeOnEmailInput(email);
        homePage.typeOnPasswordInput(PASSWORD);
        homePage.clickOnLoginButtonIframe();
        homePage.goOutFromIframe();
        WatchPage watchPage = homePage.goToWatchPage();
        checkThat("All cards in carousel has title", watchPage.checkAllCardsTitle(), is(true));
        checkThat("All cards in carousel has description", watchPage.checkAllCardsDescription(), is(true));
        watchPage.clickCard();
        checkThat("Close button is visible", watchPage.closeButtonModalIsDisplayed(), is(true));
        watchPage.clickOnCloseButtonModal();
        watchPage.returnToHomePage();
        homePage.mouseOverUserIcon();
        checkThat("Welcome text is correct", homePage.getWelcomeText(), is(USER_WELCOME));
        homePage.clickOnLogoutLinkInHomePage();
        homePage.waitForMouseOverUserIcon();
        homePage.mouseOverUserIcon();
        checkThat("Welcome text is correct", homePage.getWelcomeText(), is("Welcome!"));
    }
}
