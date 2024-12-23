@GetBookByID
Feature: Books API

  Scenario: Fetch a book by ID with valid credentials
    Given the GetBookByID API is up and running
    When I send a GETBooksByID request to "/api/books/{id}" with username "admin" and password "password"
    Then the GetBookByID response status code should be 200
    And the response should contain the book details
