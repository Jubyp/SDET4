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

public class Jobs_CreateNewUser {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User Logs In$")
    public void LoginPage()  {
     	 //Create a new instance of the Firefox driver
         driver = new FirefoxDriver();
         wait = new WebDriverWait(driver, 20);
                 
         //Open the browser
         driver.get("https://alchemy.hguy.co/jobs/wp-admin");	

 	}
   

    @When("^User input \"(.*)\" and \"(.*)\"$")
	public void login(String username, String password) throws Throwable {
    	//Enter username from Feature file
    	driver.findElement(By.id("user_login")).sendKeys(username);
    	//Enter password from Feature file
    	driver.findElement(By.id("user_pass")).sendKeys(password);
    	//Click Login
    	driver.findElement(By.id("wp-submit")).click();
	
    } 
		
    @And("^Click on left menu and Click the menu Users$")
    public void leftMenu() throws InterruptedException  {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("wp-menu-name")));
    	WebElement user = driver.findElement(By.linkText("Users"));
    	user.click();
        Thread.sleep(1000);

 	}
   
  
    @And("^Click on Add New button$")
    public void addNew()  {
    
    	WebElement addButton = driver.findElement(By.linkText("Add New"));
    	addButton.click();
        
         
 	}
    
    @And("^Fill mandatory details and Click Add New User button$")
    public void details() throws InterruptedException   {
        
        driver.findElement(By.id("user_login")).sendKeys("ABB");
        driver.findElement(By.id("email")).sendKeys("abz@test.com");
       Thread.sleep(700);
       WebElement pass = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[6]/td/button"));
       pass.click();
        Thread.sleep(1000);
    	driver.findElement(By.id("createusersub")).click();
       
     
 	}
    
 
    @Then("^Verify User is created$")
    public void userCreate() throws InterruptedException  {
        Thread.sleep(1000);
    	WebElement message = driver.findElement(By.xpath("//div[@id = 'message']/p"));
    	String message1 = message.getText();
        System.out.println("user created :" + message1);  
        Assert.assertEquals("New user created. Edit user", message1);
 	}  
    
  
    @And("^Browser Closed$")
    public void closeBrowser() {
       driver.close();
    }
    
	}


