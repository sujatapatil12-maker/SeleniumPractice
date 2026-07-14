package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// Auto suggestive dropdown means user starts writing 
		// then options are dynamically loaded depend on text entered.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Type search text
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		// Get all the options
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		System.out.println("No. Of Options : "+ options.size());
		
		for(WebElement option : options)
		{
			System.out.println(option.getText());
		}
		
		// Select option
		String optionToSelect = "selenium";
		driver.findElement(By.xpath("//ul//li//span[normalize-space()='"+optionToSelect+"']")).click();
		
		driver.quit();
	}

}
