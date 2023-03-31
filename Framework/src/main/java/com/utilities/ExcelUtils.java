package com.utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static final String currentDir=System.getProperty("user.dir");
	public static String filePath=currentDir+"/src/test/resources/";
	static String excelPath;
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String fileName) throws IOException
	{
		excelPath=filePath+fileName;
		workbook=new XSSFWorkbook(excelPath);
		sheet=(XSSFSheet)workbook.getSheetAt(0);
	}
	
	/**This method to get count row
	 * 
	 */
	public static int getRowCount() {
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
	public static int getColCount() {
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
	public static String readStringData(String sheetname,int rowNum,int colNum) throws IOException
	{
		
		
		workbook=new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetname);
		Row row=sheet.getRow(rowNum);
		Cell c=row.getCell(colNum);
		
		return c.getStringCellValue();
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
	public static int readIntegerData(String fileName,int rowNum,int colNum,String sheetname) throws IOException {
		String excelPath=filePath+fileName;
		workbook=new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetname);
		Row row=sheet.getRow(rowNum);
		Cell c=row.getCell(colNum);
		int a=(int) c.getNumericCellValue();
		return a;
	}

}
