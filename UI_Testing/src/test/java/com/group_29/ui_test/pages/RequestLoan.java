package com.group_29.ui_testing.pages;

import com.group_29.ui_testing.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RequestLoan {
    private final WebDriverWait wait;
    private WebDriver driver;


public RequestLoan (WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

}
/*
    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }


 */

    @Test
    public void testRequestLoan() {
        // Log in first (required for accessing the loan request page)

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("test@987");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Verify successful login
        Assert.assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed(), "Login failed");

        // Navigate to Request Loan page
        //WebElement requestLoanLink = driver.findElement(By.linkText("Request Loan"));
        WebElement requestLoanLink = driver.findElement(By.linkText("Loan Request"));
        requestLoanLink.click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Loan Request", "Failed to navigate to Request Loan page");

        // Fill out loan request form
        driver.findElement(By.id("amount")).sendKeys("5000");
        driver.findElement(By.id("downPayment")).sendKeys("1000");
        driver.findElement(By.id("fromAccountId")).click();
        driver.findElement(By.cssSelector("option[value='12345']")).click();
        driver.findElement(By.cssSelector("input[value='Apply Now']")).click();

        // Verify loan application success
        WebElement confirmationMessage = driver.findElement(By.id("loanStatus"));
        Assert.assertTrue(confirmationMessage.getText().contains("Congratulations"), "Loan request failed");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


 