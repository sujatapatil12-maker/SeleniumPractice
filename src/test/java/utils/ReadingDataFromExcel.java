package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		// Open file in reading mode
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getLastRowNum();
		System.out.println("Row Count : "+rowCount);
		
		int cellCount = sh.getRow(0).getLastCellNum();
		System.out.println("Cell Count : "+cellCount);
		
		for(int r=0; r<=rowCount;r++)
		{
			XSSFRow currentRow = sh.getRow(r);
			for(int c=0;c<cellCount;c++)
			{
				XSSFCell  currentCell = currentRow.getCell(c);
				String cellValue = currentCell.toString();
				System.out.println(cellValue);
			}
		}
		
		wb.close();
		fi.close();

	}

}
