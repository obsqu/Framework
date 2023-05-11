package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	 final static  String currentDir=System.getProperty("user.dir");
	 static String filePath=currentDir+".//src/test//resources//RestaurantDatas.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	File file=new File(filePath);
	
	public ExcelUtils() throws IOException
	{
		//excelPath=filePath+fileName;
		//File file=new File(excelPath);
		//fs=new FileInputStream(file);
		try {
			workbook=new XSSFWorkbook(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=(XSSFSheet)workbook.getSheetAt(0);
	}
	
	/**This method to get count row
	 * 
	 */
	public  int getRowCount() {
		int rowCount=0;
		try {
			rowCount=sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rowCount;
	}
	
	/**This method is to count the column
	 * 
	 * @return
	 */
	public  int getColCount() {
		int colCount=0;
		try {
			colCount=sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colCount;
	}
	
	/** This method is to read string datas from excel sheet
	 * 
	 * @param fileName
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws IOException
	 */
	public  String readStringData(String sheetname,int rowNum,int colNum) throws IOException
	{
		String cellValue=sheet.getRow(rowNum-1).getCell(colNum-1).getStringCellValue();
		return cellValue;
		
		/*workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetname);
		sheet=workbook.getSheetAt(0);
		Row row=sheet.getRow(rowNum);
		Cell c=row.getCell(colNum);
		System.out.println("**************"+c.getStringCellValue());
		return c.getStringCellValue();*/
	}
	
	/**This method is to read integer datas from excel sheet
	 * 
	 * @param fileName
	 * @param rowNum
	 * @param colNum
	 * @param sheetname
	 * @return
	 * @throws IOException
	 */
	public  int readIntegerData(int rowNum,int colNum,String sheetname) throws IOException {
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetname);
		Row row=sheet.getRow(rowNum);
		Cell c=row.getCell(colNum);
		int a=(int) c.getNumericCellValue();
		return a;
	}

}
