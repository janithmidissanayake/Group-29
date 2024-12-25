package com.group_29;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class APITest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URL of the application
    }
}
