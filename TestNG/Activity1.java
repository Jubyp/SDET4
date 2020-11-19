package TestNG_Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
  

public class Activity1 {
	WebDriver driver;
	
  @Test
  public void Test() {
	 
	 String title = driver.getTitle();
	 System.out.println("Title is :" + title);
	 
	 Assert.assertEquals("Training Support", title);
	 
	 //driver.findElement(By.tagName("a")).click();
	 driver.findElement(By.id("about-link")).click();
	 
	 String newTitle = driver.getTitle();
	 System.out.println("New Title is :" + newTitle);
	 
	 Assert.assertEquals(newTitle, "About Training Support");
	 

  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
	  
  }

  
}
