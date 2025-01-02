package com.group_29.ui_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriverWait wait;

    @FindBy(className = "title")
    private WebElement pageTitle;




    public String getPageTitle() {
        return pageTitle.getText();
    }
    private static WebDriver driver;

    // Locators
    private static final By productInCartLocator = By.cssSelector(".cart-item"); // Adjust the selector as per your HTML
    private final By removeButtonLocator = By.cssSelector(".remove-btn"); // Adjust the selector as per your HTML
    private static final By emptyCartMessageLocator = By.cssSelector(".empty-cart-message"); // Adjust the selector

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }



    public static boolean isProductInCart() {
        return driver.findElements(productInCartLocator).size() > 0;
    }

    public void removeProductFromCart() {
        if (isProductInCart()) {
            driver.findElement(removeButtonLocator).click();
        }
    }

    public static boolean isCartEmpty() {
        return driver.findElements(emptyCartMessageLocator).size() > 0;
    }
}
