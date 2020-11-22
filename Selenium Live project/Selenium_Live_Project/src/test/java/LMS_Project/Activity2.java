package LMS_Project;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	
	WebDriver driver;
	
  @Test
  public void Test() {
	  
	  String title = driver.getTitle();
		 System.out.println("Title is :" + title);
		 
		 WebElement heading = driver.findElement(By.xpath("//h1[contains(@class,'uagb-ifb-title')]"));
		 System.out.println("Heading is : " + heading.getText());
		 
		 Assert.assertEquals("Learn from Industry Experts", heading.getText());
			   
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}


