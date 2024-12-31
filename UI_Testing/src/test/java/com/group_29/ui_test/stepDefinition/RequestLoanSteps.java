package com.group_29.ui_test.stepDefinition;

import com.group_29.ui_test.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RequestLoanSteps extends BaseTest {

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
