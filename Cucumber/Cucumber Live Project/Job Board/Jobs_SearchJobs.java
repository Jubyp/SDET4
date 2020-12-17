package stepDefinitions;


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

public class Jobs_SearchJobs {

	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^Alchemy Job site launched$")
    public void homepage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 20);
                 
         //Open the browser
         driver.get("https://alchemy.hguy.co/jobs/");	

 	}
    
    @When("^User navigate to Jobs and find Keywords search input field$")
    public void searchInput()  {
    		
        driver.findElement(By.linkText("Jobs")).click();
        //Find the keyword field	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("entry-title")));
        driver.findElement(By.id("search_keywords")).click(); 

 	}
   
    @And("^Enter Keyword for job search and change job type$")
    public void changeJob() throws InterruptedException  {
    	driver.findElement(By.id("search_keywords")).sendKeys("Developer");
    	Thread.sleep(1500);
    	//Change job type
    	WebElement checkbox = driver.findElement(By.xpath("//input[@id='job_type_freelance']"));
    	checkbox.isSelected();
    	checkbox.click();
    	System.out.println("Checkbox deselect");
    	 
 	}
   
    
   @And("^Filter job type to show only Full Time jobs$")
    public void filter() throws InterruptedException  {
	   
	   //Filter for only full time jobs
   	WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='job_type_internship']"));
   	checkbox2.isSelected();
   	checkbox2.click();
   	System.out.println("Checkbox2 deselect");
   	
   	Thread.sleep(1000);
   	
 	WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='job_type_part-time']"));
 	checkbox3.isSelected();
   	checkbox3.click();
   	System.out.println("Checkbox3 deselect");
   	
   	Thread.sleep(1000);
 	
 	WebElement checkbox4 = driver.findElement(By.xpath("//input[@id='job_type_temporary']"));
 	checkbox4.isSelected();
   	checkbox4.click();
   	System.out.println("Checkbox4 deselect");
   	
 	}
    
    
    @And("^Find job listing and check job details and print it$")
    public void jobList() throws InterruptedException  {
    	//Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'showing_jobs')]")));
        
        //Job listing selection
        Thread.sleep(1000);
    	WebElement joblist = driver.findElement(By.xpath("//li[contains(@class, 'post-2287 job_listing')]"));
    	joblist.click();
    	Thread.sleep(1800);
    	
    	String title = driver.getTitle();
	    System.out.println("Title is: " + title);
      

 	}
    
    @Then("^Click on the Apply for job button$")
    public void applyButton() throws InterruptedException  {
    	//Thread.sleep(1000);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class = 'application_button button']")));
 		
 		driver.findElement(By.xpath("//input[@class = 'application_button button']")).click();
 		
 		String email= driver.findElement(By.className("job_application_email")).getText();
	    System.out.println("To apply for this job email your details to : " + email);
 	}    
    
 
    @And("^The Browser is Closed$")
    public void closeBrowser() {
       driver.close();
     
    }
  
    
	}


