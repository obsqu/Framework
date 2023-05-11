package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.AutomationConstants;

public class ExcelRead {
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static FileInputStream f;

	public static List<List<String>> excelDataReader(String sheetName){

		DataFormatter formatter = new DataFormatter();
		try {
			f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\RestaurantDatas.xlsx");
		} catch (FileNotFoundException e) {
			
		}
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {
			
		}
		sh = wb.getSheet(sheetName);
		List<List<String>> excelRows = new ArrayList<>();
		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		for (int i = 0; i < rowCount + 1; i++) {
			int x = 0;
			Row row = sh.getRow(i);
			String[] columnList = new String[row.getLastCellNum()];
			for (int j = 0; j < columnList.length; j++) {
				columnList[j] = formatter.formatCellValue(row.getCell(x));
				x++;
			}
			excelRows.add(new ArrayList<>(Arrays.asList(columnList)));
		}
		return excelRows;
	}

}
