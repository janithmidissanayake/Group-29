@GetBooks
Feature: Get API
  Scenario: Fetch all books with valid credentials
    Given the GetAllbooks API is up and running
    When I send a GETBooks request to "/api/books" with username "admin" and password "password"
    Then the GetBooks response status code should be 200
    And the response should contain a list of books or indicate no books are available
