package Session2;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Activity2_2 {
	
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		
		// Set the Desired Capabilities
		
	      DesiredCapabilities caps = new DesiredCapabilities();
		
	      caps.setCapability("deviceId", "PZ89D6K7S4C6EMG6");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.android.bbkcalculator");
	      caps.setCapability("appActivity", ".Calculator");
	      caps.setCapability("noReset", true);
	      
	   // Initialize driver
          driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
          System.out.println("Calculator is open");
          
	  }
	
  @Test
  public void add() {
	  
	  driver.findElementById("digit7").click();
	  driver.findElementById("op_add").click();
	  driver.findElementById("digit4").click();
	  driver.findElementById("equal").click();

	  String result=driver.findElementById("com.android.bbkcalculator:id/input_edit").getText();
	  System.out.println(result);
  }
  
  @Test
  public void sub() {

	  
	  driver.findElementById("digit7").click();
	  driver.findElementById("op_sub").click();
	  driver.findElementById("digit4").click();
	  driver.findElementById("equal").click();

	  String result=driver.findElementById("com.android.bbkcalculator:id/input_edit").getText();
	  System.out.println(result);
  }
  @Test
  public void multiply() {

	
    driver.findElementById("digit_5").click();
    driver.findElementById("op_mul").click();
    driver.findElementById("digit_1").click();
    driver.findElementById("digit_0").click();
    driver.findElementById("equal").click();
    
    String result=driver.findElementById("com.android.bbkcalculator:id/input_edit").getText();
	  System.out.println(result);
}

  @Test
  public void divide() {
	  
      driver.findElementById("digit_5").click();
  	driver.findElementById("digit_0").click();
	driver.findElementById("op_div").click();
	driver.findElementById("digit_3").click();
	driver.findElementById("equal").click();
    
    String result=driver.findElementById("com.android.bbkcalculator:id/input_edit").getText();
	  System.out.println(result);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
