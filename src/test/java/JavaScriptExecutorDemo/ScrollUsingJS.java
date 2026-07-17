package JavaScriptExecutorDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUsingJS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement link = driver.findElement(By.linkText("Blogger"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// Scroll till target element is visible
		js.executeScript("arguments[0].scrollIntoView();", link);
		Thread.sleep(5000);
		
		//Scroll vertically at the bottom
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		// Scroll vertically at the top
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(5000);
		
		//Scroll vertically below by 500 pixel
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		driver.quit();

	}

}
