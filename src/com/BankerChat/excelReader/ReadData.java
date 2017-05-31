package com.BankerChat.excelReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ReadData {
	public FileInputStream fis = null;
	private static XSSFWorkbook wb = null;
	private static XSSFSheet sheet = null;
	
	private static String filename = System.getProperty("user.dir")+"\\src\\com\\BankerChat\\testData\\testData.xlsx";
	public ReadData(String excelpath) throws IOException{
		
		File src=new File(excelpath);
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
	}
	
	public String getData(int sheetNumber,int row,int column){
		sheet=wb.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public int getRowCount(int sheetIndex){
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row =row+1;
		return row;
	}
	
		@DataProvider(name="readExcelData")
	 public static Object[][] readExcelData() throws IOException{
		 ReadData excel = new ReadData("E:\\BankerChat\\Workspace\\BankerChat-RSA\\src\\com\\BankerChat\\testData\\Supply.xlsx");
		 int rows = excel.getRowCount(0);
		 Object[][] data = new Object[rows][2];
		 for(int i=0;i<rows;i++){
			 data[i][0]= excel.getData(0, i, 0);
			 data[i][1]= excel.getData(0, i, 1);
			 
		 }
		 return data;
	 }

	public static void main(String arg[]) throws IOException{
		
		readExcelData();
	}
}
	