package com.group_29.ui_testing.pages;

import com.group_29.ui_testing.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerCareTest {


    private final WebDriverWait wait;
    private WebDriver driver;

  /*  @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


   */

    public CustomerCareTest (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void testNavigateToCustomerCarePage() {
        driver.findElement(By.linkText("Contact Us")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Customer Care", "Failed to navigate to Customer Care page");
    }

    @Test
    public void testSubmitCustomerCareMessage() {
        driver.findElement(By.linkText("Contact Us")).click();
        driver.findElement(By.id("name")).sendKeys("Admin");
        driver.findElement(By.id("email")).sendKeys("shobishasm.20@uom.lkmiis");
        driver.findElement(By.id("message")).sendKeys("I need assistance with my account.");
        driver.findElement(By.cssSelector("input[value='Send to Customer Care']")).click();

        String confirmationMessage = driver.findElement(By.cssSelector(".success")).getText();
        Assert.assertTrue(confirmationMessage.contains("Thank you"), "Message submission failed");
    }
}



