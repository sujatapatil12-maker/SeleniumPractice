package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUploadDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Upload single file
		driver.findElement(By.id("filesToUpload")).sendKeys("F:\\Sujata Study\\Java\\FilesToUpload\\text1.txt");
		
		String message = driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText();
		if(message.equals("text1.txt"))
		{
			System.out.println("File uploaded successfully");
		}
		else
		{
			System.out.println("File upload failed");
		}
		
		driver.quit();

	}

}
