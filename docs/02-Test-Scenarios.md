# Test Scenarios (Gherkin)

## Feature: User Authentication

As a customer
I want to log into SauceDemo
So that I can purchase products.

---

### Scenario Outline: Login with different user credentials

Given the user opens the SauceDemo login page
When the user enters username "<username>"
And the user enters password "<password>"
And the user clicks the Login button
Then the system should display "<result>"

Examples:

| username | password | result |
|----------|----------|--------|
| standard_user | secret_sauce | Inventory Page |
| locked_out_user | secret_sauce | Locked Out Error Message |
| standard_user | wrong_password | Invalid Credential Error Message |

---

## Feature: Shopping Cart

As a customer
I want to add products into my shopping cart
So that I can purchase them later.

---

### Scenario: Add multiple products into shopping cart

Given the user has logged in successfully
When the user adds the following products

| Product |
|---------|
| Sauce Labs Backpack |
| Sauce Labs Bike Light |
| Sauce Labs Onesie |

Then the shopping cart badge should display "3"

---

### Scenario: Open shopping cart

Given the user has products in the cart
When the user clicks the shopping cart icon
Then all selected products should be displayed

---

## Feature: Checkout

As a customer
I want to checkout my products
So that I can complete my purchase.

---

### Scenario: Successful checkout

Given the user has products in the cart
When the user proceeds to checkout
And enters valid customer information
Then the order should be completed successfully

---

### Scenario Outline: Checkout with incomplete information

Given the user has products in the cart
When the user proceeds to checkout
And leaves "<field>" empty
Then the system should display the corresponding validation message

Examples:

| field |
|-------|
| First Name |
| Last Name |
| Postal Code |
