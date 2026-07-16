package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {

	public static void main(String[] args) {
		// Static Table - Fixed rows, columns and data
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement table = driver.findElement(By.name("BookTable"));
		
		// Print all column headers
		List<WebElement> columnHeaders = table.findElements(By.tagName("th"));
		
		for(WebElement header : columnHeaders )
		{
			System.out.println(header.getText());
		}
		
		
		// Read Data from given column
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Row Count : "+ rows.size());
		String columnHeader = "Subject";
		for(int i=0;i<columnHeaders.size();i++)
		{
			if(columnHeaders.get(i).getText().equals(columnHeader))
			{
				
				System.out.println("Column Index : "+ i);
				for(int r=1;r<rows.size();r++)
				{
					System.out.println(rows.get(r).findElements(By.tagName("td")).get(i).getText());
				}
				break;
			}
		}
		
		// Read data depend on condition
		// Read Name of the books having price 300
		String priceColumnHeader = "Price";
		
		for(int i=0;i<columnHeaders.size();i++)
		{
			if(columnHeaders.get(i).getText().equals(priceColumnHeader))
			{
				
				System.out.println("Price Column Index : "+ i);
				for(int r=1;r<rows.size();r++)
				{
					List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
					if(Integer.parseInt(columns.get(i).getText())==(300))
					{
						System.out.println(columns.get(0).getText());
					}
				}
				break;
			}
		}
		
		driver.quit();	
	}

}
