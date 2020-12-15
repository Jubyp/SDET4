@HRMMultipleEmployee
Feature: Add multiple employees

Scenario: Add multiple employees using an the Examples table
    Given User Login Page
    When User Inputs "orange" and "orangepassword123" 
    And Navigate to PIM and click it
    And Click Add button to navigate to Add Employee
    And Fill necessary details "<Firstname>"and"<Lastname>"
    Then Click Save and Verify the employees are created "<EmployeeID>"
    And Browser close
    
    
    Examples:
| Firstname  | Lastname  	| EmployeeID 	|
| ABCD  	 	 | password1 	|       2550	|
| DBBB    		 | password2 	|       2551 	|
 