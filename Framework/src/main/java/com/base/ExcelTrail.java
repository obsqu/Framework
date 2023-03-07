package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTrail {

	public static void main(String[] args) {
		

	}
public static String excel(int rowIndex,int colIndex) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\seleniumHtml\\SimpleFormexl.xlsx");
	XSSFWorkbook wrkbuk=new XSSFWorkbook(fis);
	XSSFSheet sheet=wrkbuk.getSheet("Data");
	//XSSFSheet sheet1=wrkbuk.getSheetAt(0);
	
	XSSFRow row=sheet.getRow(rowIndex);
	XSSFCell cell=row.getCell(colIndex);
	String value=cell.getStringCellValue().toString();
	return value;
}	

/*public static double excelNumeric(int rowIndex,int colIndex) {
	FileInputStream fis=new FileInputStream("");
	XSSFWorkbook wrkbuk=new XSSFWorkbook(fis);
	XSSFSheet sheet=wrkbuk.getSheet("data");
	//XSSFSheet sheet1=wrkbuk.getSheetAt(0);
	
	XSSFRow row=sheet.getRow(rowIndex);
	XSSFCell cell=row.getCell(colIndex);
	String value=cell.getStringCellValue();
	//return value;
}*/


}
