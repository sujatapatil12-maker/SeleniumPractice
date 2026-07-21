package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcel {

	public static void main(String[] args) throws IOException {
		
		// Open file in writing mode
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\newexcel.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sh = wb.createSheet("Student Details");
		
		System.out.println("Enter number of rows");
		Scanner sc = new Scanner(System.in);
		int rowCount = sc.nextInt();
		
		System.out.println("Enter number of columns");
		int cellCount = sc.nextInt();
		
		for(int r=0; r<rowCount;r++)
		{
			XSSFRow row  = sh.createRow(r);
			for(int c=0; c<cellCount ; c++)
			{
				String cellValue = sc.next();
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(cellValue);
			}
		}
		
		wb.write(fo);
		
		wb.close();
		fo.close();

	}

}
