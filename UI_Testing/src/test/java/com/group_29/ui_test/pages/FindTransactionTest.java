package com.group_29.ui_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindTransactionTest {


    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By findTransactionsLink = By.linkText("Find Transactions");
    private By dateField = By.id("criteria.onDate");
    private By amountField = By.id("criteria.amount");
    private By findButton = By.cssSelector("button[type='submit']");
    private By resultsTable = By.id("transactionTable");
    private By transactionDate = By.xpath("//table[@id='transactionTable']//tr[2]/td[1]");
    private By transactionAmount = By.xpath("//table[@id='transactionTable']//tr[2]/td[3]");

    public FindTransactionTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to Find Transactions page
    public void navigateToFindTransactionsPage() {
        WebElement findTransactions = wait.until(ExpectedConditions.elementToBeClickable(findTransactionsLink));
        findTransactions.click();
        String expectedTitle = "ParaBank | Find Transactions";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        if (!driver.getTitle().equals(expectedTitle)) {
            throw new RuntimeException("Failed to navigate to Find Transactions page");
        }
    }

    // Search transactions by date
    public void searchTransactionsByDate(String date) {
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        dateInput.clear();
        dateInput.sendKeys(date);

        WebElement searchButton = driver.findElement(findButton);
        searchButton.click();
    }

    // Verify transactions for the given date
    public boolean verifyTransactionsByDate(String expectedDate) {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
        if (!results.isDisplayed()) {
            return false;
        }
        WebElement transactionDateCell = driver.findElement(transactionDate);
        return transactionDateCell.getText().equals(expectedDate);
    }

    // Search transactions by amount
    public void searchTransactionsByAmount(String amount) {
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        amountInput.clear();
        amountInput.sendKeys(amount);

        WebElement searchButton = driver.findElement(findButton);
        searchButton.click();
    }

    // Verify transactions for the given amount
    public boolean verifyTransactionsByAmount(String expectedAmount) {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
        if (!results.isDisplayed()) {
            return false;
        }
        WebElement transactionAmountCell = driver.findElement(transactionAmount);
        return transactionAmountCell.getText().equals(expectedAmount);
    }



}
