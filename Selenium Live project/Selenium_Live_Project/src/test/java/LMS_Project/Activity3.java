package LMS_Project;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity3 {
	
	WebDriver driver;
	
  @Test
  public void Firsttitle() {
	  
	  WebElement Element = driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[1]"));
	  
	  //This will scroll the page till the element is found	
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView();", Element);
      
      // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      
      // pause execution to make the actions visible
      try{
    	  Thread.sleep(5000);
      }
      catch(InterruptedException ie){
      }

	  
      String infoboxTitle = Element.getText().strip();
      System.out.println("The first info box title is: " +infoboxTitle);
      
      Assert.assertEquals("Actionable Training", infoboxTitle);
      System.out.println("Assertion successful, test completed!");
     
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms/");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
