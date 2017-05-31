package com.BankerChat.PageLibrary.Unclaimed;

import java.util.List;






import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.BankerChat.TestSuiteBase.TestBase;

public class UnClaimed1 extends TestBase{
	public static Actions act = new Actions(driver);
	{
		//Getting properties file data - ATU Report
				System.setProperty("atu.reporter.config", System.getProperty("user.dir")+"//src//com//BankerChat//pageLocator//atu.properties");
	}
	private static List<WebElement> UnClaimed = null;
	
		public void UnclaimedChat() throws Exception
		{
			ATUReports.setWebDriver(driver);
			ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
			
			Reporter.log("UNCLAIMED TAB TEST : Started");
			log.info("UNCLAIMED TAB TEST : Started");
			ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
			getWebElement("BankerChat.unclaimedchat.unclaimedchattab").click();
			Reporter.log("Unclaimed Tab:Clicked\n");
			log.info("Unclaimed Tab: Clicked ");
			driverwait();
			ATUReports.add("Unclaimed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			JavascriptExecutor jgb =(JavascriptExecutor)driver;
			WebElement globe =getWebElement("BankerChat.chat.globe");
			jgb.executeScript("arguments[0].click();", globe);
			act.moveToElement(globe).click();
			driverwait();
			ATUReports.add("sidebar", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			UnClaimed = getWebElements("BankerChat.unclaimedchat.leftScrollListUnclaimed");
			Reporter.log("Unclaimed count: "+UnClaimed.size());
			log.info("Unclaimed count: "+UnClaimed.size());
			
			System.out.println("Unclaimed count:"+UnClaimed.size());
						
				if(UnClaimed.size()!=0)
				{
					for(int i=0;i<UnClaimed.size();i++)
					{
						UnClaimed.get(i).click();
						driverwait();
						ATUReports.add("First Chat Clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driverwait();
						Actions act = new Actions(driver);
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						WebElement obj = getWebElement("BankerChat.unclaimedchat.accept");
						jse.executeScript("arguments[0].click();", obj);
						act.moveToElement(obj).click();	
						Reporter.log("CLAIM THIS QUERY ICON : Clicked");
						log.info("CLAIM THIS QUERY ICON : Clicked");
						ATUReports.add("CLAIM THIS QUERY ICON : Clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
				}
			
				
				log.info("UNCLAIMED TAB TEST : End");
				Reporter.log("UNCLAIMED TAB TEST : End");
				System.out.println("UNCLAIMED TAB TEST : End");
				
		}
}