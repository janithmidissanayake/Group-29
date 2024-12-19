package com.group_29;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetBooksTest extends APITest {
    @Test
    public void getAllBooks() {
        Response response = given()
                .auth().basic("admin", "password") // Basic Authentication
                .when()
                .get("/api/books")
                .then()
                .statusCode(200) // Assert HTTP Status Code
                .extract()
                .response();

        Assert.assertTrue(response.jsonPath().getList("").size() > 0, "Book list is empty!");
    }

    @Test
    public void getBookById() {
        int bookId = 1; // Replace with a valid ID from your dataset
        given()
                .auth().basic("admin", "password")
                .when()
                .get("/api/books/" + bookId)
                .then()
                .statusCode(200) // Assert HTTP Status Code
                .body("id", org.hamcrest.Matchers.equalTo(bookId)); // Assert specific fields
    }
}
