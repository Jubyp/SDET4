package Session2;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2_3 {
	
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
	  }
	
  @Test
  public void Contact() {
			
	        // Click on add new contact floating button
		
	        driver.findElementByAccessibilityId("Create new contact").click();
		
	          // Find the first name, last name, and phone number fields
		
	        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
	        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Surname']");
	        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
		
		
	        firstName.sendKeys("Aaditya");
	        lastName.sendKeys("Varma");
	        phoneNumber.sendKeys("9991284782");
		
	        // Save the contact
	        driver.findElementById("editor_menu_save_button").click();
		
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
		
	        // Assertion
		
	        MobileElement mobileCard = driver.findElementById("toolbar_parent");
	        Assert.assertTrue(mobileCard.isDisplayed());
	        String contactName = driver.findElementById("large_title").getText();
	        Assert.assertEquals(contactName, "Aaditya Varma");
	 
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
