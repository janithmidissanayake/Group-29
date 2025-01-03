#@regression
#Feature: Product Images Verification
#  As a user
#  I want to verify that product images are displaying correctly
#
#  @smoke
#  Scenario: Verify unique product images are displayed for each product
#    Given I am on the products page
#    When I get all product images source URLs
#    Then each product should have a unique image
