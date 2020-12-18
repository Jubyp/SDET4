package Session3;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity3_1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
	  	
		// Set the Desired Capabilities
		
	      DesiredCapabilities caps = new DesiredCapabilities();
		
	      caps.setCapability("deviceId", "PZ89D6K7S4C6EMG6");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.android.mms");
	      caps.setCapability("appActivity", ".ui.ComposeMessageActivity");
	      caps.setCapability("noReset", true);
	      
	   // Initialize driver
          driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
          wait = new WebDriverWait(driver, 30);
          
	  }

	
  @Test
  public void sendsms() throws InterruptedException {
	  
	  
	  MobileElement contact = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"To\"]"));
	  contact.sendKeys("09886390986");
	  System.out.println("Number selected");
	  
	  Thread.sleep(2000);
	  
	  //Message field
	  MobileElement message = driver.findElement(By.id("com.android.mms:id/embedded_text_editor"));
	 message.click();
	message.sendKeys("Hello from Appium");
	    
	  //Send button
	  driver.findElement(By.id("com.android.mms:id/send_button")).click();
	  System.out.println("Button click");
	  
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("delivered_indicator"))); 
	  
	  //Message receive
	  MobileElement messagetext = driver.findElement(By.id("com.android.mms:id/text_view"));
	  String text = messagetext.getText();
	  Assert.assertEquals(text, "Hello from Appium");
	
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
