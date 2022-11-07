package com.globant;

import org.testng.annotations.Test;

public class ESPNWebPageLoginTests extends BaseClass {
    @Test(dataProvider = "loginData", priority = 1)
    public void logIn(String emailAddress, String password) {
        log.info("Select the person icon in the navigation bar");
        log.info("Click on 'Log In' option");
        log.info("Type " + emailAddress + " in 'Username or Email Address' field");
        log.info("Type " + password + " in 'Password (case sensitive)' field");
        log.info("Click on 'Log In' button");
        log.info("Select the person icon in the navigation bar");
        log.info("Verify if successfully logged in");
        System.out.println();
    }

    @Test (dataProvider = "invalidData", priority = 2)
    public void UnsuccessfulLogIn(String emailAddress, String password) {
        log.info("Select the person icon in the navigation bar");
        log.info("Click on 'Log In' option");
        log.info("Type " + emailAddress + " in 'Username or Email Address' field");
        log.info("Type " + password + " in 'Password (case sensitive)' field");
        log.info("Click on 'Log In' button");
        log.info("Verify if the message 'The credentials you entered are incorrect. Reminder: Passwords are case sensitive.' is shown");
        System.out.println();
    }
}
