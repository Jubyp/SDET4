package Session6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
			
		driver.get("https://training-support.net/selenium/tables");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
		
		System.out.println("Number of cols :" + cols.size());
		System.out.println("Number of rows :" + rows.size());
		
		
		WebElement secondRow = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
    	System.out.println("Second row, Second column Value : " + secondRow.getText());
		
    	WebDriverWait wait = new WebDriverWait (driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sortableTable")));
		
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();
    	
	
        WebElement ValueAfter = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
	
        System.out.println("Second row, second column value: " + ValueAfter.getText());
	
	
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());

    	
		driver.close();
	}

}
