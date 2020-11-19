package Session12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 

public class Activity12_1 {

	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://www.training-support.net/selenium/iframes");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));

		driver.switchTo().frame(0);
		
		WebElement frame1 = driver.findElement(By.cssSelector("div.content"));
		System.out.println("frame1 text is : " + frame1.getText());  
		
        WebElement button1 = driver.findElement(By.cssSelector("button"));
    	System.out.println(button1.getText());
    	System.out.println(button1.getCssValue("background-color"));
    	System.out.println(button1.getCssValue("color"));
    	button1.click();
    	
        System.out.println("New button text is :" +button1.getText());
    	System.out.println("New button color is :" +button1.getCssValue("background-color"));
    	
    	driver.switchTo().parentFrame();
    	System.out.println("Swtiched to parent");
    	
    	
    	driver.switchTo().frame(1);
    	WebElement frame2 = driver.findElement(By.cssSelector("div.content"));
    	System.out.println("Frame2 text is :" + frame2.getText());
    	
    	WebElement button2 = driver.findElement(By.cssSelector("button"));
    	System.out.println(button2.getText());
    	System.out.println(button2.getCssValue("background-color"));
    	button2.click();
    	
        System.out.println("New button2 text is :" +button2.getText());
    	System.out.println("New button2 color is :" +button2.getCssValue("background-color"));
    	System.out.println("New button2 color : " + button2.getCssValue("color"));
    	
    	
    	driver.switchTo().defaultContent();
    	System.out.println("Swtiched to default");  
		
		driver.close();
		
	
	}

}
