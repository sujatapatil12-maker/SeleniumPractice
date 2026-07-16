package ActionsClassDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement button = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		Actions action = new Actions(driver);
		action.moveToElement(button).perform();
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
		for(WebElement option : options)
		{
			if(option.getText().equals("Laptops"))
			{
				option.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
