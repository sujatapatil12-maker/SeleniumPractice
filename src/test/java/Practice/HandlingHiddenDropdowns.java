package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingHiddenDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// Hidden dropdowns are dropdowns where we are not able to inspect options
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Select Directory
		driver.findElement(By.xpath("//span[text()='Directory']")).click();
		
		// Expand option pane by clicking arrow button
		driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]//i")).click();
		
		// Get the list of all options
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("No of Options : "+options.size());
		
		// Print all the options
		for(WebElement option : options)
		{
			System.out.println(option.getText());
		}
		
		//Select option
		String optionToBeSelected = "Finance Manager";
		driver.findElement(By.xpath("//div[@role='listbox']//span[text()='"+optionToBeSelected+"']")).click();
		
		String text = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).getText();
		System.out.println("Text displayed : "+ text);
		
		driver.quit();
	}

}
