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

public class GoogleChrome2 {
	
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
  
  public void LoginPage() throws Throwable {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("https://www.training-support.net/selenium");
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
			  
			  //Scroll Login Form
		      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))")).click();
			
	          //Add Username
		      
		      MobileElement userName = driver.findElement(By.xpath("//android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]"));
		      
		      userName.click();
		      userName.sendKeys("admin");
		     
		      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Password\"))")).click();
		      
	         //Add Password
		      
		      driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]").click();
			  driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]").sendKeys("password");
		      
			  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	          
	         
			  String Successlogin = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
			  Assert.assertEquals(Successlogin, "Welcome Back, admin");
			  System.out.println("Login Success");
			  
				
		      
			  MobileElement userName1 =driver.findElement(By.xpath("//android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]"));
			  
			  userName1.click();
			  userName1.clear();
		
			  userName1.sendKeys("Admin");
			  
			  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Password\"))")).click();
			  
			  
			  MobileElement passWord1 =driver.findElementByXPath("//android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]");
			  passWord1.click();
			  passWord1.clear();
			  passWord1.sendKeys("Password");
			  
			  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
			  
			  String LoginFailed = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
			  Assert.assertEquals(LoginFailed, "Invalid Credentials");
			  System.out.println("Login Failed");
  }
    

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
