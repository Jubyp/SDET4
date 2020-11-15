package Session6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://training-support.net/selenium/tables");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class , 'striped')]/tbody/tr[1]/td"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class , 'striped')]/tbody/tr"));
		
		System.out.println("Number of cols :" + cols.size());
		System.out.println("Number of rows :" + rows.size());
		
		
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
    	
        for(WebElement Value : thirdRow) {
        System.out.println("Value: " + Value.getText());
        
        
        WebElement secondRow = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
    	System.out.println("Second row, Second column Value : " + secondRow.getText());
    	
    	driver.close();
	
        }	

	}

}
