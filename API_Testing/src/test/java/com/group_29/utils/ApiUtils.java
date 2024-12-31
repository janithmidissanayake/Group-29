package com.group_29.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    public static Response sendGetRequest(String endpoint, String username, String password) {
        return RestAssured.given()
                .auth()
                .basic(username, password)
                .when()
                .get(endpoint);
    }
}