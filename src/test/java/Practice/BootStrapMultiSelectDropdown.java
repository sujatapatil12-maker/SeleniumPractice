package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootStrapMultiSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//button[@class='comboTreeArrowBtn'])[1]")).click();
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li//span[@data-id]")));
		System.out.println("Count of options : "+options.size());
		
		for(WebElement option : options)
		{
			String optionText = option.getText();
			System.out.println("option : " + optionText);
		}
		
		// Select multiple options
		String[] optionsToBeSelected = {"choice 2","choice 6 2 1"};
		
		for(String optionToBeSelected : optionsToBeSelected)
		{
			driver.findElement(By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li//span[contains(text(),'"+optionToBeSelected+"')]")).click();
		}
		
		driver.quit();
	}

}
