//package com.group_29.ui_testing.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductsPage {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @FindBy(className = "title")
//    private WebElement pageTitle;
//
//    @FindBy(className = "shopping_cart_link")
//    private WebElement cartLink;
//
//    @FindBy(css = "a[href*='twitter.com']")
//    private WebElement twitterLink;
//
//    @FindBy(css = "a[href*='facebook.com']")
//    private WebElement facebookLink;
//
//    @FindBy(css = "a[href*='linkedin.com']")
//    private WebElement linkedInLink;
//
//    @FindBy(className = "product_sort_container")
//    private WebElement sortDropdown;
//
//    @FindBy(className = "inventory_item_price")
//    private List<WebElement> productPrices;
//
//    @FindBy(className = "inventory_item_name")
//    private List<WebElement> productNames;
//
//    @FindBy(className = "inventory_item_desc")
//    private List<WebElement> productDescriptions;
//
//    @FindBy(xpath = "//button[text()='Add to cart']")
//    private List<WebElement> addToCartButtons; // List for "Add to Cart" buttons
//
//    @FindBy(className = "shopping_cart_badge")
//    private WebElement cartBadge;
//    @FindBy(css = ".inventory_item:nth-child(1) .btn_inventory")
//    private WebElement addToCartButtonForFirstItem;
//
//    @FindBy(css = ".inventory_item:nth-child(1) .btn_secondary")
//    private WebElement removeFromCartButtonForFirstItem;
//    public ProductsPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    public String getPageTitle() {
//        return pageTitle.getText();
//}
//
//    public void addFirstItemToCart() {
//        if (!addToCartButtons.isEmpty()) {
//            addToCartButtons.get(0).click(); // Click on the first "Add to cart" button
//        }
//    }
//
//    public void addSecondItemToCart() {
//        if (addToCartButtons.size() > 1) {
//            addToCartButtons.get(1).click(); // Click on the second "Add to cart" button
//        }
//    }
//
//    public String getCartBadgeCount() {
//        return cartBadge.isDisplayed() ? cartBadge.getText() : "0";
//    }
//
//    public boolean isPageLoaded() {
//        return pageTitle.isDisplayed() && pageTitle.getText().equals("Products");
//    }
//        return wait.until(ExpectedConditions.visibilityOf(pageTitle)).getText();
//    }
//
//    public void addProductToCart(String productName) {
//        String buttonXPath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
//        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
//        addButton.click();
//    }
//
//    public void removeProduct(String productName) {
//        String buttonXPath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
//        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
//        removeButton.click();
//    }
//
//    public void goToCart() {
//        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
//    }
//
//    public void clickSocialLink(String platform) {
//        WebElement link = switch (platform.toLowerCase()) {
//            case "twitter" -> twitterLink;
//            case "facebook" -> facebookLink;
//            case "linkedin" -> linkedInLink;
//            default -> throw new IllegalArgumentException("Unsupported platform: " + platform);
//        };
//        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
//    }
//
//    public String getCurrentUrl() {
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        return driver.getCurrentUrl();
//    }
//
//    public void selectSortOption(String option) {
//        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)));
//        select.selectByVisibleText(option);
//    }
//
//    public List<Double> getProductPrices() {
//        List<Double> prices = new ArrayList<>();
//        for (WebElement priceElement : wait.until(ExpectedConditions.visibilityOfAllElements(productPrices))) {
//            String priceText = priceElement.getText().replace("$", "");
//            prices.add(Double.parseDouble(priceText));
//        }
//        return prices;
//    }
//
//    public List<String> getProductNames() {
//        return wait.until(ExpectedConditions.visibilityOfAllElements(productNames))
//                .stream()
//                .map(WebElement::getText)
//                .toList();
//    }
//
//    public boolean isPriceSortingIncorrect() {
//        List<Double> prices = getProductPrices();
//        for (int i = 0; i < prices.size() - 1; i++) {
//            if (prices.get(i) > prices.get(i + 1)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String getCurrentSortOption() {
//        Select select = new Select(sortDropdown);
//        return select.getFirstSelectedOption().getText();
//    }
//
//    public boolean isProductDisplayed(String productName) {
//        return driver.findElements(By.xpath("//div[text()='" + productName + "']")).size() > 0;
//    }
//
//    public void switchToMainWindow() {
//        driver.switchTo().window(driver.getWindowHandles().iterator().next());
//    }
//}
package com.group_29.ui_testing.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = "a[href*='twitter.com']")
    private WebElement twitterLink;

    @FindBy(css = "a[href*='facebook.com']")
    private WebElement facebookLink;

    @FindBy(css = "a[href*='linkedin.com']")
    private WebElement linkedInLink;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "inventory_item_desc")
    private List<WebElement> productDescriptions;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(css = ".inventory_item:nth-child(1) .btn_inventory")
    private WebElement addToCartButtonForFirstItem;

    @FindBy(css = ".inventory_item:nth-child(1) .btn_secondary")
    private WebElement removeFromCartButtonForFirstItem;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOf(pageTitle)).getText();
    }

    public void addFirstItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonForFirstItem)).click();
    }

//    public void addSecondItemToCart() {
//        if (addToCartButtons.size() > 1) {
//            wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(1))).click();
//        }
//    }

    public String getCartBadgeCount() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(cartBadge)).getText();
        } catch (TimeoutException e) {
            return "0";
        }
    }

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOf(pageTitle)).isDisplayed() &&
                pageTitle.getText().equals("Products");
    }

    public void addProductToCart(String productName) {
        String buttonXPath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
        addButton.click();
    }

    public void removeProduct(String productName) {
        String buttonXPath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
        removeButton.click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void clickSocialLink(String platform) {
        WebElement link = switch (platform.toLowerCase()) {
            case "twitter" -> twitterLink;
            case "facebook" -> facebookLink;
            case "linkedin" -> linkedInLink;
            default -> throw new IllegalArgumentException("Unsupported platform: " + platform);
        };
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }

    public String getCurrentUrl() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public void selectSortOption(String option) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)));
        select.selectByVisibleText(option);
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : wait.until(ExpectedConditions.visibilityOfAllElements(productPrices))) {
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    public List<String> getProductNames() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(productNames))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isPriceSortingIncorrect() {
        List<Double> prices = getProductPrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentSortOption() {
        Select select = new Select(sortDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath("//div[text()='" + productName + "']")).isEmpty();
    }

    public void switchToMainWindow() {
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
}