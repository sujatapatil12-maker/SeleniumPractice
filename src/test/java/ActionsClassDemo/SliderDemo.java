package ActionsClassDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement minSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[2]"));
		
		System.out.println("Default location of minimum slider : " + minSlider.getLocation());
		System.out.println("Default location of maximum slider : " + maxSlider.getLocation());
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(minSlider, 10, 0).dragAndDropBy(maxSlider, -10, 0).perform();
		
		
		System.out.println("Current location of minimum slider : " + minSlider.getLocation());
		System.out.println("Current location of maximum slider : " + maxSlider.getLocation());
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
