@GetBooks
Feature: Get Book By Id

  Scenario: Fetch a book by ID with valid admin credentials
    Given the GetBookByID API is up and running
    When I send a GETBooksByID request to "/api/books/{id}" with admin credentials
    Then the GetBookByID response status code should be 200 or 404 not 403
    And the response should contain the book details

  Scenario: Fetch a book by ID with valid user credentials (BUG EXPECTED)
    Given the GetBookByID API is up and running
    When I send a GETBooksByID request to "/api/books/{id}" with user credentials
    Then the GetBookByID response status code should be 200 or 404 not 403
    And the response should contain the book details

  Scenario: Fetch a book with an invalid ID format
    Given the GetBookByID API is up and running
    When I send a invalid formatted GET request to "/api/books/{id}"
    Then the invalid formatted GET request response status code should be 400




