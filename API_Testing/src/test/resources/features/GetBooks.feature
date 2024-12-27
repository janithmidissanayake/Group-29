@GetBooks
Feature: Get API
  Scenario: Fetch all books with valid credentials
    Given the GetAllbooks API is up and running
    When I send a valid credential GETBooks request to "/api/books"
    Then the valid credential GetBooks response status code should be 200
    And the response should contain a list of books or indicate no books are available

  Scenario: Fetch all books with invalid credentials
    Given the GetAllbooks API is up and running
    When I send an invalid credential GETBooks request to "/api/books"
    Then the invalid credential GetBooks response status code should be 401
