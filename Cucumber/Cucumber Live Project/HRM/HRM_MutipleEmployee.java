package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRM_MutipleEmployee {

	WebDriver driver;
    WebDriverWait wait;
	

    @Given("^User Login Page$")
    public void LoginPage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 40);
                 
         //Open the browser
         driver.get("http://alchemy.hguy.co/orangehrm");
 
 	}
    @When("^User Inputs \"(.*)\" and \"(.*)\"$")
	public void userValues(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("txtUsername")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("txtPassword")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("btnLogin")).click();

    } 
    
    @And("^Navigate to PIM and click it$")
    public void PIM()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MP_link")));
    	// Navigate to PIM
       driver.findElement(By.id("menu_pim_viewPimModule")).click();
       driver.findElement(By.id("menu_pim_viewPimModule")).click();
     
    } 
    
    @And("^Click Add button to navigate to Add Employee$")
    public void addButton()  {
    	
    	//Add Employee
      
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Add Employee")).click();
       
  
  } 
    
    @And("^Fill necessary details \"(.*)\"and\"(.*)\"$")
    public void addData(String Firstname, String Lastname) throws Throwable{
    	// Enter Firstname
	    WebElement First_Name = driver.findElement(By.xpath("//input[@id = 'firstName']"));	    
	    First_Name.sendKeys(Firstname);
	    // Enter Lastname
        WebElement  Last_Name= driver.findElement(By.xpath("//input[@id='lastName']"));
        Last_Name.sendKeys(Lastname);
        
  
  }   
    
   
    @Then("^Click Save and Verify the employees are created \"(.*)\"$")
    public void employee(String EmployeeID ) throws Throwable  {
    	
    	driver.findElement(By.id("btnSave")).click();
    	
    	//Verify Employee created
    	
    	driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchBtn")));
    	driver.findElement(By.id("empsearch_id")).sendKeys(EmployeeID);
    	
    	driver.findElement(By.id("searchBtn")).click();
    	
    	String empid = driver.findElement(By.linkText(EmployeeID)).getText();
    	System.out.println("value is :" +empid);
    	Assert.assertEquals(empid, EmployeeID);

  } 
    
    @And("^Browser close$")
    public void closeBrowser() {
        driver.close();
 	   
    }
    
	}


