package com.BankerChat.PageLibrary.Unclaimed;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.BankerChat.TestSuiteBase.TestBase;

public class UnClaimed extends TestBase{
	private static  List<WebElement> UnClaimed = null;
	public void UnclaimedChat() throws Exception
	{	
		boolean breakIt = true;
		
		getWebElement("BankerChat.unclaimedchat.unclaimedchattab").click();
		Reporter.log("UnclaimedChat Test started\n");
		UnClaimed = getWebElements("BankerChat.unclaimedchat.leftScrollListUnclaimed");
			
		do {
				try{
						if(UnClaimed.size()!=0)
						{
						int i =0;	
						UnClaimed.get(i).click();
						i++; 
						
						Reporter.log("Unclaimed count: "+i);
												
						getWebElement("BankerChat.unclaimedchat.accept").click();
						
						Reporter.log("\n Clicked on Claim button");
						
						
						}else if(UnClaimed.size()==0){
						
							getWebElement("BankerChat.chat.chatTab").click();
							Reporter.log("Claimed Chat Tab Clicked");
							driverwait();
							
						}
					}catch (Exception e) 
				{
						if (e.getMessage().contains("element is not attached")) 
						{
							breakIt = false;
						}
				}
						if(breakIt)
						{
							break;
						}
		}
		while(UnClaimed.size()!=0);// here we can set count limit
		}					 
	

}
