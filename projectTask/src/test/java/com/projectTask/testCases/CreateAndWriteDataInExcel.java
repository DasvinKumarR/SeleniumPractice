package com.projectTask.testCases;

import org.testng.annotations.Test;

import com.projectTask.utile.ExcelUtile;

public class CreateAndWriteDataInExcel {

	@Test
	public void writeDataToExcelTest() {
		ExcelUtile eu = new ExcelUtile();
		//create excel file.
		eu.CreateExcel();
		//write data in excel file
		eu.WriteData("10Win");
		
	}
	
	
}
