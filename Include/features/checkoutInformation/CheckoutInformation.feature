@checkoutInformation @regression
Feature: Checkout Information
  As a customer with an item in the cart
  I want to submit my checkout information
  So that I can continue to the order overview

  Background:
    Given user is logged in with valid credentials
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    And user clicks the Checkout button
    Then user should be directed to the Checkout Information Page

  Scenario: Submit complete checkout information
    When user submits checkout information with first name "Herman", last name "Siswanto", and postal code "12345"
    Then user should be redirected to the checkout overview page

  Scenario Outline: Show validation error for incomplete checkout information
    When user submits checkout information with first name "<first_name>", last name "<last_name>", and postal code "<postal_code>"
    Then checkout information should show error message "<error_message>"

    Examples:
      | first_name | last_name | postal_code | error_message                  |
      |            | Siswanto  | 12345       | Error: First Name is required  |
      | Herman     |           | 12345       | Error: Last Name is required   |
      | Herman     | Siswanto  |             | Error: Postal Code is required |
