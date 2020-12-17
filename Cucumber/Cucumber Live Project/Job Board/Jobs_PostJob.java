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

public class Jobs_PostJob {

	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^Alchemy Job site launchs$")
    public void homepage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 40);
                 
         //Open the browser
         driver.get("https://alchemy.hguy.co/jobs/");	

 	}
    
    @When("^User navigate to Post A Job and Sign In$")
    public void signin()  {
    		
    	driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
	    
          wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class= 'entry-title']"))));
            driver.findElement(By.linkText("Sign in")).click();
            
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='user_login']"))));
        	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        	driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        	driver.findElement(By.id("wp-submit")).click();
        	
 	}
   
  
    
    @And("^Enter data\"(.*)\"and\"(.*)\"and\"(.*)\"and\"(.*)\"$")	
    public void data(String jobtitle, String location, String Description, String Applicationemail) throws Throwable {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("entry-title")));  
    			
	    WebElement jobTitle = driver.findElement(By.xpath("//input[@id = 'job_title']"));	    
	    jobTitle.sendKeys(jobtitle);
	   
	    Thread.sleep(1000);
	    
        WebElement Location= driver.findElement(By.xpath("//input[@id='job_location']"));
        Location.sendKeys(location);
        
        Thread.sleep(1000);
        
        //Enter description
     
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")));
       
        WebElement description= driver.findElement(By.xpath("//body[@id='tinymce']"));
        description.sendKeys(Description);
        Thread.sleep(1500);
        driver.switchTo().defaultContent();
        
        //Enter email
       WebElement email = driver.findElement(By.id("application"));
       email.clear();
       Thread.sleep(2000);
        email.sendKeys(Applicationemail);
        Thread.sleep(1500);
        System.out.println("Email entered"); 
        
    }
    
    @And("^Click on Submit Listing$")
    public void submit() throws InterruptedException  {
    	
    	driver.findElement(By.xpath("//input[@value='Preview']")).click();
        
        driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
        System.out.println("Job listing submitted");
    	 
 	}
   
    @Then("^Navigate to Job Page and confirm listing$")
    public void confirm() throws InterruptedException  {
    	
    	driver.findElement(By.linkText("click here")).click();
    	
    	String title = driver.getTitle();
        System.out.println("Title is: " + title);
         
        Assert.assertEquals(title, "System Engineer – Alchemy Jobs");
        System.out.println("Job posted successfully"); 
        
    }
    
  
    @And("^The Browser must be Closed$")
    public void closeBrowser() {
       driver.close();
     
    }

	}

