package Session11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
		String title = driver.getTitle();
		System.out.println("Title is : " +title);
		
		WebElement confirmalert = driver.findElement(By.id("confirm"));
		confirmalert.click();
		System.out.println("Alert clicked");
		
		Alert confirm = driver.switchTo().alert();
		String alerts = confirm.getText();
		System.out.println("Confirm alert is :" +alerts);
		
		confirm.accept();
		confirmalert.click();
		System.out.println("Alert again clicked");
		confirm.dismiss();
		System.out.println("Alert cancelled");

		driver.close();
			

	}

}
