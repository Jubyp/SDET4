package Session10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		Actions actions = new Actions(driver);
		
		WebElement key = driver.findElement(By.id("keyPressed"));
		
		Action action1 = actions.sendKeys("J").build();
		action1.perform();
		String ktext = key.getText();
		System.out.println("key value is :" + ktext);
		
		Action action2 = actions
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.sendKeys("c")
				.keyUp(Keys.CONTROL)
				.build();
		action2.perform();
		String ktext1 = key.getText();
		System.out.println("New key value is :" + ktext1);
		
		driver.close();
	

	}

}
