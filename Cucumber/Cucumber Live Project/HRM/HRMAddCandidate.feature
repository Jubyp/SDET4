@HRMAddCandidate
Feature: Add Candidate

Scenario: Add candidate for recruitment
    Given User IN Login Page
    When User keys in "orange" and "orangepassword123" 
    And Navigate to Recruitment and click Candidate to navigate to candidate page
    Then Click Add button to enter candidate details
    And Upload resume and Click Save button
    Then Verify the Candidate is created
    And Closing browser