package com.group_29.ui_testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected final String baseurl = "https://parabank.parasoft.com/parabank/index.htm";


    @BeforeClass
    public void setUp(){
        System.setProperty("web driver.chrome.driver","C:\\Users\\PC\\IdeaProjects\\UI_Testing\\src\\test\\resources\\drivers\\chrome_proxy.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
