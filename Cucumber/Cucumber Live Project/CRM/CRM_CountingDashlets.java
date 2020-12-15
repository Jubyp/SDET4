package stepDefinitions;

import java.util.List;
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

public class CRM_CountingDashlets {

	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is in Login Page$")
   public void LoginPage()  {
    	 //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 50);
                
        //Open the browser
        driver.get("https://alchemy.hguy.co/crm/");
 
	}
    
    @When("^User enter \"(.*)\" and \"(.*)\"$")
	public void userValues(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("bigbutton")).click();
	
    } 
    
    @Then("^Count number of dashlets and Print number and title of Dashlet$")
    public void count()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dashboard")));
        
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        //Count number of dashlet
      List<WebElement> totalcount= driver.findElements(By.xpath("//div[contains(@id,'dashlet_header_')]"));
      System.out.println("Element found");
      
      int size = totalcount.size();
      System.out.println("Total Count is : " + size); 
      
      for (WebElement value : totalcount) {
    	String titles = value.getText();  
       System.out.println("Titles is : " + titles); 
      
     
     }
    
    }
 
  
    @And("^Close the BRowser$")
    public void closeBrowser() {
        driver.close();
    }
    
	}


