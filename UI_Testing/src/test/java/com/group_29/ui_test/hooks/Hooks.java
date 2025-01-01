package com.group_29.ui_testing.hooks;

import com.group_29.ui_testing.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setup() {
        // Initialize the driver and browser
        DriverManager.getDriver();
    }

    @After
    public void cleanup(Scenario scenario) {
        DriverManager.quitDriver();
    }
}
