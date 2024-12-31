package com.group_29.ui_testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/group_29/ui_testing/features",
        glue = {"com.group_29.ui_testing.stepDefinitions","com.group_29.utils"},
        plugin ={
                "pretty", // Clean and readable console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json", // JSON report
                "junit:target/cucumber-reports/cucumber.xml" },
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {


}
