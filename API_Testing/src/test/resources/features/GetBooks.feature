@GetBooks
Feature: Get Books
  Scenario Outline: Fetch books with different credentials
    Given the GetAllBooks API is up and running
    When I send a "<credentialType>" GETBooks request to "/api/books"
    Then the "<credentialType>" GetBooks response status code should be <statusCode>
    And the "<credentialType>" response should contain a list of books or indicate no books are available

    Examples:
      | credentialType | statusCode |
      | valid          | 200        |
      | invalid        | 401        |