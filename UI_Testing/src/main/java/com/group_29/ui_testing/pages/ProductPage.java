package com.group_29.ui_testing.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addToCartButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private final By removeButton = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By productImages = By.cssSelector(".inventory_item_img img");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductToCart() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            button.click();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Add to Cart button is not clickable within the timeout period.", e);
        }
    }

    public void removeProduct() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
            button.click();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Remove button is not clickable within the timeout period.", e);
        }
    }

    public int getCartCount() {
        try {
            WebElement badge = driver.findElement(cartBadge);
            Integer.parseInt(badge.getText());
            return Integer.parseInt(badge.getText());

        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public List<String> getAllProductImageSources() {
        List<WebElement> images = driver.findElements(productImages);
        return images.stream()
                .map(img -> img.getAttribute("src"))
                .collect(Collectors.toList());
    }

    public boolean areAllImagesIdentical() {
        List<String> imageSources = getAllProductImageSources();
        return imageSources.stream()
                .distinct()
                .count() == 1;
    }

    public int getUniqueImageCount() {
        return getAllProductImageSources().stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }


}
