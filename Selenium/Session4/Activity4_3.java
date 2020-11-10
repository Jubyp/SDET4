package Session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
	

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://www.training-support.net/selenium/target-practice");
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		
		WebElement element1 = driver.findElement(By.xpath("//h3[@id= 'third-header']"));
		String text = element1.getText();
		System.out.println("Third Header is : " + text);
		
		
		String element2 = driver.findElement(By.xpath("//h5")).getCssValue("color");
		System.out.println("Fifth Header is : " + element2);
		
		
		String element3 = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
		System.out.println("Violet class is : " + element3);
		
		
		String element4 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
		System.out.println("Grey is : " + element4);
		
		driver.close();
				
	}
}
