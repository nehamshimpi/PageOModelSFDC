package com.sfdc.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CommanUtils {
	
	public static String TESTDATA_SHEET_PATH = "/Users/neha/eclipse-workspace/PageOModelSFDCProject/POMSFDC.xls";

	static Workbook book;
	static Sheet sheet;
	
	
	public static Object[][] readDataFromExcelSheet(String sheetName) throws Exception {
	
		File file = new File(TESTDATA_SHEET_PATH);
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet myExcleSheet = myExcelBook.getSheet(sheetName);
		HSSFRow row1 = myExcleSheet.getRow(0);
		System.out.println(row1.getPhysicalNumberOfCells()); //To take total number of collumns
		System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
		System.out.println(row1.getLastCellNum());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
		
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol = 0; countCol<iCountCol;countCol++) {
				HSSFRow tempRow=myExcleSheet.getRow(countRow);
				String sTemp;
				try {
				System.out.println(tempRow.getCell(countCol).getStringCellValue());
				sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception e) {
					System.out.println(tempRow.getCell(countCol).getNumericCellValue());
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
				}
				excelData[countRow][countCol] = sTemp;
			}
		}	
		return excelData;
	}

}
