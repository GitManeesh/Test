package com.BankerChat.ReportTestNG;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFontFormatting;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ExcelReportGenerator {
	
	public void generateExcelReport(String destFileName) throws ParserConfigurationException, SAXException, IOException {
		
		String path = ExcelReportGenerator.class.getClassLoader().getResource("./").getPath();
		path = path.replaceAll("bin","src"); 
		File xmlFile = new File (path+"../test-output/testng-results.xml");
		
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = fact.newDocumentBuilder();
		Document doc = build.parse(xmlFile);
		doc.getDocumentElement().normalize();
				
			XSSFWorkbook book = new XSSFWorkbook();
			XSSFCellStyle fail = book.createCellStyle();
			XSSFCellStyle pass = book.createCellStyle();
			XSSFCellStyle styleheader = book.createCellStyle();
			
			NodeList test_List =doc.getElementsByTagName("test");
		
				for(int i=0;i<test_List.getLength();i++){
					int r=0;
					Node test_node = test_List.item(i);
					String test_name = ((Element)test_node).getAttribute("name");
					XSSFSheet sheet = book.createSheet(test_name);
					NodeList class_List = ((Element)test_node).getElementsByTagName("class");
			
					for(int j = 0; j<class_List.getLength();j++){
						Node class_node = class_List.item(j);
						String class_name = ((Element)class_node).getAttribute("name");
						NodeList test_method_List = ((Element)class_node).getElementsByTagName("test-method");
				
						for(int k=0; k<test_method_List.getLength();k++){
							Node test_method_node = test_method_List.item(k);
							String test_method_name = ((Element)test_method_node).getAttribute("name");
							String test_method_status = ((Element)test_method_node).getAttribute("status");
					
							fail.setFillForegroundColor(HSSFColor.RED.index);
							pass.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
							fail.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
							pass.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
							styleheader.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
							styleheader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
							styleheader.getAlignmentEnum();
														
							XSSFRow header= sheet.createRow(0);
							
							
							header.createCell(0).setCellValue("Test Name");
					 		header.createCell(1).setCellValue("Test Result");
					 		header.createCell(2).setCellValue("Error");
					 		XSSFCell headerStyle =header.getCell(0);
					 		XSSFCell headerStyle1 =header.getCell(1);
					 		XSSFCell headerStyle2 =header.getCell(2);
					 		for(int m=0;m<3;m++){
					 			XSSFFont font =book.createFont();
					 			font.setBold(true);
					 			font.setFontName("Calibri");
					 			styleheader.setFont(font);
					 			header.getCell(m).setCellStyle(styleheader);
					 		}

							for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) 
							{
					            sheet.setColumnWidth(x, 20*256);
					        }
					 			headerStyle.setCellStyle(styleheader);
					 		if("styleheader".equalsIgnoreCase("Test Name")||"styleheader".equalsIgnoreCase("Test Result")||"styleheader".equalsIgnoreCase("Error"))
					 			headerStyle.setCellStyle(styleheader);
					 			headerStyle1.setCellStyle(styleheader);
					 			headerStyle2.setCellStyle(styleheader);
					 			
							XSSFRow row = sheet.createRow(r++);
					 		XSSFCell cell_name = row.createCell(0);
					 		cell_name.setCellValue(class_name+"."+test_method_name);
					 		XSSFCell cell_status = row.createCell(1);
					 		cell_status.setCellValue(test_method_status);
					
					 		if("fail".equalsIgnoreCase(test_method_status))
					 			cell_status.setCellStyle(fail);
					 		else
					 			cell_status.setCellStyle(pass);
					
					 		XSSFCell cel_exp;
					 		String exp_msg;
					
					 		if("fail".equalsIgnoreCase(test_method_status)){
					 			NodeList exp_List =((Element)test_method_node).getElementsByTagName("exception");
					 			Node exp_node = exp_List.item(0);
					 			exp_msg = ((Element)exp_node).getAttribute("class");
								cel_exp = row.createCell(2);
								cel_exp.setCellValue(exp_msg);
					 			}
					 		
							}
						}
					
				}
		
			FileOutputStream fout = new FileOutputStream(path+"com/BankerChat/ReportTestNG/"+ destFileName);
			book.write(fout);
			fout.close();
			Reporter.log("Report Generated Sucessfully");
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
		
				
				try {
					new ExcelReportGenerator().generateExcelReport("report.xlsx");
					System.out.println("Report Generated");
				} 
				catch (Exception e) {
				
					System.out.println("Excel Workbook not created");
				}
				
				

	}
}