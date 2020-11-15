package Session8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/ajax");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement button = driver.findElement(By.xpath("//button[starts-with(@class, 'ui violet')]"));
		button.click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
		String text = driver.findElement(By.id("ajax-content")).getText();
		System.out.println(text);
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
		String newtext = driver.findElement(By.id("ajax-content")).getText();
		System.out.println(newtext);
		
		driver.close();
		
		
		
	}

}
