Feature: Social Media Links
  As a user
  I want to check social media links
  So that I can follow the company on different platforms

  @smoke
  Scenario Outline: Verify social media links
    Given I am already on the products page
    When I click on "<platform>" link
    Then I should be redirected to "<url>"

    Examples:
      | platform  | url                                           |
      | Twitter   | https://x.com/saucelabs              |
      | Facebook  | https://web.facebook.com/saucelabs?_rdc=1&_rdr           |
      | LinkedIn  | https://www.linkedin.com/company/sauce-labs |