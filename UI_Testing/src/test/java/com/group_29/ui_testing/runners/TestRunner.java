package com.group_29.ui_testing.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.group_29.ui_testing.stepdefinitions"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@smoke"
)

public class TestRunner extends AbstractTestNGCucumberTests{
        }