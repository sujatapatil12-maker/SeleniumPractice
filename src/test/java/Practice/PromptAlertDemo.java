package Practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("promptBtn")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Selenium Java");
		
		alert.accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		driver.quit();
		
	}

}
