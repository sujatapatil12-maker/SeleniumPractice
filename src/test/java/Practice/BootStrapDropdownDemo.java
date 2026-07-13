package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootStrapDropdownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// BootStrap downdown single selection
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// Click on arrow button to expand pane for dropdown option selection
		driver.findElement(By.xpath("(//button[@class='comboTreeArrowBtn'])[3]")).click();
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='comboTreeDropDownContainer'])[3]//li//span[@data-id]")));
		System.out.println(options.size());
		
		// Print the list of options available and select given option
		for(WebElement option : options)
		{
			String optionText = option.getText();
			System.out.println(optionText);
			if(optionText.equals("choice 2 2"))
			{
				option.click();
			}
		}		
		driver.quit();
		

	}

}
