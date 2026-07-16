package ActionsClassDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		
		action.doubleClick(button).perform();
		
		System.out.println(driver.findElement(By.id("field2")).getText());
		
		Thread.sleep(5000);

		driver.quit();
	}

}
