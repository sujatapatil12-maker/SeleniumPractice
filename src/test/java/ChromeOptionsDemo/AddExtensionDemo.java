package ChromeOptionsDemo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AddExtensionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("F:\\Sujata Study\\Java\\BrowserExtensions\\uBlock-Origin-Lite-Chrome-Web-Store.crx"));
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		
		String input = "Welcome";
		driver.findElement(By.id("inputText1")).sendKeys(input);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL)
		.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL)
		.keyDown(Keys.TAB).keyUp(Keys.TAB)
		.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		String output = driver.findElement(By.id("inputText2")).getAttribute("value");
		System.out.println(output);
		if(input.equals(output))
		{
			System.out.println("Text copied successfully");
		}
		else
		{
			System.out.println("Text copy failed");
		}
		
		Thread.sleep(5000);
		
		driver.quit();
	

	}

}
