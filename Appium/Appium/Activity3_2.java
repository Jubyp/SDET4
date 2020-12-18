package Session3;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3_2 {
	
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;
		
		@BeforeClass
		  public void beforeClass() throws MalformedURLException {
			
			// Set the Desired Capabilities
			
		      DesiredCapabilities caps = new DesiredCapabilities();
			
		      caps.setCapability("deviceId", "PZ89D6K7S4C6EMG6");
		      caps.setCapability("platformName", "Android");
		      caps.setCapability("automationName", "UiAutomator2");
		      caps.setCapability("appPackage", "com.android.chrome");
		      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		      caps.setCapability("noReset", true);
		      
		   // Initialize driver
	          driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	          
	         wait = new WebDriverWait(driver, 50);
	         //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         
	         driver.get("https://www.training-support.net/selenium/lazy-loading");
		  }
		


  @Test
  public void image() {
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
      // wait for page to load
		
      MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
      String page = pageTitle.getText();
      System.out.println("page shown currently: " + page);
	wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

	
      // Count the number of images shown on the screen
	
      List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	System.out.println("Number of image shown currently: " + numberOfImages.size());
	
  
      // Assertion before scrolling
	
      Assert.assertEquals(numberOfImages.size(), 4);
	
    
      // Scroll to Helen's post
	
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
	
     
      // Find the number of images shown after scrolling
	
      numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	System.out.println("Number of image shown currently: " + numberOfImages.size());
	
      
      // Assertion after scrolling
	
      Assert.assertEquals(numberOfImages.size(), 4);
	  
	 
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
