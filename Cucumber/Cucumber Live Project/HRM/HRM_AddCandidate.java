package stepDefinitions;

import java.io.File;
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


public class HRM_AddCandidate {

	WebDriver driver;
    WebDriverWait wait;
    File file = new File("src/main/resources/Resume.docx");
    
    @Given("^User IN Login Page$")
    public void LoginPage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 40);
                 
         //Open the browser
          driver.get("http://alchemy.hguy.co/orangehrm");
 
 	}
		
    @When("^User keys in \"(.*)\" and \"(.*)\"$")
	public void userValues(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("txtUsername")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("txtPassword")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("btnLogin")).click();

    } 
    
    @And("^Navigate to Recruitment and click Candidate to navigate to candidate page$")
    public void recruit()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MP_link")));
    	// Navigate to Recruit Click Candidate
       driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElement(By.partialLinkText("Candidates")).click();
       System.out.println("Element found");
       
    } 

    @Then("^Click Add button to enter candidate details$")
    public void jobCandidate()  {
    	
    	//Add Job Candidate
      
       driver.findElement(By.id("btnAdd")).click();
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addCandidate")));  
       driver.findElement(By.id("addCandidate_firstName")).sendKeys("AB");
       driver.findElement(By.id("addCandidate_lastName")).sendKeys("CDE");
       driver.findElement(By.id("addCandidate_email")).sendKeys("ab@test.com");
      
    
	}
    
    @And("^Upload resume and Click Save button$")
    public void save()  {
    	
    	//File upload   	
        WebElement uploadfile = driver.findElement(By.id("addCandidate_resume"));    	
        uploadfile.sendKeys(file.getAbsolutePath());
        //Click Save
        driver.findElement(By.id("btnSave")).click();
     
  }  
  
   
   @Then("^Verify the Candidate is created$")
    public void candidateCreated()  {
    	
    	//Verify created Candidate
 	 
       driver.findElement(By.id("btnBack")).click();
       WebElement search = driver.findElement(By.id("candidateSearch_candidateName"));
       search.sendKeys("AB CDE");
       driver.findElement(By.id("btnSrch")).click();
       
       String name = driver.findElement(By.partialLinkText("CD")).getText();
       System.out.println("Data is :" +name);
       Assert.assertEquals(name, "AB CDE");
       
  }   
    
    
    @And("^Closing browser$")
    public void closeBrowser() {
      driver.close();
 	   
    }
 
}


