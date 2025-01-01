package com.group_29.ui_testing.pages;

import com.group_29.ui_testing.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageNavigationTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
/*
    private void loginToParaBank(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed(), "Login failed");
    }

     */


    @Test
    public void testNavigationToAccountsOverview() {
        driver.findElement(By.linkText("Accounts Overview")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview", "Failed to navigate to Accounts Overview");
    }

    @Test
    public void testNavigationToTransferFunds() {
        driver.findElement(By.linkText("Transfer Funds")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Transfer Funds", "Failed to navigate to Transfer Funds");
    }

    @Test
    public void testNavigationToRequestLoan() {
        driver.findElement(By.linkText("Request Loan")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Request Loan", "Failed to navigate to Request Loan");
    }

    @Test
    public void testNavigationToFindTransactions() {
        driver.findElement(By.linkText("Find Transactions")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Find Transactions", "Failed to navigate to Find Transactions");
    }
}



