package com.BankerChat.PageLibrary.loginpage;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.BankerChat.TestSuiteBase.TestBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })
public class LoginPage extends TestBase {

		public void loginToApplication() throws Exception{
		Reporter.log("LOGIN TEST : Started");
		log.info("LOGIN TEST : Started");
		ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
		//LoginId Entered	
		WebElement userName = getWebElement("BankerChat.login.username");
		userName.clear();
		log.info("USERNAME: "+Repository.getProperty("username"));
		userName.sendKeys(Repository.getProperty("username"));
		
		driverwait();
		ATUReports.add("Enter UserName", "AnitaTest1", "login", "login",true);
		
		//Password Entered
		WebElement password = getWebElement("BankerChat.login.password");
		password.clear();
		log.info("PASSWORD:"+Repository.getProperty("password"));
		password.sendKeys(Repository.getProperty("password"));
		driverwait();
		ATUReports.add("Enter pass", "Torsa123", "login", "login",true);
		
		//Signin Button Clicked
		log.info("SIGNIN : CLICKED\n");
		
		WebElement button = getWebElement("BankerChat.login.loginButton");
		button.click();
		driverwait();
		AutoFit();
		Reporter.log("LOGIN TEST : End");
		log.info("LOGIN TEST : End");
	}
	
	
	public void loginToApplication(String userName, String password) throws Exception{
		
		//LoginId Entered	
		WebElement UserName = getWebElement("BankerChat.login.username");
		UserName.clear();
		log.info("Username :"+userName);
		Reporter.log("Username :\n"+userName);
		UserName.sendKeys(userName);
		
		//Password Entered
		WebElement Password = getWebElement("BankerChat.login.password");
		Password.clear();
		log.info("Password: "+password);
		Reporter.log("Password: \n"+password);
		Password.sendKeys(password);
		
		//Signin Button Clicked
		WebElement button = getWebElement("BankerChat.login.loginButton");
		button.click();
		driverwait();
		log.info("Signin: Clicked");
		Reporter.log("Signin: Clicked" );
		log.info("Login :Login Test Completed");
		log.assertLog(false, "Error in  Login Session ");
		Reporter.log("Login :Login Test Completed");
		
	}
	
	

}
