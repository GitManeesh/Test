package com.BankerChat.testScript.Sprint2_Reassign;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.BankerChat.Facebook.FacebookTest;

public class FacebookExecute extends FacebookTest{
	
	@BeforeClass
	public void OpenBrowser(){
		
		startBrowser();
	}
	
	@Test()
	public void facebook() throws Exception{
		
		FBLogin();
		FBChatInitiation();
		/*FBLogout();*/
	}
	
	/*@AfterClass
	public void CloseBrowser(){
		
		close();
	}*/
	
}
