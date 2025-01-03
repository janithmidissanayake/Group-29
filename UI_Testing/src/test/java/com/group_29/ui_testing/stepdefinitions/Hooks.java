package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.LoginPage;
import com.group_29.ui_testing.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        // Navigate to the website
        WebDriverManager.getDriver().get(ConfigReader.getProperty("url"));

        // Perform login as precondition
        LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
}
}