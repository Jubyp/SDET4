package Session7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity7_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/selects");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);

		
		WebElement multiValue = driver.findElement(By.id("multi-value"));
		System.out.println(multiValue.getText());
		
		WebElement multiSelect = driver.findElement(By.id("multi-select"));
		Select list = new Select(multiSelect);
		
		if(list.isMultiple()) {
			
			list.selectByVisibleText("Javascript");
			System.out.println(multiValue.getText());
			
			list.deselectByValue("node");
			System.out.println(multiValue.getText());
			
			
			for(int i =4; i<=6; i++) {
				list.selectByIndex(i);
				
			}
			System.out.println(multiValue.getText());
			
						
			list.deselectByIndex(7);
			System.out.println("Removed is : " + multiValue.getText());
			
			list.getFirstSelectedOption();
			System.out.println("First Selected is : " + multiValue.getText());
			
			List<WebElement> lists = list.getAllSelectedOptions();
			
			for(WebElement listy : lists) {
				System.out.println("Option is  : " + listy.getText());
			}
			
			list.deselectAll();
			System.out.println(multiValue.getText());
  				 
		}	
		
		driver.close();
		
	}

}
