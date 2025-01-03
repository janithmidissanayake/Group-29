package com.group_29.ui_testing.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            // Set up Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // Ensure Chrome runs headlessly
            options.addArguments("--no-sandbox");  // Disable sandboxing (required in CI environments)
            options.addArguments("--disable-dev-shm-usage");  // Solve issues related to limited /dev/shm size
            options.addArguments("--disable-gpu");  // Disable GPU acceleration in headless mode

            // Initialize WebDriver with options
            WebDriver chromeDriver = new ChromeDriver(options);
            chromeDriver.manage().window().maximize();

            // Set the driver for the current thread
            driver.set(chromeDriver);
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
