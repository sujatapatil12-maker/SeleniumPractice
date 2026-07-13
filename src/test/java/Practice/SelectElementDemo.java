package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElementDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Select countryDropdown = new Select(driver.findElement(By.id("country")));
		countryDropdown.selectByIndex(1);
		Thread.sleep(2000);
		
		countryDropdown.selectByValue("uk");
		Thread.sleep(2000);
		
		countryDropdown.selectByVisibleText("India");
		Thread.sleep(2000);
		System.out.println(countryDropdown.getFirstSelectedOption().getText());
		
		List<WebElement> options = countryDropdown.getOptions();
		boolean ismultiSelection = countryDropdown.isMultiple();
		System.out.println("Is multiple selection allowed : "+ ismultiSelection);
		
		for(WebElement option : options)
		{
			System.out.println( option.getText());
		}
		
		driver.quit();
	}

}
