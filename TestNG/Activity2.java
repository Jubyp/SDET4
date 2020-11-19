package TestNG_Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.SkipException;

public class Activity2 {
	WebDriver driver;
	
  @Test
  public void gettitle() {
	 
	  String title = driver.getTitle();
	  System.out.println("The title is :" + title);
	  Assert.assertEquals(title, "Target Practice");
	    
  }
	    
	   
	  @Test
	 public void findelement() {
		
	WebElement black = driver.findElement(By.xpath("//button[@class = 'ui black button']"));
		
		Assert.assertTrue(black.isDisplayed());
		System.out.println("Button displayed");
		Assert.assertEquals(black.getText(), "black");
		System.out.println("Assertion failed");  
 		  
  }
  
  @Test(enabled = false)
  public void Skip() {
	  
	  System.out.println("Not printed");
	  
  }
  
  @Test
  public void SkipException() {
	  
	  throw new SkipException("test case skipped");
  }
 
     
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }
  

}
