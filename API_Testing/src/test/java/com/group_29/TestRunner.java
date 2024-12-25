package com.group_29;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/PostBook.feature", // Path to feature file
        glue = "com.group_29" // Path to step definitions package
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
