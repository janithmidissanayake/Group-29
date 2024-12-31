package com.group_29.ui_test.pages;

import com.group_29.ui_test.utils.BaseTest;
import com.group_29.ui_test.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
//import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        ConfigReader configReader = new ConfigReader();
        String username = configReader.getUsername();
        String password = configReader.getPassword();

        // Use the username and password to perform login actions
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        // Add additional actions such as clicking the login button
    }


}
