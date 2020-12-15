package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleKeep1 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		
		// Set the Desired Capabilities
		
	      DesiredCapabilities caps = new DesiredCapabilities();
		
	      caps.setCapability("deviceId", "PZ89D6K7S4C6EMG6");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.google.android.keep");
	      caps.setCapability("appActivity", "com.google.android.apps.keep.ui.activities.BrowseActivity");
	      
	   // Initialize driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 20);
	  }
	

  @Test
  public void NewNote() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElementById("new_note_button").click();
	 MobileElement title = driver.findElementById("com.google.android.keep:id/editable_title");
	 title.click();
	  wait = new WebDriverWait(driver, 10);
	  title.sendKeys("Note1");
	  
	  MobileElement textDesc = driver.findElementById("com.google.android.keep:id/edit_note_text");
	  textDesc.click();
	  wait = new WebDriverWait(driver, 10);
	  textDesc.sendKeys("Note1 testing");
	  
	  //Move backward
	  driver.findElementByAccessibilityId("Navigate up").click();
	   wait = new WebDriverWait(driver, 20);
	 
	 //Assertion
	   MobileElement title1 = driver.findElementById("com.google.android.keep:id/index_note_title");
	   String titletext1 = title1.getText();
	   System.out.println("Assert1 success");
	   Assert.assertEquals(titletext1, "Note1");
	
	  
  }
  

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
