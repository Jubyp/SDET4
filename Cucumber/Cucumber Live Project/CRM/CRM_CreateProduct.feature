@CRMProduct
Feature: Creating a Product

Scenario Outline: To add products with Example
    Given User Navigates to Login Page
    When User keyin the "admin" and "pa$$w0rd" 
    And Navigate to All and click on Products
    And Click on Create Product
    And Enter "<ProductName>" and "<Price>" to product details and save
    Then Navigate to View Products page for all products
    And Browser Close
    
    
    Examples:
| ProductName  | Price |
| Product1	 	 | $200.00	|    
