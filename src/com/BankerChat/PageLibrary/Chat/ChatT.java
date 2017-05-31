package com.BankerChat.PageLibrary.Chat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.BankerChat.TestSuiteBase.TestBase;

public class ChatT extends TestBase
{
	private static  List<WebElement> Chat = null;
	
	public static Actions act = new Actions(driver);
	
	public void ClaimedChat() throws Exception
	{
		ATUReports.setWebDriver(driver);
		ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
		Reporter.log("CHATS TAB TEST: Started\n");
		log.info("CHATS TAB TEST: Started\n");
		ATUReports.add("CHATS TAB TEST: Started", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		getWebElement("BankerChat.chat.chatTab").click();		
		
		JavascriptExecutor jgb =(JavascriptExecutor)driver;
		WebElement globe =getWebElement("BankerChat.chat.globe");
		jgb.executeScript("arguments[0].click();", globe);
		act.moveToElement(globe).click();
		driverwait();
		ATUReports.add("sidebar", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
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
							 
				driverwait();
				WebElement input=getWebElement("BankerChat.chat.input");
				input.sendKeys("Hello");
				driverwait(); 
				ATUReports.add("Input", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				JavascriptExecutor jmsg =(JavascriptExecutor)driver;
				WebElement sendmsg =getWebElement("BankerChat.chat.sendmsg");
				jmsg.executeScript("arguments[0].click();", sendmsg);
				act.moveToElement(sendmsg).doubleClick();
				driverwait();	
				ATUReports.add("Send", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					/*
				
				act = new Actions(driver);
				WebElement send = getWebElement("BankerChat.chat.sendmsg");
				act.moveToElement(send);
				act.click();
				act.build().perform();
				ATUReports.add("Send", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driverwait();
				*/
				JavascriptExecutor jsc =(JavascriptExecutor)driver;
				WebElement close =getWebElement("BankerChat.chat.closebutton");
				jsc.executeScript("arguments[0].click();", close);
				act.moveToElement(close).click();
				driverwait();	
				ATUReports.add("Chat close button clicked", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
				
				JavascriptExecutor jsb = (JavascriptExecutor)driver;
				WebElement ngb = getWebElement("BankerChat.chat.ngbutton2");
				jsb.executeScript("arguments[0].click();", ngb);
				act.moveToElement(ngb).click();	
				driverwait();
				ATUReports.add("DIALOG YES OR NO: Yes clicked", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				Reporter.log("DIALOG YES OR NO: Yes clicked");
				log.info("DIALOG YES OR NO: Yes clicked");
				System.out.println("DIALOG YES OR NO: Yes clicked");
			
			}	
			 
		}
		ATUReports.add("Chat Tab test End", true);
		 Reporter.log("CHATS TAB TEST: End");
		 System.out.println("CHATS TAB TEST: End");
		 log.info("CHATS TAB TEST: End");
		  
	}	
				
}




