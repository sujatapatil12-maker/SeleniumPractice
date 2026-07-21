package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream fi;
	static FileOutputStream fo;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static XSSFRow row;
	static XSSFCell cell;

	// Get no of rows in excel file for given sheet
	public static int getRowCount(String xlFile, String sheet) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;

	}

	// Get no of cells in excel file for given sheet
	public static int getCellCount(String xlFile, String sheet, int rowNumber) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		int cellCount = sh.getRow(rowNumber).getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;

	}
	
	// Get cell value
	public static String getCellValue(String xlFile, String sheet, int rowNumber, int cellNumber) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		row = sh.getRow(rowNumber);
		cell = row.getCell(cellNumber);
		DataFormatter formatter = new DataFormatter();
		String cellValue = formatter.formatCellValue(cell);
		wb.close();
		fi.close();
		return cellValue;
	}
	
	// Set cell Value
	public static void setCellValue(String xlFile, String sheet, int rowNumber, int cellNumber,String cellValue) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet); 
		row = sh.getRow(rowNumber);
		
		cell = row.createCell(cellNumber);
		cell.setCellValue(cellValue);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
