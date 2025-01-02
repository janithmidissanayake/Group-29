package com.group_29.ui_testing.pages;

import com.group_29.ui_testing.utils.BaseTest;
import com.group_29.ui_testing.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

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


    }


}
