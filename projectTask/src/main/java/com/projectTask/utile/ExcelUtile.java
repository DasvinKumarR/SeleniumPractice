package com.projectTask.utile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtile extends CommonActions {
	
	String currentDateTime;
	
	public void CreateExcel() {
		try {
			XSSFWorkbook wkb = new XSSFWorkbook();
			XSSFSheet sheet = wkb.createSheet("TestData");
			sheet.createRow(0).createCell(0).setCellValue("Test Data");
			currentDateTime = getCurrentDateTime();
			String FileName = System.getProperty("user.dir")+"/ExcelFile/TestFile"+currentDateTime+".xlsx";
			FileOutputStream fileOut = new FileOutputStream(FileName);
			wkb.write(fileOut);
			wkb.close();
			System.out.println("\n");
			System.out.println("Excel Function Test:"+"\n");
			System.out.println("File Created Successfully...");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void WriteData(String text) {
		try {
			String FilePath = System.getProperty("user.dir")+"/ExcelFile/TestFile"+currentDateTime+".xlsx";
			File file = new File(FilePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook wkb = new XSSFWorkbook(inputStream);
			Sheet sheet = wkb.getSheet("TestData");
			int rowCount = sheet.getLastRowNum();
			int max = rowCount+5;
			for(int i=rowCount+1; i<max; i++) {
				sheet.createRow(i).createCell(0).setCellValue(text);
			}
			FileOutputStream outStream = new FileOutputStream(file);
			wkb.write(outStream);
			wkb.close();
			System.out.println("Data successfully written in Excel...");
		}catch (IOException e) {
			e.printStackTrace();
		}		
		
	}

}

