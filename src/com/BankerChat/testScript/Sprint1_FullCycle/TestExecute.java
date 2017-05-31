package com.BankerChat.testScript.Sprint1_FullCycle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.BankerChat.PageLibrary.Chat.Chat;
import com.BankerChat.PageLibrary.Profile.Profile;
import com.BankerChat.PageLibrary.Unclaimed.UnClaimed1;
import com.BankerChat.PageLibrary.loginpage.LoginPage;
import com.BankerChat.TestSuiteBase.TestBase;


public class TestExecute extends TestBase {
	@BeforeClass
	public void setUp() throws Exception{
		init();
	}
	
	@Test(priority=1)
	public void testLogin()throws Exception{
		LoginPage login = new LoginPage();
		login.loginToApplication();
	}
	
	@Test(priority=2)
	public void testUnclaimed()throws Exception{
			UnClaimed1 un= new UnClaimed1();
			un.UnclaimedChat();
	}
	
	@Test(priority=3)
	public void testClaimed()throws Exception{
		Chat ch = new Chat();
		ch.ClaimedChat();
	}
	
	@Test(priority=4)
	public void testSignOut() throws Exception{
	Profile pr = new Profile();
	pr.signOut();
	}
	
	@AfterClass
	public void testDown(){
		closeBrowser();
	}
	
}
