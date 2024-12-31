package com.group_29.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
 public static WebDriver driver; // Static WebDriver instance

    public BrowserDriver() {
        if (driver == null) { // Ensure driver is initialized only once
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new BrowserDriver(); // Initialize the driver if not already done
        }
        return driver;
    }

    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null; // Clean up after closing the browser
        }
    }
}
