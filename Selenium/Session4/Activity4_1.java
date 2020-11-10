package Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
				
		WebElement element = driver.findElement(By.xpath("//a[@id = 'about-link']"));
		System.out.println("element is: " + element.getText());
		element.click();
		
		Thread.sleep(1000);
		
		String newtitle = driver.getTitle();
		System.out.println("New Title is : " + newtitle);
					
		driver.close();
		
		
	}

}
