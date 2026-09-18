@Inventory
Feature: Inventory Catalog Management
  As a logged-in user
  I want to browse the product catalog and manage items
  So that I can select products to purchase accurately

  Background:
    Given user is logged in with valid credentials
    Then user should be redirected to the inventory page

  Scenario: Verify product details and image integrity in catalog
    And user verifies product image for "Sauce Labs Backpack" is displayed correctly
    And user should see product "Sauce Labs Backpack" details with price "$29.99" and description "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
    And user should see total 6 products in the catalog

  Scenario: Add multiple products to the cart
    When user adds the following products to the cart:
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |

  Scenario: Add and remove product from cart via inventory page
    When user adds product "Sauce Labs Backpack" to the cart
    And user removes product "Sauce Labs Backpack" from the inventory page

  Scenario Outline: Sort products catalog
    When user sorts the products by "<sort_option>"
    Then user should see products sorted by "<expected_sorting>"

    Examples:
      | sort_option         | expected_sorting  |
      | Name (A to Z)       | Name A to Z       |
      | Name (Z to A)       | Name Z to A       |
      | Price (low to high) | Price low to high |
      | Price (high to low) | Price high to low |
