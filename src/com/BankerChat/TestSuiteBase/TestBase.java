package com.BankerChat.TestSuiteBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.BankerChat.excelReader.ReadData;
import com.BankerChat.excelReader.Xls_Reader;
import com.BankerChat.utility.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })

public class TestBase extends Utils{
	
	{	//Getting properties file data - ATU Report
	System.setProperty("atu.reporter.config", 
	System.getProperty("user.dir")+"//src//com//BankerChat//pageLocator//atu.properties");
	}
	
 private static final String filename = System.getProperty("user.dir")+"\\src\\com\\BankerChat\\testData\\testData.xlsx";
 public static Properties Repository = new Properties();
 public File f;
 public FileInputStream FI;
 public Xls_Reader Data;
 
  public void init() throws IOException{
  loadPropertiesFile();
  ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(
			ScreenshotOf.BROWSER_PAGE));
  selectBrowser(Repository.getProperty("browser"));
  impliciteWait(30);
  driver.get(Repository.getProperty("url"));
  ATUReports.setWebDriver(driver);
  ATUReports.indexPageDescription = "BankerChat Test";
  }
  
 public void loadPropertiesFile() throws IOException {
  f = new File(System.getProperty("user.dir")+"\\src\\com\\BankerChat\\configuration\\config.properties");
  FI = new FileInputStream(f);
  Repository.load(FI);
  
  f = new File(System.getProperty("user.dir")+"\\src\\com\\BankerChat\\pageLocator\\loginpage.properties");
  FI = new FileInputStream(f);
  Repository.load(FI);
  
  f = new File(System.getProperty("user.dir")+"\\src\\com\\BankerChat\\pageLocator\\ProfilePage.properties");
  FI = new FileInputStream(f);
  Repository.load(FI);
  
  f = new File(System.getProperty("user.dir")+"\\src\\com\\BankerChat\\pageLocator\\chatpage.properties");
  FI = new FileInputStream(f);
  Repository.load(FI);
  
  f = new File(System.getProperty("user.dir")+"\\src\\com\\BankerChat\\pageLocator\\unclaimedpage.properties");
  FI = new FileInputStream(f);
  Repository.load(FI);
  
  f = new File(System.getProperty("user.dir")+"\\src\\com\\BankerChat\\pageLocator\\chathistory.properties");
  FI = new FileInputStream(f);
  Repository.load(FI);
 }
 
 public static WebElement getLocator(String locator) throws Exception {
	 String[] split = locator.split("_");
	 String locatorType = split[0];
	 String locatorValue = split[1];

  if (locatorType.toLowerCase().equals("id"))
   return driver.findElement(By.id(locatorValue));
  else if (locatorType.toLowerCase().equals("name"))
   return driver.findElement(By.name(locatorValue));
  else if ((locatorType.toLowerCase().equals("classname"))
    || (locatorType.toLowerCase().equals("class")))
   return driver.findElement(By.className(locatorValue));
  else if ((locatorType.toLowerCase().equals("tagname"))
    || (locatorType.toLowerCase().equals("tag")))
   return driver.findElement(By.className(locatorValue));
  else if ((locatorType.toLowerCase().equals("linktext"))
    || (locatorType.toLowerCase().equals("link")))
   return driver.findElement(By.linkText(locatorValue));
  else if (locatorType.toLowerCase().equals("partiallinktext"))
   return driver.findElement(By.partialLinkText(locatorValue));
  else if ((locatorType.toLowerCase().equals("cssselector"))
    || (locatorType.toLowerCase().equals("css")))
   return driver.findElement(By.cssSelector(locatorValue));
  else if (locatorType.toLowerCase().equals("xpath"))
   return driver.findElement(By.xpath(locatorValue));
  else
   throw new Exception("Unknown locator type '" + locatorType + "'");
 }
 
 public static List<WebElement> getLocators(String locator) throws Exception {
        String[] split = locator.split("_");
  String locatorType = split[0];
  String locatorValue = split[1];

  if (locatorType.toLowerCase().equals("id"))
   return driver.findElements(By.id(locatorValue));
  else if (locatorType.toLowerCase().equals("name"))
   return driver.findElements(By.name(locatorValue));
  else if ((locatorType.toLowerCase().equals("classname"))
    || (locatorType.toLowerCase().equals("class")))
   return driver.findElements(By.className(locatorValue));
  else if ((locatorType.toLowerCase().equals("tagname"))
    || (locatorType.toLowerCase().equals("tag")))
   return driver.findElements(By.className(locatorValue));
  else if ((locatorType.toLowerCase().equals("linktext"))
    || (locatorType.toLowerCase().equals("link")))
   return driver.findElements(By.linkText(locatorValue));
  else if (locatorType.toLowerCase().equals("partiallinktext"))
   return driver.findElements(By.partialLinkText(locatorValue));
  else if ((locatorType.toLowerCase().equals("cssselector"))
    || (locatorType.toLowerCase().equals("css")))
   return driver.findElements(By.cssSelector(locatorValue));
  else if (locatorType.toLowerCase().equals("xpath"))
   return driver.findElements(By.xpath(locatorValue));
  else
   throw new Exception("Unknown locator type '" + locatorType + "'");
 }
 
 public WebElement getWebElement(String locator) throws Exception{
  return getLocator(Repository.getProperty(locator));
 }
 
 public List<WebElement> getWebElements(String locator) throws Exception{
  return getLocators(Repository.getProperty(locator));
 }
 
 public void closeBrowser(){
  driver.close();
  
 }
 
 @DataProvider(name="readExcelData")
 public Object[][] readExcelData() throws IOException{
	 ReadData excel = new ReadData("E:/BankerChat/Workspace/BankerChat-RSA/src/com/BankerChat/testData/Supply.xlsx");
	 int rows = excel.getRowCount(0);
	 Object[][] data = new Object[rows][2];
	 for(int i=0;i<rows;i++){
		 data[i][0]= excel.getData(0, i, 0);
		 data[i][1]= excel.getData(0, i, 1);
		 
	 }
	 return data;
 }
	         

}
 
	 
 
 
	  

