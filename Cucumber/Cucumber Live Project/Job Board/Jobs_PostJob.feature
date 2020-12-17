@SuiteJob
Feature: Posting jobs

Scenario: Post a job using details from Feature file
    Given Alchemy Job site launchs
    When User navigate to Post A Job and Sign In
    And Enter data"System Engineer"and"Delhi"and"Looking for System Engineer"and"cloud@test.com"
    And Click on Submit Listing
    Then Navigate to Job Page and confirm listing
    And The Browser must be Closed