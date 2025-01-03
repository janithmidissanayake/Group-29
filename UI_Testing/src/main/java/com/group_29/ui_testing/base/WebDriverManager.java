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
            options.addArguments("--remote-debugging-port=9222");  // Specify a port for remote debugging
            options.addArguments("--disable-gpu");  // Disable GPU acceleration in headless mode

            // Create a new ChromeDriver with the specified options
            driver.set(new ChromeDriver(options));
            driver.get().manage().window().maximize();  // Maximize the window (useful for debugging)
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
