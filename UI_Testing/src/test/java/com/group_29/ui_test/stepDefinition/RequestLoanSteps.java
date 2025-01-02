package com.group_29.ui_testing.stepDefinition;

import com.group_29.ui_testing.pages.RequestLoan;
import com.group_29.ui_testing.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RequestLoanSteps  {
    private WebDriver driver;
    private RequestLoan requestLoan;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        requestLoan = new RequestLoan(driver);
    }

    @Given("user is logged in to ParaBank")
    public void user_Is_Logged_In_To_Para_Bank() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        //driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("username")).sendKeys("Admin");
        //driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.name("password")).sendKeys("test@987");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed(), "Login failed");
        //throw new io.cucumber.java.PendingException();
    }

    @When("user navigates to Request Loan page")
    public void user_Navigates_To_Request_Loan_Page() {
        //WebElement requestLoanLink = driver.findElement(By.linkText("Request Loan"));
        WebElement requestLoanLink = driver.findElement(By.linkText("Loan Request"));
        requestLoanLink.click();
        //00Assert.assertEquals(driver.getTitle(), "ParaBank | Request Loan", "Failed to navigate to Request Loan page");
        Assert.assertEquals(driver.getTitle(), "ParaBank | Loan Request", "Failed to navigate to Request Loan page");
       // throw new io.cucumber.java.PendingException();
    }

    @And("user fills out the loan application with amount {string}, down payment {string}, and account {string}")
    public void user_Fills_Out_The_Loan_Application(String amount, String downPayment, String account) {
        driver.findElement(By.id("amount")).sendKeys(amount);
        driver.findElement(By.id("downPayment")).sendKeys(downPayment);
        driver.findElement(By.id("fromAccountId")).click();
        driver.findElement(By.cssSelector("option[value='" + account + "']")).click();
        driver.findElement(By.cssSelector("input[value='Apply Now']")).click();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("a loan confirmation message is displayed")
    public void a_Loan_Confirmation_Message_Is_Displayed() {
        WebElement confirmationMessage = driver.findElement(By.id("loanStatus"));
        Assert.assertTrue(confirmationMessage.getText().contains("Congratulations"), "Loan request failed");
       // throw new io.cucumber.java.PendingException();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

    /*
    private WebDriverWait wait;

    @Given("I am on the loan request page")
    public void i_am_on_the_loan_request_page() {
        driver.get("http://parabank.parasoft.com/requestloan.htm");
        wait = new WebDriverWait(driver, Duration.ofSeconds(310));
    }

    @When("I enter a loan amount of {string} and a down payment of {string}")
    public void i_enter_a_loan_amount_of_and_a_down_payment_of(String loanAmount, String downPayment) {
        WebElement loanAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        WebElement downPaymentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downPayment")));

        loanAmountField.sendKeys(loanAmount);
        downPaymentField.sendKeys(downPayment);
    }

    @When("I submit the loan request")
    public void i_submit_the_loan_request() {
        WebElement requestButton = driver.findElement(By.xpath("//input[@value='Request Loan']"));
        requestButton.click();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedMessage) {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Loan Request Submitted']")));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Loan request confirmation message is not displayed.");
        Assert.assertEquals(confirmationMessage.getText(), expectedMessage, "Confirmation message does not match.");
    }


}


 */