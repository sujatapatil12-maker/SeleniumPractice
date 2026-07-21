package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		// Open file in read mode
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		Properties propertiesobj = new Properties();
		// Load data from properties file
		propertiesobj.load(fi);
		
		// Fetch data from properties object using key
		String url = propertiesobj.getProperty("url");
		String userName = propertiesobj.getProperty("username");
		String password = propertiesobj.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.quit();

	}

}
