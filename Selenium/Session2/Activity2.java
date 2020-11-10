package Session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
				
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net");
		String pagetitle = driver.getTitle();
		System.out.println("pagetitle: " + pagetitle);
		
		WebElement ids = driver.findElement(By.id("about-link"));
		System.out.println("Text: " + ids.getText());
		WebElement classname = driver.findElement(By.className("green"));
		System.out.println("Text: " + classname.getText());
		WebElement linktext = driver.findElement(By.linkText("About Us"));
		System.out.println("Text: " + linktext.getText());
		WebElement cssselect = driver.findElement(By.cssSelector(".green"));	
		System.out.println("Text: " + cssselect.getText());
		
		driver.close();
					
	}

}
