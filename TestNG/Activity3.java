package TestNG_Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	WebDriver driver;
	
  @Test
  public void Login() {
	  
	  WebElement username = driver.findElement(By.xpath("//input[@id = 'username']"));
	  username.sendKeys("admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
	  password.sendKeys("password");
	  
	  WebElement button = driver.findElement(By.xpath("//button[@class = 'ui button']"));
	  button.click();
	  
	  WebElement message = driver.findElement(By.id("action-confirmation"));
	  message.getText();
	  Assert.assertEquals("Welcome Back, admin" , message.getText());
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
