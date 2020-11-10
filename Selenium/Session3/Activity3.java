package Session3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/simple-form");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		Thread.sleep(1000);
		
		WebElement element1 = driver.findElement(By.id("firstName"));
		element1.sendKeys("Test");
		
		WebElement element2 = driver.findElement(By.id("lastName"));
		element2.sendKeys("Test1");
		
		WebElement element3 = driver.findElement(By.id("email"));
		element3.sendKeys("Test@abc.com");
		
		WebElement element4 = driver.findElement(By.id("number"));
		element4.sendKeys("123456");
		
		driver.findElement(By.cssSelector(".green")).click();
		
		Thread.sleep(2000);
			
		driver.close();	
	}

}
