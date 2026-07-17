package JavaScriptExecutorDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOutUsingJS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Zoom In
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
		// Zoom Out
		js.executeScript("document.body.style.zoom='150%'");
		Thread.sleep(5000);		
		
		driver.quit();

	}

}
