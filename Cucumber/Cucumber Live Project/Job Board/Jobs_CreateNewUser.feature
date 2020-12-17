@JobsCreateNewUser
Feature: Create a new user

Scenario: Visit the site backend and create a new user
    Given User Logs In
    When User input "root" and "pa$$w0rd" 
    And Click on left menu and Click the menu Users
    And Click on Add New button
    And Fill mandatory details and Click Add New User button
    Then Verify User is created
    And Browser Closed
