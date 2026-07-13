package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingNestedFrames {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.partialLinkText("Single")).click();
		
		driver.switchTo().frame("singleframe"); // Id
		
		driver.findElement(By.tagName("input")).sendKeys("Java");
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		
		WebElement parentframe = driver.findElement(By.xpath("//iframe[@src=\"MultipleFrames.html\"]"));
		
		driver.switchTo().frame(parentframe);
		
		WebElement childframe = driver.findElement(By.xpath("//iframe[@src=\"SingleFrame.html\"]"));
		
		driver.switchTo().frame(childframe);driver.findElement(By.tagName("input")).sendKeys("Selenium");
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		
		driver.quit();
		
		
	}

}
