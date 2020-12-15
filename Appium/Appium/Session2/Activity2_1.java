package Session2;

import org.testng.annotations.Test;
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

public class Activity2_1 {
	
	
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
	      caps.setCapability("abdExecTimeout", 30000);
	
	    
	    // Initialize driver
	          driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	          
	         wait = new WebDriverWait(driver, 50);
	         //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	}
  
  @Test
  public void Browser() {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/");
	  System.out.println("Browser is open");
	 //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("about-link")));
	  MobileElement titles = driver.findElementByXPath("//android.view.View[@text = 'Training Support']");
	  String title = titles.getText();
	  System.out.println(" Title is :" + title);  
	  
	  MobileElement button = driver.findElementByAccessibilityId("About Us");
	  button.click();
	  MobileElement newtitles = driver.findElementByXPath("//android.view.View[@text = 'About Us']");
	  String newtitle = newtitles.getText();
	  System.out.println(" New Title is :" + newtitle); 
	  
	  Assert.assertEquals(title, "Training Support");
	  Assert.assertEquals(newtitle, "About Us");
	 

  }  
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  

}
