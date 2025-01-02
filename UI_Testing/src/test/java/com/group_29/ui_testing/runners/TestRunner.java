package com.group_29.ui_testing.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.group_29.ui_testing.stepdefinitions"},
        tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests{
        }