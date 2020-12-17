@SuiteJob
Feature: Posting jobs with Example

Scenario: Post a job using Example data
    Given Alchemy Job site launchs
    When User navigate to Post A Job and Sign In
    And Enter data"<Job Title>"and"<Location>"and"<Description>"and"<Email>"
    And Click on Submit Listing
    Then Navigate to Job Page and confirm listing
    And The Browser must be Closed
    
    
    Examples:
| Job Title  | Location  	| Description 	| Email	|
| System Engineer | Chennai | Looking for System Engineer | test@test.com |


