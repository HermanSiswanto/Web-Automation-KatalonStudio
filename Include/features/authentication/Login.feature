@authentication @smoke
Feature: Login

  As a registered user
  I want to log in to SauceDemo
  So that I can access the inventory page

  Background:
    Given user is on the login page

  @positive
  Scenario: Login with valid credentials
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to the inventory page

  @negative
  Scenario Outline: Login with invalid credentials
    When user logs in with username "<username>" and password "<password>"
    Then login should fail with error message "<errorMessage>"

    Examples:
      | username        | password     | errorMessage                                                              |
      | standard_user   | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      |                 |              | Epic sadface: Username is required                                        |