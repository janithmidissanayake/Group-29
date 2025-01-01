package com.group_29.ui_testing.stepDefinitions;

import com.group_29.utils.BrowserDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class UpdateUserContactInfo {
    WebDriver driver = BrowserDriver.getDriver();
    private WebDriverWait wait;
    @Before
    public void setUpWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("I am logged into ParaBank")
    public void iAmLoggedIn() {
        WebDriver driver = BrowserDriver.getDriver();
//        driver.get("https://parabank.parasoft.com/parabank/index.htm");
//
//        // Entering valid username and password
//        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
//        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
//        usernameField.sendKeys("gi");  // Replace with a valid username
//        passwordField.sendKeys("gi");  // Replace with a valid password
//
//        // Clicking the login button
//        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
//
//        // Optionally, you can add a wait here to ensure the page loads correctly
//        WebElement accountsOverview = driver.findElement(By.xpath("//*[@id=\"showOverview\"]/h1"));
//        assertTrue(accountsOverview.isDisplayed(), "Accounts Overview page is not displayed.");
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[6]/a")).click();
    }

//    @Given("I navigate to the {string} page")
//    public void iNavigateToPage(String page) {
//        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[6]/a")).click();
//    }

    @When("I update my phone number to {string}")
    public void iUpdatePhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"updateProfileForm\"]/h1")));

        WebElement customerFName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.firstName\"]")));
        customerFName.sendKeys("HI");

        WebElement customerLName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.lastName\"]")));
        customerLName.sendKeys("HIh");

        WebElement customerAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.address.street\"]")));
        customerAddress.sendKeys("HI");

        WebElement customerCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.address.city\"]")));
        customerCity.sendKeys("HI");

        WebElement customerState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.address.state\"]")));
        customerState.sendKeys("HI");

        WebElement zipCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.address.zipCode\"]")));
        zipCode.sendKeys("2338");

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.phoneNumber\"]")));
        phoneField.sendKeys(phoneNumber);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"updateProfileForm\"]/form/table/tbody/tr[8]/td[2]/input")));
        submitButton.click();
//        driver.findElement(By.xpath("//*[@id=\"updateProfileForm\"]/form/table/tbody/tr[8]/td[2]/input")).click(); // Click to submit the form

    }

    @Then("I should see a success message confirming the update")
    public void iShouldSeeUpdateSuccessMessage() {
////        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"updateProfileResult\"]/p"));
////        assertTrue(successMessage.isDisplayed(), "User information was not updated successfully.");
//
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"updateProfileResult\"]/h1")));
        assertTrue(successMessage.isDisplayed(), "User information was not updated successfully.");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Increase wait time if needed
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"updateProfileResult\"]/h1")));
//
//        // Scroll the success message into view
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", successMessage);
//
//        // Assert that the success message is displayed
//        assertTrue(successMessage.isDisplayed(), "User information was not updated successfully.");

    }
}
