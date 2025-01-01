package com.group_29.ui_testing.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtils {
    private final WebDriver driver;
    private final JavascriptExecutor js;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        try {
            WaitUtils.waitForElementClickable(driver, element);
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void type(WebElement element, String text) {
        WaitUtils.waitForElementVisible(driver, element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        WaitUtils.waitForElementVisible(driver, element);
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return WaitUtils.waitForElementVisible(driver, element);
        } catch (Exception e) {
            return false;
        }
    }

    public void selectFromDropdown(WebElement dropdown, String value) {
        WaitUtils.waitForElementVisible(driver, dropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    public void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        WaitUtils.staticWait(1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
