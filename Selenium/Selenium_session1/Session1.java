package Selenium_session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Session1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
			// Create a new instance of the Firefox driver
			WebDriver driver = new FirefoxDriver();
				
			//Open the browser
			driver.get("https://www.google.com/");
			
			Thread.sleep(1000);
				
			//Close the browser
			driver.close();
		    }
	}


