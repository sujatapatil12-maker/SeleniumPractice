package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicTableDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Search flight depend on departure and destination city
		Select departureSelect = new Select(driver.findElement(By.name("fromPort")));
		departureSelect.selectByVisibleText("Paris");
		Select destinationSelect = new Select(driver.findElement(By.name("toPort")));
		destinationSelect.selectByVisibleText("London");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		
		// Find the column index for the given header Price
		WebElement table = driver.findElement(By.className("table"));
		
		List<WebElement> headers = table.findElements(By.xpath("//thead//th"));
		System.out.println("Header count : "+ headers.size());
		int columnIndex = -1;
		for(int i=0; i<headers.size();i++)
		{
			if(headers.get(i).getText().equals("Price"))
			{
				columnIndex = i;
			}
		}
		System.out.println("Column Index : " + columnIndex);
		
		// Fetch prices from all available rows and store in a array
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));
		System.out.println("Row count : "+ rows.size());
		double[] priceArray = new double[rows.size()];
		for(int i=0; i<rows.size();i++)
		{
			String priceText = rows.get(i).findElements(By.tagName("td")).get(columnIndex).getText();
			priceArray[i] = Double.parseDouble(priceText.replace("$", ""));
		}
		System.out.println("Price Array : "+priceArray);
		
		// Find the minimum price and Fetch row index of for that price
		double minimumPrice = priceArray[0];
		int rowIndex = 0;
		for(int i=1; i< priceArray.length ; i++)
		{
			if(minimumPrice > priceArray[i])
			{
				minimumPrice = priceArray[i];
				rowIndex = i;
			}
		}
		System.out.println("Row Index : "+rowIndex);
		
		// Find button depend on row index and click button to book flight
		rows.get(rowIndex).findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).click();
		
		
		// Enter name and purchase flight
		driver.findElement(By.id("inputName")).sendKeys("Mark");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		// Print message
		String message = driver.findElement(By.tagName("h1")).getText();
		System.out.println(message);
		
		driver.quit();

	}

}
