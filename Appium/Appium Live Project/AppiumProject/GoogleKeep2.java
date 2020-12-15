package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleKeep2 {
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
  public void ReminderNote() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElementById("new_note_button").click();
	 MobileElement title = driver.findElementById("com.google.android.keep:id/editable_title");
	 title.click();
	  wait = new WebDriverWait(driver, 10);
	  title.sendKeys("Note2");
	  
	  MobileElement textDesc = driver.findElementById("com.google.android.keep:id/edit_note_text");
	  textDesc.click();
	  wait = new WebDriverWait(driver, 10);
	  textDesc.sendKeys("Note2 testing");
	  
	  driver.findElementById("menu_switch_to_list_view").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.keep:id/dialog_title")));
	  driver.findElementById("com.google.android.keep:id/time_spinner").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text= 'Afternoon']")));
	  
	  driver.findElementByXPath("//android.widget.TextView[@text= 'Afternoon']").click();
	  wait = new WebDriverWait(driver, 10);
	  driver.findElementById("com.google.android.keep:id/save").click();
	  
  
	  
	//Move backward
	  driver.findElementByAccessibilityId("Navigate up").click();
	   wait = new WebDriverWait(driver, 20);
	      
	   
	 //Assertion
	   MobileElement title1 = driver.findElementById("com.google.android.keep:id/reminder_chip_text");
	   String titletext1 = title1.getText();
	   System.out.println("title is :" + titletext1);
	   Assert.assertEquals(titletext1, "Today, 1:00 PM");
  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
