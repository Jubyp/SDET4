@JobsSearchJobs
Feature: Search for jobs

Scenario: Search for jobs and apply to them
    Given Alchemy Job site launched
    When User navigate to Jobs and find Keywords search input field
    And Enter Keyword for job search and change job type
    And Filter job type to show only Full Time jobs
    And Find job listing and check job details and print it
    Then Click on the Apply for job button
    And The Browser is Closed
