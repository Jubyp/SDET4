package Session11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		WebElement promptalert = driver.findElement(By.id("prompt"));
		promptalert.click();
		
		Alert prompt = driver.switchTo().alert();
		String prompts = prompt.getText();
		System.out.println("Prompt alert is :" + prompts);
		
		prompt.sendKeys("Yes you are");
		System.out.println("Value entered");
		prompt.accept();
		System.out.println("Prompt closed");
	
		
		driver.close();
	

	}

}
