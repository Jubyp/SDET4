package Session8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8_1 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-controls");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		WebElement checkbox = driver.findElement(By.xpath("//input[contains(@name, 'toggled')]"));
			
		WebElement button = driver.findElement(By.xpath("//button[@id = 'toggleCheckbox']"));
		button.click();
		System.out.println("Button clicked");
				
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		button.click();
		
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		checkbox.click();
		
		driver.close();
		


	}

}
