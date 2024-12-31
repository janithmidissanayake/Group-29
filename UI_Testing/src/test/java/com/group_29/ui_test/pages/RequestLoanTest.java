package com.group_29.ui_test.pages;

import com.group_29.ui_test.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RequestLoanTest extends BaseTest {

    @Test
    public void testLoanRequestForm() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(610));
        // Locate Loan Amount and Down Payment fields
        WebElement loanAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        WebElement downPaymentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downPayment")));

        // Validate numeric input
        loanAmountField.sendKeys("10000");
        downPaymentField.sendKeys("2000");

        // Submit the loan request
        WebElement requestButton = driver.findElement(By.xpath("//input[@value='Request Loan']"));
        requestButton.click();

        // Verify confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Loan Request Submitted']")));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Loan request confirmation message is not displayed.");
    }

}
