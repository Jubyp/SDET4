package stepDefinitions;

import java.util.concurrent.TimeUnit;

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

public class CRM_CreateLead {

	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User on Login Page$")
   public void LoginPage()  {
    	 //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
                
        //Open the browser
        driver.get("https://alchemy.hguy.co/crm/");
 
	}
    
    @When("^User enters \"(.*)\" and \"(.*)\"$")
	public void userValues(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("bigbutton")).click();
	
    } 
   
    @And("^Navigate to Sales$")
    public void sales()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("tab-actions")));
    	//Navigate to Leads
       driver.findElement(By.id("grouptab_0")).click();
       System.out.println("Element found");
       
    }
 
    @And("^Select Leads$")
    public void select()  {
      
    	WebElement buttonLead =driver.findElement(By.xpath("//*[@id = 'moduleTab_9_Leads']"));
    	wait.until(ExpectedConditions.elementToBeClickable(buttonLead));
       // WebElement buttonLead =driver.findElement(By.partialLinkText("Leads"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        buttonLead.click();
        System.out.println("Element 1 found"); 
        
    }
    
    
    @And("^Click on Create Leads$")
    public void createLead()  { 
       
      
      //Create Leads
      driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
      
      driver.findElement(By.linkText("Create Lead")).click();
      System.out.println("Element 2 found");
   
    } 
   
  @And("^Fill necessary details from file \"(.*)\" and \"(.*)\"$")
    public void values(String FirstName, String LastName) throws Throwable   {
    	
	  WebElement firstname = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
  	wait.until(ExpectedConditions.elementToBeClickable(firstname));
  	firstname.sendKeys(FirstName);
  	
  	WebElement lastname = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
  	wait.until(ExpectedConditions.elementToBeClickable(lastname));
  	lastname.sendKeys(LastName);	 
 
  }
   
  @And("^Click Save to Finish$")
  public void save() {
	  driver.findElement(By.id("SAVE")).click();
	  System.out.println("Saved");
  }
  
  @Then("^Navigate to View leads page and Verfiy New Lead created$")
  public void count()  {
	  
	  driver.findElement(By.cssSelector("li.actionmenulinks:nth-child(4) > a:nth-child(1) > div:nth-child(2)")).click();
	  System.out.println("Data found");
	
  }
    
    @And("^Close the browser$")
    public void closeBrowser() {
        driver.close();
    }
   
    
}
