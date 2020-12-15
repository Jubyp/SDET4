 @CRMDashlet
Feature: Counting Dashlets

Scenario: Open Homepage and count number of dashlets on page
    Given User is in Login Page
    When User enter "admin" and "pa$$w0rd" 
    Then Count number of dashlets and Print number and title of Dashlet
    And Close the BRowser