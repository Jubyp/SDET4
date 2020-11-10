package Session5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/dynamic-controls");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		WebElement text = driver.findElement(By.xpath("//input[@id = 'input-text']"));
		System.out.println("Text enable :" + text.isEnabled());
		
		driver.findElement(By.id("toggleInput")).click();
		System.out.println("Text enable :" + text.isEnabled());
		
		driver.close();  
	
		
		    }

	}

