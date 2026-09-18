@checkoutComplete @e2e @regression
Feature: Checkout Complete
  As a customer who reviewed the checkout overview
  I want to complete the order
  So that I receive confirmation and can return to the catalog

  Background:
    Given user is logged in with valid credentials
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    And user clicks the Checkout button
    And user submits checkout information with first name "Herman", last name "Siswanto", and postal code "12345"
    Then user should be on the Checkout Overview page
    When user finishes checkout from the overview page
    Then user should be on the Checkout Complete page

  Scenario: Show successful order confirmation annd return to inventory
    Then order confirmation should be "Thank you for your order!"
    When user clicks the Back Home button
    Then user should be redirected to the inventory page
