package com.group_29.api_testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.group_29.api_testing.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class  RunCucumberTest extends AbstractTestNGCucumberTests {
}
