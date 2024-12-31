package com.group_29.ui_testing.stepDefinitions;

import com.group_29.utils.BrowserDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class UpdateUserContactInfo {
    WebDriver driver = BrowserDriver.getDriver();

    @Given("I am logged into ParaBank")
    public void iAmLoggedIn() {
        WebDriver driver = BrowserDriver.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Entering valid username and password
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        usernameField.sendKeys("123");  // Replace with a valid username
        passwordField.sendKeys("123");  // Replace with a valid password

        // Clicking the login button
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();

        // Optionally, you can add a wait here to ensure the page loads correctly
        WebElement accountsOverview = driver.findElement(By.xpath("//*[@id=\"showOverview\"]/h1"));
        assertTrue(accountsOverview.isDisplayed(), "Accounts Overview page is not displayed.");
    }

    @When("I navigate to the {string} page")
    public void iNavigateToPage(String page) {
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[6]/a")).click();
    }

    @When("I update my phone number to {string}")
    public void iUpdatePhoneNumber(String phoneNumber) {
        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"customer.phoneNumber\"]"));
        phoneField.sendKeys(phoneNumber);
        driver.findElement(By.xpath("//*[@id=\"updateProfileForm\"]/form/table/tbody/tr[8]/td[2]/input")).click(); // Click to submit the form
    }

    @Then("I should see a success message confirming the update")
    public void iShouldSeeUpdateSuccessMessage() {
//        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"updateProfileResult\"]/p"));
//        assertTrue(successMessage.isDisplayed(), "User information was not updated successfully.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"updateProfileResult\"]/h1")));
        assertTrue(successMessage.isDisplayed(), "User information was not updated successfully.");
    }
}
