//package com.group_29.ui_testing.stepDefinitions;
//
//import com.group_29.ui_testing.pages.LoginPage;
//import com.group_29.utils.BrowserDriver;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.time.Duration;
//
//import static org.testng.Assert.assertTrue;
//
//public class BillPay extends BrowserDriver{
//    private WebDriverWait wait;
//    private LoginPage loginPage;
//
//    @Before
//    public void setUpWait() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    }
//    @Given("I need to log")
////    public void i_am_on_request_page() {
//        public void executeLogin() {
//            // Create an instance of LoginPage
//
//
//            // Call the login method
//            loginPage.login();
//        }
////        WebDriver driver = BrowserDriver.getDriver();
////        driver.get("https://parabank.parasoft.com/parabank/index.htm");
////
////        // Entering valid username and password
////        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
////        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
////        usernameField.sendKeys("123");  // Replace with a valid username
////        passwordField.sendKeys("123");  // Replace with a valid password
////
////        // Clicking the login button
////        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
//
//        // Optionally, you can add a wait here to ensure the page loads correctly
////        WebElement accountsOverview = driver.findElement(By.xpath("//*[@id=\"showOverview\"]/h1"));
////        assertTrue(accountsOverview.isDisplayed(), "Accounts Overview page is not displayed.");
//
////        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a")).click();
//
////    }
//
//    @When("I enter bill pay")
//    public void i_bill() {
//        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[4]/a")).click();
//    }
//
////    @When("I submit the loan request")
////    public void i_submit_the_loan_request() {
////        WebElement requestButton = driver.findElement(By.xpath("//*[@id=\"requestLoanForm\"]/form/table/tbody/tr[4]/td[2]/input"));
////        requestButton.click();
////    }
//
//    @Then("I should see a confirmation messaged {string}")
//    public void i_should_see_a_confirmation_messagef(String expectedMessage) {
//        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"billpayForm\"]/h1")));
//        Assert.assertTrue(confirmationMessage.isDisplayed(), "Loan request confirmation message is not displayed.");
//        Assert.assertEquals(confirmationMessage.getText(), expectedMessage, "Confirmation message does not match.");
//    }
//
//}

package com.group_29.ui_testing.stepDefinitions;

import com.group_29.ui_testing.pages.LoginPage;
import com.group_29.utils.BrowserDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BillPay extends BrowserDriver {
    private WebDriverWait wait;
    private LoginPage loginPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserDriver.getDriver(); // Initialize the driver from BrowserDriver
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set up WebDriverWait
        loginPage = new LoginPage(driver); // Create an instance of LoginPage
    }

    @Given("I need to log")
    public void executeLogin() {
        // Call the login method from LoginPage
        loginPage.login();
    }

    @When("I enter bill pay")
    public void iBillPay() {
        // Navigate to the Bill Pay page
        WebElement billPayLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"leftPanel\"]/ul/li[4]/a")));
        billPayLink.click();
    }

    @Then("I should see a confirmation messaged {string}")
    public void iShouldSeefAConfirmationMessage(String expectedMessage) {
        // Verify the confirmation message is displayed
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"billpayForm\"]/h1")));
        assertTrue(confirmationMessage.isDisplayed(), "Bill Pay confirmation message is not displayed.");
        Assert.assertEquals(confirmationMessage.getText(), expectedMessage, "Confirmation message does not match.");
    }
}
