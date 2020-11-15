package Session9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9_2 {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-attributes");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
				
		WebElement user = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
		user.sendKeys("test2");
		
		WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
		password.sendKeys("test");
		
		WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
		confirmPassword.sendKeys("test");
		
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@class,'email-')]"));
		email.sendKeys("test@test.com");
		
		WebElement button = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));
		button.click();
		

		String text = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(text);
		
		driver.close();
		
			

	}

}
