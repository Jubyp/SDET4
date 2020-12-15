	@CRMLead
Feature: Create leads

Scenario Outline: Open Leads page and add multiple lead accounts using Feature file
    Given User on Login Page
    When User enters "admin" and "pa$$w0rd" 
    And Navigate to Sales
    And Select Leads
    And Click on Create Leads
    And Fill necessary details from file "<Firstname>" and "<LastName>"
    And Click Save to Finish
    Then Navigate to View leads page and Verfiy New Lead created
    And Close the browser
  
    
     Examples:
| Firstname  | Lastname  	| 
| ABCD  	 	 | ADD	|      
| DBDB    	 | DBC	|   
 