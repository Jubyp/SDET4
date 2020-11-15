package Session9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-attributes");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement user = driver.findElement(By.xpath("//input[contains (@class, 'username-')]"));
		user.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[contains (@class, 'password-')]"));
		password.sendKeys("password");
		
		WebElement button = driver.findElement(By.xpath("//button[@class ='ui button']"));
		button.click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Welcome Back, admin"));
		String text = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(text);
		
		driver.close();
		
		

	}

}
