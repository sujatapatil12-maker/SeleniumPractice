package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links = driver.findElements(By.xpath("//ul//a"));
		System.out.println("Total Links Count : "+ links.size());
		int brokenLinkCount=0, notBrokenLinkCount=0;
		
		for(WebElement link : links)
		{
			String hrefAttribute = link.getAttribute("href");
			if(hrefAttribute==null||hrefAttribute.isEmpty())
			{
				System.out.println("Invalid link");
				continue;
			}
			
			try
			{
			URL url = new URL(hrefAttribute);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			if(connection.getResponseCode()>=400)
			{
				System.out.println(hrefAttribute + " : Broken");
				brokenLinkCount++;
			}
			else
			{
				System.out.println(hrefAttribute + " :Not Broken");
				notBrokenLinkCount++;
			}
			}
			catch(Exception e)
			{
				
			}
			
		}
		
		System.out.println("Broken Link count : "+brokenLinkCount);
		System.out.println("Not Broken Link count : "+notBrokenLinkCount);
		
		driver.quit();
				
	}

}
