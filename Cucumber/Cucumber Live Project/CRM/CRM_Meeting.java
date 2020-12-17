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

public class CRM_Meeting {
	
	WebDriver driver;
    WebDriverWait wait;
    

    @Given("^User navigates to Login Page$")
    public void LoginPage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 15);
                 
         //Open the browser
         driver.get("https://alchemy.hguy.co/crm/");
  
 	}
 
	
    @When("^User Enters the \"(.*)\" and \"(.*)\"$")
	public void userValues(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("bigbutton")).click();

    } 
   
    @And("^Navigate to Activites and click on Meetings$")
    public void clickMeeting()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("tab-actions")));
    	//Navigate to Meeting
        driver.findElement(By.id("grouptab_3")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Meetings")));
       WebElement link= driver.findElement(By.xpath("//*[@id = 'moduleTab_9_Meetings']")); 
       link.click();
     
}
    
    @And("^Click on Schedule meeting$")
    public void scheduleMeeting()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
       
    	//Navigate to Schedule Meeting
        driver.findElement(By.linkText("Schedule Meeting")).click();   
      
           
}
    
    @And("^Add \"(.*)\" and \"(.*)\" to meeting$")
    public void addinvite(String FirstMember , String LastMember) throws Throwable  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("invitees_search")));
    	
        //Add invitees
    	WebElement invitee1 = driver.findElement(By.id("search_first_name"));
    	invitee1.sendKeys(FirstMember);
    	driver.findElement(By.id("invitees_search")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("invitees_add_1")).click();
    	invitee1.clear();
    	
    	WebElement invitee2 = driver.findElement(By.id("search_first_name"));
    	invitee2.sendKeys(LastMember);
    	driver.findElement(By.id("invitees_search")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("invitees_add_1")).click();
  
}
    @And("^Enter meeting details and click save$")
    public void details()  {
     
    	//Enter Meeting details
    	driver.findElement(By.id("name")).sendKeys("Overview Meeting");
    	driver.findElement(By.id("description")).sendKeys("Test Meeting");
        driver.findElement(By.id("SAVE_HEADER")).click();
           
}
    
    @Then("^Navigate to View Meetings page and Verify creation of meeting$")
    public void creation()  {
  	  
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
    driver.findElement(By.linkText("View Meetings")).click();
  	 
  	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
  	WebElement data = driver.findElement(By.linkText("Overview Meeting"));
  	String text = data.getText();
  	System.out.println("Meetings heading is :" + text);
  	  
  	Assert.assertEquals(text, "Overview Meeting");
  	
    }
    
  	@And("^Browser Closes$")
    public void closebrowser() {
  		
        //driver.close();
    }
 
  	
    }  
  	

