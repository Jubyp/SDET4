package TestNG_Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;
	
	@DataProvider(name = "Authentication")
	 public static  Object[][] credentials() {
		  return new Object[][] { { "admin", "password" } }; 
		  
	  }
	  
  @Test (dataProvider = "Authentication" )
  public void Dataprovider(String username, String password) {
	  
	  WebElement username1 = driver.findElement(By.id("username"));
	  username1.sendKeys(username);
	  
	  WebElement password1 = driver.findElement(By.id("password"));
	  password1.sendKeys(password);
	  
	  WebElement button = driver.findElement(By.xpath("//button[@class = 'ui button']"));
	  button.click();  
	  
	  
	 String message = driver.findElement(By.xpath("//div[@id = 'action-confirmation']")).getText();
	 Assert.assertEquals(message, "Welcome Back, admin");
	     
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
