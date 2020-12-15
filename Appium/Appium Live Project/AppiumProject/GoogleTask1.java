package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleTask1 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		
		// Set the Desired Capabilities
		
	      DesiredCapabilities caps = new DesiredCapabilities();
		
	      caps.setCapability("deviceId", "PZ89D6K7S4C6EMG6");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.google.android.apps.tasks");
	      caps.setCapability("appActivity", ".ui.TaskListsActivity");
	      
	   // Initialize driver
          driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
          wait = new WebDriverWait(driver, 20);
               
	  }
	
  @Test
  public void Task1() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  MobileElement task = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  task.click();
	  MobileElement textarea = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  textarea.sendKeys("Task1");
	  MobileElement button = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  button.click();
	  
	  
	  // Find task entered
	     wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_name")));	
	    
	     // Assertion
	     MobileElement task1 = driver.findElementById("task_name");
	     Assert.assertTrue(task1.isDisplayed());   
	     System.out.println("task1 Displayed");
	     String taskDisplay1 = driver.findElementById("task_name").getText();
	     Assert.assertEquals(taskDisplay1, "Task1");
	     System.out.println("task1 asserted");
	 
  }
  
  @Test
  public void Task2() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  MobileElement task = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  task.click();
	  MobileElement textarea = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  textarea.sendKeys("Task2");
	  MobileElement button = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  button.click();
	  
	  
	//Find task2 entered
	     wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_name")));	
	    
	     // Assertion
	     MobileElement task2 = driver.findElementById("task_name");
	     Assert.assertTrue(task2.isDisplayed()); 
	     System.out.println("task2 Displayed");
	     String taskDisplay2 = driver.findElementById("task_name").getText();
	     Assert.assertEquals(taskDisplay2, "Task2");
	     System.out.println("task2 asserted");
	  
  }

  @Test
  public void Task3() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  MobileElement task = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	  task.click();
	  MobileElement textarea = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  textarea.sendKeys("Task3");
	  MobileElement button = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	  button.click();
	  
	//Find task3 entered
	     wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_name")));	
	    
	     // Assertion
	     MobileElement task3 = driver.findElementById("task_name");
	     Assert.assertTrue(task3.isDisplayed()); 
	     System.out.println("task3 Displayed");
	     String taskDisplay3 = driver.findElementById("task_name").getText();
	     Assert.assertEquals(taskDisplay3, "Task3");
	     System.out.println("task3 asserted");
   
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
