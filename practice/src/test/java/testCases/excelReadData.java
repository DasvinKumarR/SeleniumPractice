package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelUtils;

public class excelReadData {
	
	@Test(dataProvider = "excelData")
	public void displayData(String Data1, String Data2) {
		System.out.println("Data 1: "+Data1+" , Data 2: "+Data2);
	}

	@DataProvider(name = "excelData")
	public Object[][] getData(){
		ExcelUtils ca = new ExcelUtils();
		return ca.readExcel(System.getProperty("user.dir")+"/src/test/resources/propertiesFiles/DemoPage.xlsx", "Sheet1");
	}
	
}
