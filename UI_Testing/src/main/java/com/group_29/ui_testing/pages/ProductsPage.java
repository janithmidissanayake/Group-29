package com.group_29.ui_testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage {
    @FindBy(className = "title")
    private WebElement pageTitle;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
}

    @FindBy(css = "[data-test^='add-to-cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;


    public void addItemToCart(int index) {
        addToCartButtons.get(index).click();
    }


    public void navigateToCart() {
        cart.click();
    }
    public boolean isCartBadgeVisible() {
        return cartBadge.isDisplayed();
    }

}