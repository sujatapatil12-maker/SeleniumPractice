package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindowsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		System.out.println("Window title before switching window : "+driver.getTitle());
		
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles  = driver.getWindowHandles();
		
		for(String windowHandle : windowHandles)
		{
			if(!windowHandle.equals(currentWindowHandle)) 
			{
				driver.switchTo().window(windowHandle);
			}
		}
		
		System.out.println("Window title after switching window : "+driver.getTitle());
		driver.quit();

	}

}
