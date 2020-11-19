package Session11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		WebElement alert = driver.findElement(By.id("simple"));
		alert.click();
		Alert simple = driver.switchTo().alert();
		
		String text = simple.getText();
		System.out.println("Alert is :" + text);
		
		simple.accept();
		
		driver.close();

	}

}
