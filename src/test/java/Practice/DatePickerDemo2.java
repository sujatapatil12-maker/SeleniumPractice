package Practice;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Click textbox for date picker
		driver.findElement(By.id("datepicker")).click();
		
		// Expected date
		String year = "2026";
		String month="July";
		String day = "22";
		
		// Navigate to expected month and year
		while(true)
		{
			// Get current month and year from date picker pane
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}
			if(Integer.parseInt(year)>Integer.parseInt(currentYear))
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			else if(Integer.parseInt(year)<Integer.parseInt(currentYear))
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else
			{
				if(getMonth(month).compareTo(getMonth(currentMonth))>0)
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				}
				
			}

			
		}
		
		// Select day 
		
		List<WebElement> dayOptions = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));
		
		for(WebElement dayOption : dayOptions)
		{
			if(dayOption.getText().equals(day))
			{
				dayOption.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
	
	public static Month getMonth(String month)
	{
		Map<String, Month> map = new HashMap<String,Month>();
		map.put("January", Month.JANUARY);
		map.put("February", Month.FEBRUARY);
		map.put("March", Month.MARCH);
		map.put("April", Month.APRIL);
		map.put("May", Month.MAY);
		map.put("June", Month.JUNE);
		map.put("July", Month.JULY);
		map.put("August", Month.AUGUST);
		map.put("September", Month.SEPTEMBER);
		map.put("October", Month.OCTOBER);
		map.put("November", Month.NOVEMBER);
		map.put("December", Month.DECEMBER);
		
		return map.get(month);	
		
	}

}
