package com.BankerChat.PageLibrary.ChatHistory;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.BankerChat.TestSuiteBase.TestBase;

public class ChatHistory extends TestBase
{
	private static  List<WebElement> Chat = null;
	
	public static Actions act = new Actions(driver);
	
	public void ChatHist() throws Exception
	{
		
		
		getWebElement("BankerChat.chat.chatTab").click();		
		Chat = getWebElements("BankerChat.chat.leftScrollList");
		log.info("Claimed Tab Test started");
		Reporter.log("Claimed Tab Test started\n");
		Reporter.log("Claimed Count: "+Chat.size());
		log.info("Claimed Count: "+Chat.size());
		System.out.println("Claimed Count: "+Chat.size());
	
		if(Chat.size()!=0)
		{
			
			for(int i=0;i<Chat.size();i++)
			{		
				Chat.get(i).click();
				
				JavascriptExecutor jsh =(JavascriptExecutor)driver;
				WebElement Hist =getWebElement("BankerChat.chat.histButton");
				jsh.executeScript("arguments[0].click();", Hist);
				act.moveToElement(Hist).click();
				driverwait();
				log.info("History Button Clicked");
				getWebElement("BankerChat.chat.inputBox1").sendKeys("15-06-2016");
				driverwait();
				log.info("Date entered in input box");
				JavascriptExecutor jsv =(JavascriptExecutor)driver;
				WebElement view =getWebElement("BankerChat.chat.viewHist");
				jsv.executeScript("arguments[0].click();", view);
				act.moveToElement(view).click();
				driverwait();
				log.info("View history button clicked");
				JavascriptExecutor jsd =(JavascriptExecutor)driver;
				WebElement dialog =getWebElement("BankerChat.chat.ngbutton");
				jsd.executeScript("arguments[0].click();", dialog);
				act.moveToElement(dialog).click();
				driverwait();
				log.info("History Dialog Button (Yes) Clicked....");
				
				WebElement data =getWebElement("BankerChat.chat.histData");
							
				driverwait1();
				Reporter.log(data.getText());
				System.out.println(data.getText());
				
				
			}	
			driverwait();
		}
		log.info("Chat History Session End");
		Reporter.log("Chat History Session End");
		 System.out.println("Chat History Session End");
		driverwait();				
	}	
				
}




