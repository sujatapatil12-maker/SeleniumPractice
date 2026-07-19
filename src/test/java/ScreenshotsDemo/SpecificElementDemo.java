package ScreenshotsDemo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificElementDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dropdown = driver.findElement(By.id("country"));
		Thread.sleep(2000);
		File sourceFile = dropdown.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File(System.getProperty("user.dir")+"\\screenshots\\dropdown.png");
		sourceFile.renameTo(destinationFile);
		
		driver.quit();

	}

}
