package Session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		Actions actions = new Actions(driver);
		WebElement box = driver.findElement(By.id("wrapD3Cube"));
		
		actions.click(box);
		WebElement value = driver.findElement(By.className("active"));
		System.out.println("Value is : " +value.getText());
		
		actions.doubleClick(box).perform();
		value = driver.findElement(By.className("active"));
		System.out.println("New Value is : " +value.getText());
		
		actions.contextClick(box).perform();
		value = driver.findElement(By.className("active"));
		System.out.println("Click Value is : " +value.getText());
		
		
		driver.close();
			

	}

}
