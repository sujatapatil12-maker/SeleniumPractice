package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(5000);
		
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='sunday' and @value='sunday']"));
		
		System.out.println("Displayed Status : "+checkbox.isDisplayed());
		
		System.out.println("Enabled Status : "+checkbox.isEnabled());
		
		System.out.println("Selected Status before click : "+checkbox.isSelected());
		
		checkbox.click();
		
		System.out.println("Selected Status after click : "+checkbox.isSelected());
		
		driver.quit();

	}

}
