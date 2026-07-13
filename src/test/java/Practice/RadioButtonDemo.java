package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='male' and @name='gender']"));
		WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@id='female' and @name='gender']"));
		
		System.out.println("Status of radio button : ");
		System.out.println("Male Radio Button Status : " + maleRadioBtn.isSelected());
		System.out.println("Female Radio Button Status : " + femaleRadioBtn.isSelected());
		
		// click radio button for male
		maleRadioBtn.click();
		
		System.out.println("Status of radio button after clicking radio button for male : ");
		System.out.println("Male Radio Button Status : " + maleRadioBtn.isSelected());
		System.out.println("Female Radio Button Status : " + femaleRadioBtn.isSelected());
		
		// click radio button for female
		femaleRadioBtn.click();
		
		System.out.println("Status of radio button after clicking radio button for female: ");
		System.out.println("Male Radio Button Status : " + maleRadioBtn.isSelected());
		System.out.println("Female Radio Button Status : " + femaleRadioBtn.isSelected());
		
				
		driver.quit();

	}

}
