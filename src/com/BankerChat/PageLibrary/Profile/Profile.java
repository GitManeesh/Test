package com.BankerChat.PageLibrary.Profile;



import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.BankerChat.TestSuiteBase.TestBase;

public class Profile extends TestBase 

{
	
	public void signOut()throws Exception 
	{
		ATUReports.setWebDriver(driver);
		ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
		Reporter.log("SIGNOUT TEST : Started");
		log.info("SIGNOUT TEST : Started");
		Actions act = new Actions(driver);
		driverwait();		
		WebElement elementToClick = getWebElement("profile.click");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
		elementToClick.click();
		driverwait1();
		ATUReports.add("Profile Tab: Icon Clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Reporter.log("Profile Tab: Icon Clicked");
		log.info("PROFILE TAB: Icon Clicked");
		System.out.println("PROFILE TAB: Icon Clicked");				
		
		act.moveToElement(getWebElement("profile.logout"));
		act.click().build().perform();
		driverwait1();
		ATUReports.add("SIGN OUT: Clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Reporter.log("SIGN OUT: Clicked");
		log.info("SIGN OUT: Clicked");
		System.out.println("SIGN OUT: Clicked");
		driverwait();
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement obj = getWebElement("profile.dialogClose");
		jse.executeScript("arguments[0].click();", obj);
		act.moveToElement(obj).click();	
		driverwait1();	
		ATUReports.add("DIALOG YES OR NO: Yes clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		log.info("DIALOG YES OR NO: Yes clicked");
		Reporter.log("DIALOG YES OR NO: Yes clicked");
		Reporter.log("Logout : Logged Out Successfully....");
		log.info("Logout : Logged Out Successfully....");
		
		ATUReports.add("SIGNOUT TEST : End",true	);
		Reporter.log("SIGNOUT TEST : End");
		log.info("SIGNOUT TEST : End");
		
	}
}