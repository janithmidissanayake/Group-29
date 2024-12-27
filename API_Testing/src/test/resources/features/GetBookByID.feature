@GetBookByID
Feature: Books API

  Scenario: Fetch a book by ID with valid credentials
    Given the GetBookByID API is up and running
    When I send a GETBooksByID request to "/api/books/{id}"
    Then the GetBookByID response status code should be 200 or 404
    And the response should contain the book details

  Scenario: Fetch a book with an invalid ID format
    Given the GetBookByID API is up and running
    When I send a invalid formatted GET request to "/api/books/{id}"
    Then the invalid formatted GET request response status code should be 400
#    And the response should contain the message "No response body"