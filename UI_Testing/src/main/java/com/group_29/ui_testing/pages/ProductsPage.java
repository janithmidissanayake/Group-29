package com.group_29.ui_testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartButtons; // List for "Add to Cart" buttons

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;
    @FindBy(css = ".inventory_item:nth-child(1) .btn_inventory")
    private WebElement addToCartButtonForFirstItem;

    @FindBy(css = ".inventory_item:nth-child(1) .btn_secondary")
    private WebElement removeFromCartButtonForFirstItem;
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
}

    public void addFirstItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(0).click(); // Click on the first "Add to cart" button
        }
    }

    public void addSecondItemToCart() {
        if (addToCartButtons.size() > 1) {
            addToCartButtons.get(1).click(); // Click on the second "Add to cart" button
        }
    }

    public String getCartBadgeCount() {
        return cartBadge.isDisplayed() ? cartBadge.getText() : "0";
    }

    public boolean isPageLoaded() {
        return pageTitle.isDisplayed() && pageTitle.getText().equals("Products");
    }
}