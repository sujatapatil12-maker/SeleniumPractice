package Practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// Navigate to given url
		driver.get("https://www.google.com/");
		
		// Enter text to search
		driver.findElement(By.name("q")).sendKeys("automation"+Keys.ENTER);
		
		//close the browser window
		driver.quit();
	}

}
