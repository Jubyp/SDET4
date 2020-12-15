@HRMJob
Feature: Create Job Vacancy

Scenario: To Create Job Vacancy
    Given User In Login Page
    When User inputs "orange" and "orangepassword123" 
    And Navigate to Recruitment and click Vacancy to navigate to vacany page
    Then Click Add button to navigate to Add Job Vacancy form
    And Fill necessary details and Click Save button
    Then Verify the vacancy is created
    And Close browser
    
 