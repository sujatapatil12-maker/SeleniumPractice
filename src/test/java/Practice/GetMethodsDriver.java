package Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethodsDriver {

	public static void main(String[] args) throws InterruptedException {
		
		// Navigate to given URL
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		// Get the title of Page
		String title = driver.getTitle();
		System.out.println("Title : "+title);
		
		// Get Source code of the page
		String pageSource  = driver.getPageSource();
		System.out.println("Page Source : "+pageSource);
		
		// Get Current URL of the page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url : "+ currentUrl);
		
		// Get window handle for current window in focus
		System.out.println("Current window handle : "+ driver.getWindowHandle());
		
		// Get window handles
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window Handles Count : " + windowHandles.size());
		
		driver.quit();
	}

}
