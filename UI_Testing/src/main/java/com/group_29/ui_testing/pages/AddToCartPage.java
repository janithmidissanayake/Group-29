package com.group_29.ui_testing.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddToCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "title")
    private WebElement addToCartPageTitle;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getAddToCartPageTitle() {
        return wait.until(ExpectedConditions.visibilityOf(addToCartPageTitle)).getText();
    }

    public boolean isProductInCart(String productName) {
        String productXPath = "//div[@class='cart_item']//div[text()='" + productName + "']";
        try {
            WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productXPath)));
            return product.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void removeProduct(String productName) {
        String buttonXPath = "//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button[text()='Remove']";
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
        removeButton.click();
    }
}