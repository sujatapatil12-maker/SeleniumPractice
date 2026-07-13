package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleCheckboxesDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		// Check all checkboxes
		for(WebElement checkBox : checkBoxes)
		{
			checkBox.click();
		}
		
		Thread.sleep(5000);
		
		// Toggle first n checkboxes
		
		int n = 3;
		for(int i=0; i<n;i++)
		{
			checkBoxes.get(i).click();
		}
		Thread.sleep(5000);
		
		// Toggle last n checkboxes
		int checkBoxesSize = checkBoxes.size();
		for(int i=(checkBoxesSize-n) ; i<checkBoxesSize;i++)
		{
			checkBoxes.get(i).click();
		}
		Thread.sleep(5000);
		
		driver.quit();
	}

}
