package com.group_29.ui_testing.pages;


import com.group_29.utils.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Define locators
    private final By usernameField = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    private final By passwordField = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    private final By loginButton = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    private final By accountsOverview = By.xpath("//*[@id=\"showOverview\"]/h1");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set an explicit wait
    }

    // Method to open the login page
    public void openLoginPage(String url) {
        driver.get(url);
    }

    // Method to enter the username
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.clear(); // Clear any pre-filled text
        usernameElement.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear(); // Clear any pre-filled text
        passwordElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    // Method to verify successful login
    public void verifyLoginSuccess() {
        WebElement accountsOverviewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountsOverview));
        assertTrue(accountsOverviewElement.isDisplayed(), "Accounts Overview page is not displayed.");
    }

    // Method to perform a complete login flow
    public void login(String url, String username, String password) {
        openLoginPage(url);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        verifyLoginSuccess();
    }
}