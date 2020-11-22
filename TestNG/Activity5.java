package TestNG_Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;
	
  @Test (groups = {"HeaderTests", "ButtonTests"})
  public void Headertitles() {
	  
	  String title = driver.getTitle();
	  System.out.println("The page title is : " + title);
	  
  }
	  
	  @Test (dependsOnMethods = {"Headertitles"}, groups = {"HeaderTests"})
	  public void Header1() {
	  
	  String thirdheader = driver.findElement(By.id("third-header")).getText();
	  System.out.println("Third header is :" + thirdheader);
	  Assert.assertEquals(thirdheader, "Third header");
	  
	  }
	  
	  @Test (dependsOnMethods = {"Headertitles"}, groups = {"HeaderTests"})
	  public void Header2() {
		  
	  String fifthheader = driver.findElement(By.xpath("//h5[@class ='ui green header']")).getCssValue("color");
	  System.out.println("Fifth header is :" + fifthheader);
	  Assert.assertEquals(fifthheader, "rgb(33, 186, 69)");
	  
	  }
	  
	  @Test (dependsOnMethods = {"Headertitles"}, groups = {"ButtonTests"})
	  public void Button1() {
		  
	  String buttonolive = driver.findElement(By.xpath("//h4[@class ='ui olive header']")).getText();
	  System.out.println("Button olive is :" + buttonolive);
	  Assert.assertEquals(buttonolive, "Fourth header");
	  
	  }
	  
	  @Test (dependsOnMethods = {"Headertitles"}, groups = {"ButtonTests"})
	  public void Button2() {
		    
	  String firstbutton = driver.findElement(By.xpath("//button[@class ='ui brown button']")).getCssValue("color");
	  System.out.println("first button in third row is :" + firstbutton);
	  Assert.assertEquals(firstbutton, "rgb(255, 255, 255)");
	  
	 }
	  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");

	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
