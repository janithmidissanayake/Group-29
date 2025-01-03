//package com.group_29.ui_testing.pages;
//
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class NavigationPage {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @FindBy(id = "react-burger-menu-btn")
//    private WebElement menuButton;
//
//    @FindBy(id = "inventory_sidebar_link")
//    private WebElement allItemsLink;
//
//
//    @FindBy(id = "logout_sidebar_link")
//    private WebElement logoutLink;
//
//    @FindBy(id = "shopping_cart_container")
//    private WebElement cartLink;
//
//    public NavigationPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    public void clickMenuButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
//        wait.until(ExpectedConditions.visibilityOf(logoutLink));
//    }
//
//    public void clickLogoutLink() {
//        String currentUrl = driver.getCurrentUrl();
//        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
//        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
//    }
//
//    public boolean isOnLoginPage() {
//        wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/"));
//        return driver.getCurrentUrl().endsWith("https://www.saucedemo.com/");
//    }
//
//    public boolean checkAllItemsLink() {
//        return wait.until(ExpectedConditions.visibilityOf(allItemsLink)).isDisplayed();
//    }
//
//    public void navigateToCart() {
//        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
//    }
//
//
//    public String getUrl() {
//        return driver.getCurrentUrl();
//    }
//
//    public void waitForUrlChange() {
//        String currentUrl = driver.getCurrentUrl();
//        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
//    }
//}
