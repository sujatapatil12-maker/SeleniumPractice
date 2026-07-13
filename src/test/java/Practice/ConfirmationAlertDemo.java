package Practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationAlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.id("confirmBtn")).click();
		try
		{
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert message : "+alert.getText());
			alert.dismiss();
			System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo"))).getText());
		}
		catch(TimeoutException ex)
		{
			System.out.println("Alert is not present");
		}
		finally
		{
			driver.quit();
		}


	}

}
