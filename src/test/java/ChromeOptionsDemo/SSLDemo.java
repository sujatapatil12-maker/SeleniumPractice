package ChromeOptionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// Chrome setting to accept expired SSL Certificate
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.quit();

	}

}
