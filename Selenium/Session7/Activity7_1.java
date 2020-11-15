package Session7;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity7_1 {

	public static void main(String[] args) {
	
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/selects");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		
		WebElement dropdown = driver.findElement(By.id("single-select"));
		Select list = new Select(dropdown);
		
		list.selectByVisibleText("Option 2");
		
		WebElement selected = driver.findElement(By.id("single-value"));
		System.out.println(selected.getText());
		
		list.selectByIndex(3);
		System.out.println(selected.getText());
		
		list.selectByValue("4");
		System.out.println(selected.getText());
		
		List<WebElement> options = list.getOptions();
		
		for(WebElement option : options) {
			System.out.println("Option is : " + option.getText());		
		}
		
	
		driver.close();
		
	}

}
