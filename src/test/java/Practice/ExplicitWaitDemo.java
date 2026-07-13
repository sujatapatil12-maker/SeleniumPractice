package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Declartion of explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// Usage
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		userName.sendKeys("Admin");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
		password.sendKeys("admin123");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
		driver.quit();
	}

}
