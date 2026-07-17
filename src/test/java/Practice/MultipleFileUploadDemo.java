package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFileUploadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Upload Multiple files
		String file1 = "F:\\Sujata Study\\Java\\FilesToUpload\\text1.txt";
		String file2 = "F:\\Sujata Study\\Java\\FilesToUpload\\text2.txt";
		driver.findElement(By.id("filesToUpload")).sendKeys(file1+"\n"+file2);
		
		List<WebElement> files = driver.findElements(By.xpath("//ul[@id='fileList']//li"));
		System.out.println("No Of files uploaded : " + files.size());
		
		driver.quit();

	}

}
