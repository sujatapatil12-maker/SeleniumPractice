package ScreenshotsDemo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificAreaScreenshotDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement htmlWidget = driver.findElement(By.xpath("//div[@class='widget HTML']"));
		File sourceFile = htmlWidget.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File(System.getProperty("user.dir")+"\\screenshots\\htmlwidget.png");
		sourceFile.renameTo(destinationFile);
		
		driver.quit();

	}

}
