package com.group_29.api_testing.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = "com.group_29.api_testing.stepDefinitions", // Path to step definition classes
        plugin = {
                "pretty", // Clean and readable console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json", // JSON report
                "junit:target/cucumber-reports/cucumber.xml" ,// JUnit XML report (optional)
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true// Enable clean and readable output in the console
//        tags = "@GetBooks"// Run scenarios with the @GetBooks tag
)


public class CucmberRunnerTests extends AbstractTestNGCucumberTests{

}
