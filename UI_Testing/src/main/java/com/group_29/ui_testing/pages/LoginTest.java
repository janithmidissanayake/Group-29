package com.group_29.ui_testing.pages;

import com.group_29.ui_testing.utils.ConfigurationManager;
import com.group_29.ui_testing.utils.DriverManager;
import com.group_29.ui_testing.utils.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTest {
    private final WebDriver driver;
    private final PageUtils pageUtils;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginTest(){
        this.driver = DriverManager.getDriver();
        this.pageUtils = new PageUtils(driver);
        PageFactory.initElements(driver, this);
    }
    

    public void login() {
        login(
                ConfigurationManager.getProperty("username.problem"),
                ConfigurationManager.getProperty("password.default")
        );
    }

    public void login(String username, String password) {
        driver.get(ConfigurationManager.getProperty("base.url"));

        pageUtils.type(usernameField, username);
        pageUtils.type(passwordField, password);
        pageUtils.click(loginButton);
    }
}
