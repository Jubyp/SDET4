package LMS_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity8 {
	
	WebDriver driver;
	
  @Test
  public void ContactUs() {
	  
	  
	  WebElement  navigationbar = driver.findElement(By.xpath("//div[@class = 'main-navigation']"));
		 navigationbar.isDisplayed();
		 System.out.println("Navigation bar found");
		 
		 WebElement mybuttons = driver.findElement(By.xpath("//li[contains(@id , 'menu-item-1506')]"));
		 mybuttons.click();
		 System.out.println("Button Clicked");
		 
		 WebElement fullName = driver.findElement(By.xpath("//input[@id ='wpforms-8-field_0']"));
		 fullName.sendKeys("Test");
		 
		 WebElement Email = driver.findElement(By.xpath("//input[@id ='wpforms-8-field_1']"));
		 Email.sendKeys("test@test.com");
		 
		 WebElement Comment = driver.findElement(By.xpath("//textarea[@id ='wpforms-8-field_2']"));
		 Comment.sendKeys("testing");
		 
		 WebElement SendMessage = driver.findElement(By.xpath("//button[@id ='wpforms-submit-8']"));
		 SendMessage.click();
		 
		 WebElement Confirmation = driver.findElement(By.xpath("//div[@id ='wpforms-confirmation-8']"));
		 String confirm = Confirmation.getText();
		 System.out.println("Confirmation message is : " + confirm);  		 
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	 
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");
	  
  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
