package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public Object[][] readExcel(String filePath, String sheetName) {
		Object[][] data = null;
		try {
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			int columns = sheet.getRow(0).getLastCellNum();
			data = new Object[rows][columns];
			for(int i=1; i<=rows; i++) {
				for(int j=0; j<columns; j++) {
					data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
