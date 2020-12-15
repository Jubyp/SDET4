package Session1;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1_2 {
	
	 AppiumDriver<MobileElement> driver = null;
	
	
  @BeforeClass
  public void calc() throws InterruptedException, IOException {
	  
	 
      
   // Set the Desired Capabilities
		
      DesiredCapabilities caps = new DesiredCapabilities();
	
      caps.setCapability("deviceId", "PZ89D6K7S4C6EMG6");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.bbkcalculator");
      caps.setCapability("appActivity", ".Calculator");
      
      
      
      try {	
    // Initialize driver
          driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
          System.out.println("Calculator is open");
      } catch (MalformedURLException e) {
          System.out.println(e.getMessage());
      }
     
}
  
  @Test
	  
  public void Multiply() {

  	
	  driver.findElementById("digit7").click();
	  driver.findElementById("mul").click();
	  driver.findElementById("digit4").click();
	  driver.findElementById("equal").click();

	  String result=driver.findElementById("com.android.bbkcalculator:id/input_edit").getText();
	  System.out.println(result);
	  Assert.assertEquals(result, "28");
    
}

    
@AfterClass
  public void afterclass() {

	driver.quit();
	
  }

}
