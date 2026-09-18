@checkoutOverview @regression
Feature: Checkout Overview
  As a customer who entered checkout information
  I want to review my order summary
  So that I can confirm the amount before placing the order

  Background:
    Given user is logged in with valid credentials
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    And user clicks the Checkout button
    And user submits checkout information with first name "Herman", last name "Siswanto", and postal code "12345"
    Then user should be on the Checkout Overview page

  Scenario: Verify checkout totals
    Then checkout overview should show item total "$29.99", tax "$2.40", and total "$32.39"

  Scenario: Cancel checkout from the overview page
    When user cancels checkout from the overview page
    Then user should be redirected to the inventory page
