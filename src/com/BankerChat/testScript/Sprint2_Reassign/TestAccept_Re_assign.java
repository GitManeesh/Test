package com.BankerChat.testScript.Sprint2_Reassign;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





import com.BankerChat.PageLibrary.Chat.Chat;
import com.BankerChat.PageLibrary.Chat.ChatT;
import com.BankerChat.PageLibrary.Chat.Chat_Reassign;
import com.BankerChat.PageLibrary.Profile.Profile;
import com.BankerChat.PageLibrary.Unclaimed.UnClaimed1;
import com.BankerChat.PageLibrary.loginpage.LoginPage;
import com.BankerChat.PageLibrary.loginpage.LoginPageT;
import com.BankerChat.TestSuiteBase.TestBase;


public class TestAccept_Re_assign extends TestBase {
	@BeforeClass
	public void setUp() throws Exception{
		init();
	}
	
	@Test(priority=1)
	public void testLogin()throws Exception{
		LoginPageT login = new LoginPageT();
		login.loginToApplication();
	}
	
	
	
	@Test(priority=2)
	public void testClaimed()throws Exception{
		ChatT ch = new ChatT();
		ch.ClaimedChat();
	}
	
	
	@AfterClass
	public void testDown(){
		closeBrowser();
	}
	
}
