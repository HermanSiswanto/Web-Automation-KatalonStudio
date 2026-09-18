@cart @regression
Feature: Cart Page Functionality

  As a logged-in user
  I want to manage products in my shopping cart
  So that I can continue shopping or proceed to checkout

  Background:
    Given user is logged in with valid credentials
    Then user should be redirected to the inventory page

  Scenario: Verify product is displayed in the cart
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    Then user should be on the cart page
    And user should see product name "Sauce Labs Backpack" and price "$29.99" in the cart
    And the cart should contain 1 item
    And cart badge should display "1"

  Scenario: Remove product from the cart
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    And user removes "Sauce Labs Backpack" from the cart page
    Then the cart page should be empty
    And cart badge should not be visible

  Scenario: Continue shopping from cart
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    Then user should be on the cart page
    When user clicks the Continue Shopping button
    Then user should be redirected back to the inventory page

  Scenario: Proceed to checkout from cart
    When user adds product "Sauce Labs Backpack" to the cart
    And user clicks on shopping cart icon
    Then user should be on the cart page
    When user clicks the Checkout button
    Then user should be directed to the Checkout Information Page