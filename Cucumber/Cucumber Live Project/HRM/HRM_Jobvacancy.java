package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HRM_Jobvacancy {
	
	WebDriver driver;
    WebDriverWait wait;

    @Given("^User In Login Page$")
    public void LoginPage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 60);
                 
         //Open the browser
         driver.get("http://alchemy.hguy.co/orangehrm");
 
 	}
		
    @When("^User inputs \"(.*)\" and \"(.*)\"$")
	public void userValues(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("txtUsername")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("txtPassword")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("btnLogin")).click();

    } 
    
    @And("^Navigate to Recruitment and click Vacancy to navigate to vacany page$")
    public void recruit()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MP_link")));
    	// Navigate to Recruit Click Vacancy
       driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElement(By.partialLinkText("Vacancies")).click();
       
 
    } 
    
     
  @Then("^Click Add button to navigate to Add Job Vacancy form$")
    public void jobVacancy()  {
    	
    	//Add Job Vacancy
      // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnSrch")));
       driver.findElement(By.id("btnAdd")).click();
         
  } 
    
   @And("^Fill necessary details and Click Save button$")
   public void save()  {
   	
   	//Add details and save
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addJobVacancy")));  
      Select dropdown = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
      dropdown.selectByValue("3");
      driver.findElement(By.id("addJobVacancy_name")).sendKeys("Auto Test13");
      driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("orange");
      driver.findElement(By.className("ac_results")).click();
      driver.findElement(By.id("btnSave")).click();
 
 }    
   
   @And("^Fill necessary details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
   public void saveData(String JobTitle, String VacancyName, String HiringManager) throws Throwable{
   	//Select job title
	   
   	WebElement Jobtitle1 = driver.findElement(By.id("addJobVacancy_jobTitle"));
   	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   	Select dropdown = new Select(Jobtitle1);
   	dropdown.selectByVisibleText(JobTitle);
   	driver.findElement(By.id("addJobVacancy_name")).sendKeys(VacancyName);
   	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(HiringManager);
   	driver.findElement(By.id("btnSave")).click(); 	
   
   }
   

   @Then("^Verify the vacancy is created$")
   public void vacancyCreated()  {
   	
   	//Verify created Job Vacancy
	 
      driver.findElement(By.id("btnBack")).click();
      WebElement search = driver.findElement(By.id("vacancySearch_jobVacancy"));
      search.sendKeys("Auto Test13");
      
      driver.findElement(By.id("btnSrch")).click();
      
      String name = driver.findElement(By.partialLinkText("Auto")).getText();
      System.out.println("Data is :" +name);
      Assert.assertEquals(name, "Auto Test13");  
 
 } 
   
   @Then("^Verify the vacancy is created \"(.*)\"$")
   public void vacancyCreate(String VacancyName) throws Throwable{
	 driver.findElement(By.id("btnBack")).click();
	 Thread.sleep(1000);
	 WebElement Vacancy = driver.findElement(By.id("vacancySearch_jobVacancy"));
   	Select dropdown1 = new Select(Vacancy);
   	dropdown1.selectByVisibleText(VacancyName);
   	driver.findElement(By.id("btnSrch")).click();
   	String VacancyNames = driver.findElement(By.linkText(VacancyName)).getText();
   	System.out.println("value is :" +VacancyNames);
   	Assert.assertEquals(VacancyNames, VacancyName);
 
   } 
   
   @And("^Close browser$")
   public void closeBrowser() {
       driver.close();
	   
   }
 
   
	}


