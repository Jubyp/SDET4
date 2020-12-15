package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
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

public class GoogleChrome3 {
	
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
		           
		         wait = new WebDriverWait(driver, 60);
		         //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		         driver.get("https://www.training-support.net/selenium"); 
	  }


  @Test
  public void PopupLogin() throws Throwable {
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	        driver.get("https://www.training-support.net/selenium");
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));

			  
			  // Popups
		      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
			  
		      // Click Log in
		      MobileElement LogIn = driver.findElement(By.xpath("//android.view.View/android.view.View[3]/android.widget.Button"));
		      LogIn.click();
		      
	          //Login Successful
		      
		        driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").click();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
				
				driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").click();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");
				
				driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
				
				String Successlogin = driver.findElementByXPath("//android.view.View[@text='Welcome Back, admin']").getText();
				
				Assert.assertEquals(Successlogin, "Welcome Back, admin");
				System.out.println("Login Successful");
				
				
			  //Login Failed
				
				driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").click();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").clear();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("Admin");
				
				driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").click();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").clear();
				driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("Password");
				
				driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
				
				String LoginFailed = driver.findElementByXPath("//android.view.View[@text='Invalid Credentials']").getText();
				
				Assert.assertEquals(LoginFailed, "Invalid Credentials");
				System.out.println("Login Failed");
	  
  }
  
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
