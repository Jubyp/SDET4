package stepDefinitions;

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

public class CRM_CreateProduct {
	
	WebDriver driver;
    WebDriverWait wait;

    @Given("^User Navigates to Login Page$")
    public void LoginPage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 20);
                 
         //Open the browser
         driver.get("https://alchemy.hguy.co/crm/");

 	}
 
	
    @When("^User keyin the \"(.*)\" and \"(.*)\"$")
	public void Values(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("bigbutton")).click();
 
    } 

    @And("^Navigate to All and click on Products$")
    public void product() throws InterruptedException  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("tab-actions")));
    	//Navigate to All and Product
        driver.findElement(By.id("grouptab_5")).click();
        
        Thread.sleep(1000);
        
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Products")));
        //WebElement dropdown = driver.findElement(By.xpath("//*[@id = 'moduleTab_9_Products']"));
        WebElement dropdown= driver.findElement(By.linkText("Products"));
       dropdown.click();
       dropdown.click();
    
}
  
    @And("^Click on Create Product$")
    public void createProduct()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
       
    	//Navigate to Create Product
        driver.findElement(By.linkText("Create Product")).click();   
        
}
    
    @And("^Enter \"(.*)\" and \"(.*)\" to product details and save$")
    public void addinvite(String ProductName , String Price) throws Throwable  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("CANCEL")));
        
        //Add product details
        WebElement product1 = driver.findElement(By.id("name"));
        product1.sendKeys(ProductName);
        WebElement price1 = driver.findElement(By.id("price"));
        price1.sendKeys(Price);
      
        driver.findElement(By.id("SAVE")).click();
	}
 
    @Then("^Navigate to View Products page for all products$")
    public void viewProduct()  {
  	  
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
    driver.findElement(By.linkText("View Products")).click();
  	 
  	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
  	WebElement data = driver.findElement(By.linkText("Product1"));
  	String text = data.getText();
  	System.out.println("Product heading is :" + text);
  	  
  	Assert.assertEquals(text, "Product1");
  	
    }
    
    @And("^Browser Close$")
    public void closebrowser() {
  		
       driver.close();
    }
 
    
}


