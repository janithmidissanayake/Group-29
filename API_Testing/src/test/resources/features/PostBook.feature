Feature: Add new book to the system

  Scenario: Admin adds a new book successfully
    Given POST book API is running
    When I send a POST request to "/api/books" with the book details as admin
    Then I should receive a response with status code 201
    And the response should contain the book's id

  Scenario: User tries to add a new book
    Given POST book API is running
    When I send a POST request to "/api/books" with the book details as user
    Then I should receive a response with status code 201
    And the response should contain the book's id

  Scenario: Admin tries to add a book with an integer as the author(BUG EXPECTED)
    Given POST book API is running
    When I send a POST request to "/api/books" with an integer as the author
    Then I should receive a response with status code 400
    And the response should contain an error message "Invalid data type for author"


  Scenario: Admin adds a book with unexpected attributes in the payload(BUG EXPECTED)
    Given POST book API is running
    When I send a POST request to "/api/books" with the book details and additional attributes
    Then I should receive a response with status code 400
    And the response should contain an error message "Unexpected attribute in request body"


  Scenario: Admin sends a POST request with missing values in the payload(BUG EXPECTED)
    Given POST book API is running
    When I send a POST request to "/api/books" with missing values
    Then I should receive a response with status code 400
    And the response should contain the message "Fields 'title' and 'author' cannot be null or empty"