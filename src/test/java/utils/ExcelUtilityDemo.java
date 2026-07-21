package utils;

import java.io.IOException;

public class ExcelUtilityDemo {

	public static void main(String[] args) throws IOException {
		
		String xlFile = System.getProperty("user.dir")+"\\testdata\\data.xlsx";
		//System.out.println(xlFile);		
		String sheetName = "sheet1";
		
		int rowCount  = ExcelUtility.getRowCount(xlFile, sheetName);
		int cellCount = ExcelUtility.getCellCount(xlFile, sheetName, rowCount);
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		for(int r=0;r<=rowCount;r++)
		{
			for(int c=0;c<cellCount;c++)
			{
				System.out.println(ExcelUtility.getCellValue(xlFile, sheetName, r, c));
			}
		}
		
		ExcelUtility.setCellValue(xlFile, sheetName, rowCount, cellCount, "abc");

	}

}
