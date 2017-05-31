package com.BankerChat.PageLibrary.Chat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.BankerChat.TestSuiteBase.TestBase;

public class Chat_Reassign extends TestBase
{
	private static  List<WebElement> Chat = null;
	
	public static Actions act = new Actions(driver);
	
	public void ReassignChat() throws Exception
	{
		ATUReports.setWebDriver(driver);
		ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
		Reporter.log("CHATS TAB TEST: Started\n");
		log.info("CHATS TAB TEST: Started\n");
		ATUReports.add("CHATS TAB TEST: Started", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		getWebElement("BankerChat.chat.chatTab").click();		
		Chat = getWebElements("BankerChat.chat.leftScrollList");
		Reporter.log("CLAIMED COUNT: "+Chat.size());
		log.info("CLAIMED COUNT: "+Chat.size());
		System.out.println("Claimed Count: "+Chat.size());
		
		
		if(Chat.size()!=0)
		{
			
			for(int i=0;i<Chat.size();i++)
			{		
				Chat.get(i).click();
				
				ATUReports.add("First chat clicked", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));						
				JavascriptExecutor jsc =(JavascriptExecutor)driver;
				WebElement reassign =getWebElement("BankerChat.chat.Reassign");
				jsc.executeScript("arguments[0].click();", reassign);
				act.moveToElement(reassign).click();
				driverwait();	
				ATUReports.add("Chat close button clicked", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
				JavascriptExecutor jsb = (JavascriptExecutor)driver;
				WebElement ngb = getWebElement("BankerChat.chat.ngbutton3");
				jsb.executeScript("arguments[0].click();", ngb);
				act.moveToElement(ngb).click();	
				driverwait1();
				ATUReports.add("DIALOG YES OR NO: Yes clicked", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Reporter.log("DIALOG YES OR NO: Yes clicked");
				log.info("DIALOG YES OR NO: Yes clicked");
				System.out.println("DIALOG YES OR NO: Yes clicked");
				
				
				 act = new Actions(driver);
				 WebElement search = getWebElement("BankerChat.chat.searchbutton");
				 act.moveToElement(search);
				 act.click();
				 act.sendKeys("t");
				 act.build().perform();
				
				driverwait();
				ATUReports.add("Search", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Reporter.log("Search");
				log.info("Search");
				
				act = new Actions(driver);
				WebElement torsa = getWebElement("BankerChat.chat.torsa");
				act.moveToElement(torsa);
				act.click().build().perform();
				driverwait();
				ATUReports.add("Torsa", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				act = new Actions(driver);
				JavascriptExecutor jb = (JavascriptExecutor)driver;
				WebElement reassignclient= getWebElement("BankerChat.chat.reassignclient");
				jb.executeScript("arguments[0].click();", reassignclient);
				act.moveToElement(reassignclient).click();
				driverwait();
				ATUReports.add("reassignclient", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				act = new Actions(driver);
				JavascriptExecutor dg = (JavascriptExecutor)driver;
				WebElement closedialog= getWebElement("BankerChat.chat.closedialog");
				dg.executeScript("arguments[0].click();", closedialog);
				act.moveToElement(closedialog).click();
				driverwait();
				ATUReports.add("closedialog", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}	
			 
		}
		
		 Reporter.log("CHATS TAB TEST: End");
		 System.out.println("CHATS TAB TEST: End");
		 log.info("CHATS TAB TEST: End");
		  
	}

	
				
}




