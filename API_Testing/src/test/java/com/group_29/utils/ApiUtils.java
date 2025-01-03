package com.group_29.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {
    public static Response sendGetRequest(String endpoint, String username, String password) {
        return RestAssured.given()
                .auth()
                .basic(username, password)
                .when()
                .get(endpoint);
    }


    public static Response sendDeleteRequest(String endpoint, String username, String password) {
        return RestAssured.given()
                .auth()
                .basic(username, password)
                .when()
                .delete(endpoint);

    public static RequestSpecification sendPutRequest(String endpoint, String username, String password,String payload) {
        return RestAssured.given()
                .auth()
                .basic(username, password)
                .header("Content-Type", "application/json")
                .body(payload);


    }
}
