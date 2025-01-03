package com.group_29.ui_testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(className = "title")
    private WebElement pageTitle;



    public CheckoutStepTwoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle)); // Wait until the element is visible
        return pageTitle.getText();
    }
}
