package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcelUtilityDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		
		// Fetch test data
		String xlFile = System.getProperty("user.dir")+"\\testdata\\SBIFixedDepositeInterestCalculator.xlsx";
		String sheetName = "sheet1";
		
		int rowCount  = ExcelUtility.getRowCount(xlFile, sheetName);
		int cellCount = ExcelUtility.getCellCount(xlFile, sheetName, 0);
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		for(int r=1;r<=rowCount;r++)
		{
			String principal = ExcelUtility.getCellValue(xlFile, sheetName, r, 0);
			String roi = ExcelUtility.getCellValue(xlFile, sheetName, r, 1);
			String period1 = ExcelUtility.getCellValue(xlFile, sheetName, r, 2);
			String period2 = ExcelUtility.getCellValue(xlFile, sheetName, r, 3);
			String frequency = ExcelUtility.getCellValue(xlFile, sheetName, r, 4);
			String maturityValue = ExcelUtility.getCellValue(xlFile, sheetName, r, 5);
			
			// UI test
			driver.findElement(By.id("principal")).sendKeys(principal);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(period1);
			Select periodDropDown = new Select(driver.findElement(By.id("tenurePeriod")));
			periodDropDown.selectByVisibleText(period2);
			Select frequencyDropDown = new Select(driver.findElement(By.id("frequency")));
			frequencyDropDown.selectByVisibleText(frequency);
			driver.findElement(By.xpath("//img[@src=\"https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif\"]")).click();
			Thread.sleep(3000);
			String actualMaturityValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

			if(Double.parseDouble(actualMaturityValue)==(Double.parseDouble(maturityValue)))
			{
				ExcelUtility.setCellValue(xlFile, sheetName, r, 7, "Pass");
				System.out.println("Pass");
				
			}
			else
			{
				ExcelUtility.setCellValue(xlFile, sheetName, r, 7, "Fail");
				System.out.println("Fail");
			}
			driver.findElement(By.xpath("//img[@src=\"https://images.moneycontrol.com/images/mf_revamp/btn_clear.gif\"]")).click();
			Thread.sleep(2000);
		}
		
		driver.quit();
	}

}
