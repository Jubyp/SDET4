@activity2_5
Feature: Login Test with Example

Scenario Outline: Testing Login with Examples
    Given User is on Login Page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the Browser
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |