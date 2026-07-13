package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {

	public static void main(String[] args) {
		// Navigate to given URL
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
				driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
				driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
				driver.findElement(By.cssSelector("button[type='submit']")).submit();
				
				driver.quit();

	}

}
