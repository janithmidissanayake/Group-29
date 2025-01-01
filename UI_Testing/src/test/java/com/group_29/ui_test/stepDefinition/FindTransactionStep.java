package com.group_29.ui_testing.stepDefinition;

import com.group_29.ui_testing.pages.FindTransactionTest;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FindTransactionStep {


    private WebDriver driver;
    private FindTransactionTest findTransactionTest;


    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        findTransactionTest = new FindTransactionTest(driver);
    }
/*
    @Given("user is logged in to ParaBank")
    public void userIsLoggedInToParaBank() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed(), "Login failed");
    }


 */
    @When("user navigates to Find Transactions page")
    public void userNavigatesToFindTransactionsPage() {
        WebElement findTransactionsLink = driver.findElement(By.linkText("Find Transactions"));
        findTransactionsLink.click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Find Transactions", "Failed to navigate to Find Transactions page");
    }

    @And("user searches for transactions by date {string}")
    public void userSearchesForTransactionsByDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("criteria.onDate")));
        dateField.clear();
        dateField.sendKeys(date);

        WebElement findButton = driver.findElement(By.cssSelector("button[type='submit']"));
        findButton.click();
    }

    @Then("transactions for the date {string} are displayed")
    public void transactionsForTheDateAreDisplayed(String date) {
        WebElement resultsTable = driver.findElement(By.id("transactionTable"));
        Assert.assertTrue(resultsTable.isDisplayed(), "Transaction results table is not displayed");

        WebElement transactionDate = driver.findElement(By.xpath("//table[@id='transactionTable']//tr[2]/td[1]"));
        Assert.assertEquals(transactionDate.getText(), date, "Transaction date does not match");
    }

    @And("user searches for transactions by amount {string}")
    public void userSearchesForTransactionsByAmount(String amount) {
        WebElement amountField = driver.findElement(By.id("criteria.amount"));
        amountField.clear();
        amountField.sendKeys(amount);

        WebElement findButton = driver.findElement(By.cssSelector("button[type='submit']"));
        findButton.click();
    }

    @Then("transactions for the amount {string} are displayed")
    public void transactionsForTheAmountAreDisplayed(String amount) {
        WebElement resultsTable = driver.findElement(By.id("transactionTable"));
        Assert.assertTrue(resultsTable.isDisplayed(), "Transaction results table is not displayed");

        WebElement transactionAmount = driver.findElement(By.xpath("//table[@id='transactionTable']//tr[2]/td[3]"));
        Assert.assertEquals(transactionAmount.getText(), amount, "Transaction amount does not match");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
