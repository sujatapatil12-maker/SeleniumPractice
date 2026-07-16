package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://dummy-tickets.com/buyticket");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Select basic details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Flight']"))).click();
		driver.findElement(By.xpath("//input[@value='onewaymain']")).click();
		
		// Select source and destination
		driver.findElement(By.name("source[]")).sendKeys("Paris");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='"+"Charles De Gaulle,"+"']"))).click();
		driver.findElement(By.name("destination[]")).sendKeys("London");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='"+"London City Airport,"+"']"))).click();
		
		// Select departure date
		driver.findElement(By.name("departure[]")).click();
		String year = "2027";
		String month = "Jan";
		String day = "26";
		Select yearDropdown = new Select(driver.findElement(By.className("ui-datepicker-year")));
		yearDropdown.selectByVisibleText(year);
		Select monthDropdown = new Select(driver.findElement(By.className("ui-datepicker-month")));
		monthDropdown.selectByVisibleText(month);
		
		List<WebElement> dayOptions = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td//a"));
		for(WebElement dayOption : dayOptions)
		{
			if(dayOption.getText().equals(day))
			{
				dayOption.click();
			}
		}
		WebElement button = driver.findElement(By.id("flight_oneway_btn")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
		button.click();
		
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
