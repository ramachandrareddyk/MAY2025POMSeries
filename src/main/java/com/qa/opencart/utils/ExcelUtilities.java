package com.qa.opencart.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	
	private static final String TEST_DATA_FILE_PATH="./Resources/TestData/testdata.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetName) {
		
		System.out.println("reading data from sheet "+sheetName);
		Object data[][]=null;
		
		try {
			FileInputStream ip= new FileInputStream(TEST_DATA_FILE_PATH);
			book=WorkbookFactory.create(ip);
			sheet=book.getSheet(sheetName);
			
			data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			
		} catch (Exception e) {;
			// TODO: handle exception
		}
		return data;
		
	}

}
