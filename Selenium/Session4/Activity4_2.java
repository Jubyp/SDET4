package Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/simple-form");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		Thread.sleep(1000);
		
		WebElement element1 = driver.findElement(By.xpath("//input[@id= 'firstName']"));
		element1.sendKeys("Test");
		
		WebElement element2 = driver.findElement(By.xpath("//input[@id= 'lastName']"));
		element2.sendKeys("Test1");
		
		WebElement element3 = driver.findElement(By.xpath("//input[@id= 'email']"));
		element3.sendKeys("Test@abc.com");
		
		WebElement element4 = driver.findElement(By.xpath("//input[@id= 'number']"));
		element4.sendKeys("123456");
		
		Thread.sleep(2000);
		
		WebElement element5 = driver.findElement(By.xpath("//textarea"));
		element5.sendKeys("test message");
			
		driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();
		
		Thread.sleep(2000);
			
		driver.close();	

	}

}
