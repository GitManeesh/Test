package com.BankerChat.utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class Utils  {

	public static WebDriver driver;
	
	public static Logger log =Logger.getLogger("Utils");
	
	public static WebDriver selectBrowser(String browser){
	
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//com//BankerChat//log//log4j.properties");
		
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("Firefox Browser started....");
			System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir")+"//src//com//BankerChat//BrowserDrivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Chrome Browser started....");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//com//BankerChat//BrowserDrivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		else if(browser.equalsIgnoreCase("edge")){
			System.out.println("Microsoft Edge Browser started....");
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//src//com//BankerChat//BrowserDrivers//MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}
	
	public void impliciteWait(int timeInsec){
		log.info("Wait for page to load.......");
		Reporter.log("Page Load Initiated: Waiting to load page.......");
		try {
			driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
			log.info("Page is loaded");
			Reporter.log("Page Load Status: Page is loaded");
		} catch (Throwable error) {
			log.info("Timeout for the Page Load Request to complete after"+timeInsec+"seconds");
			log.assertLog(false, "Time for the page load request after"+timeInsec+"second");
			Reporter.log("Timeout for the Page Load Request to complete after"+timeInsec+"seconds");
			Assert.assertTrue("Time for the page load request after"+timeInsec+"second",false);	
		}
	}
	public void driverwait() throws InterruptedException{
		log.info("Waiting for 5 seconds........");
		log.debug(log);
		Reporter.log("Waiting for 5 seconds........");
		Thread.sleep(5000);
	}
	
	public void AutoFit(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='90%'");
		
	}
	 public void seleteDropDownValue(WebElement element, String dropDownValue){
	  Select select = new Select(element);
	  log.info("selecting "+dropDownValue+" value in dropdown");
	  Reporter.log("selecting "+dropDownValue+" value in dropdown");
	  select.selectByVisibleText(dropDownValue);
	 }
	 
	 public void driverwait(int timeToWaitInSec) throws InterruptedException{
		log.info("waiting for "+timeToWaitInSec+" seconds..."); 
	  Reporter.log("waiting for "+timeToWaitInSec+" seconds...");
	  Thread.sleep(timeToWaitInSec*1000);
	 }
	 
	 public static void expliciteWait(WebElement element, int timeToWaitInSec) {
	  WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
	  wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 public void driverwait1() throws InterruptedException{
		 log.info("Waiting for 10 seconds........");
			Reporter.log("Waiting for 10 seconds........");
			Thread.sleep(10000);
		}

		 
}


