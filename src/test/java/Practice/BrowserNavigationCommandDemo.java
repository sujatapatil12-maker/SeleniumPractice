package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigationCommandDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("get : "+driver.getCurrentUrl());
		Thread.sleep(2000);
		
		// Naviagate to
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("navigate to : "+driver.getCurrentUrl());
		Thread.sleep(2000);
		
		// Navigate back
		driver.navigate().back();
		System.out.println("back : "+driver.getCurrentUrl());
		Thread.sleep(2000);
		
		// Navigate forward
		driver.navigate().forward();
		System.out.println("forward : "+driver.getCurrentUrl());
		Thread.sleep(2000);
		
		// Navigate refresh
		driver.navigate().refresh();
		System.out.println("refresh : "+driver.getCurrentUrl());
		Thread.sleep(2000);
		
		driver.quit();
	}

}
