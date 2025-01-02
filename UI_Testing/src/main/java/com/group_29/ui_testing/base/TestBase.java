package com.group_29.ui_testing.base;

import org.openqa.selenium.WebDriver;
import com.group_29.ui_testing.utils.ConfigReader;

public class TestBase {
    private static ConfigReader configReader;

    public static WebDriver getDriver() {
        return WebDriverManager.getDriver();
    }

    public static void navigateToBaseUrl() {
        configReader = new ConfigReader();
        getDriver().get(getConfigReader().getProperty("url"));
    }

    public static ConfigReader getConfigReader() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public static void tearDown() {
        WebDriverManager.closeDriver();
    }
}