package Session11;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://www.training-support.net/selenium/tab-opener");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		String firsthandle = driver.getWindowHandle();
		System.out.println("First handle is :" + firsthandle);
		
		WebElement newtab = driver.findElement(By.id("launcher"));
		newtab.click();
		System.out.println("Click me button clicked");
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String>  allHandles = driver.getWindowHandles();
		System.out.println("All handles is :" + allHandles);
		
        for (String handle : driver.getWindowHandles()) {
        	driver.switchTo().window(handle);	
        }
        
        System.out.println("Current window handle: " + driver.getWindowHandle());
        
        wait.until(ExpectedConditions.titleIs("Newtab"));
        
        System.out.println("New Tab Title is: " + driver.getTitle());
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));
        String newTabText = driver.findElement(By.cssSelector("div.content")).getText();
    	System.out.println("New tab heading is: " + newTabText);
    	
    	WebElement newtab2 = driver.findElement(By.id("actionButton"));
		newtab2.click();
		System.out.println("Open another button clicked");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		allHandles = driver.getWindowHandles();
		System.out.println("All handles is :" + allHandles);
		
		for (String handle : driver.getWindowHandles()) {
        	driver.switchTo().window(handle);	
        }
		
		System.out.println("New window handle: " + driver.getWindowHandle());
        
        wait.until(ExpectedConditions.titleIs("Newtab2"));
        
        System.out.println("New Tab Title is: " + driver.getTitle());
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));
        String newTabText2 = driver.findElement(By.cssSelector("div.content")).getText();
    	System.out.println("New tab heading is: " + newTabText2);
	    
        driver.quit();
      	

	}

}
