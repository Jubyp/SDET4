package LMS_Project;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
	

public class Activity5 {
	
	WebDriver driver;
	
	
  @Test
  public void MyAccount()  {
	  
	  
	 WebElement  navigationbar = driver.findElement(By.xpath("//div[@class = 'main-navigation']"));
	 navigationbar.isDisplayed();
	 System.out.println("Navigation bar found");
	 
	 WebElement mybuttons = driver.findElement(By.xpath("//li[contains(@id , 'menu-item-1507')]"));
	 mybuttons.click();
	 System.out.println("Button Clicked");
	 
	String pagetitle = driver.getTitle();
	System.out.println("New Page title is : " + pagetitle);
	
	Assert.assertEquals("My Account – Alchemy LMS", pagetitle);
	System.out.println("Assert matched");	

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
