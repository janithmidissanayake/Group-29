//package com.group_29.ui_testing.stepDefinitions;
//
//public class RequestLoanSteps {
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class RequestLoanSteps extends BrowserDriver {

    private WebDriverWait wait;


    @Before
    public void setUpWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("I am on the loan request page")
    public void i_am_on_the_loan_request_page() {
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
//        WebDriver driver;
//        LoginPage loginPage;
//
//
//            // Setup WebDriver
//            driver = new ChromeDriver();
//            loginPage = new LoginPage(driver);
//
//            // Perform login
//            loginPage.login("https://parabank.parasoft.com/parabank/index.htm", "123", "123");
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a")).click();

    }

    @When("I enter a loan amount of {string} and a down payment of {string}")
    public void i_enter_a_loan_amount_of_and_a_down_payment_of(String loanAmount, String downPayment) {
        WebElement loanAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amount\"]")));
        WebElement downPaymentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"downPayment\"]")));

        loanAmountField.sendKeys(loanAmount);
        downPaymentField.sendKeys(downPayment);
    }

    @When("I submit the loan request")
    public void i_submit_the_loan_request() {
        WebElement requestButton = driver.findElement(By.xpath("//*[@id=\"requestLoanForm\"]/form/table/tbody/tr[4]/td[2]/input"));
        requestButton.click();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedMessage) {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"requestLoanResult\"]/h1")));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Loan request confirmation message is not displayed.");
        Assert.assertEquals(confirmationMessage.getText(), expectedMessage, "Confirmation message does not match.");
    }


}