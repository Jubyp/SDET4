@HRMMultipleJobVacancy
Feature: Create Multiple Job Vacancy

Scenario: To Create Multiple Job Vacancy
    Given User In Login Page
    When User inputs "orange" and "orangepassword123" 
    And Navigate to Recruitment and click Vacancy to navigate to vacany page
    Then Click Add button to navigate to Add Job Vacancy form
    And Fill necessary details "<JobTitle>" and "<VacancyName>" and "<HiringManager>"
    Then Verify the vacancy is created "<VacancyName>"
    And Close browser
    
    
   Examples:
| JobTitle  | VacancyName  	| HiringManager 	|
| DevOps Engineer | Vacancy3 	|     orange hrm	|
| Java Developer  | Vacancy4 	|     orange hrm 	|