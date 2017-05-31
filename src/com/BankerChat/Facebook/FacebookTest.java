package com.BankerChat.Facebook;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
//Listners Initialization
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class FacebookTest {
	{	
		//Getting properties file data - ATU Report
		System.setProperty("atu.reporter.config", System.getProperty("user.dir")+"//src//com//BankerChat//pageLocator//atu.properties");
	}
		//Global Declaration of variables	
		public static WebDriver driver =null;
		public static Actions act = null; 
		public static Logger log =Logger.getLogger("FacebookTest");
	
	public void startBrowser() {
		//Properties file location-Getting properties file
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//com//BankerChat//log//log4j.properties");
		//ATU Report AuthorInformation	
		ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
		//Chrome Browser initialization
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				
		System.getProperty("user.dir")+ "\\src\\com\\BankerChat\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  	//ATU Reporter listners	
		ATUReports.setWebDriver(driver);
	  	ATUReports.indexPageDescription = "Facebook Test and BankerChat Test";
	  	ATUReports.add("Browser Start", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	  	log.info("Browser Started");
	  	Reporter.log("Browser Started");
	}

	
	 public void FBLogin()throws Exception{
		ATUReports.setWebDriver(driver);
		ATUReports.setAuthorInfo("Maneesh Chandra", "2017-03-01", "1.0");
		
		driver.get("https://facebook.com/");
		log.info("FaceBook Page is loaded");
		Reporter.log("FaceBook Page is loaded");
		ATUReports.add("Page Load", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		WebElement usr =driver.findElement(By.xpath("//input[@id='email']"));
		usr.clear();
		usr.sendKeys("markreevs0@gmail.com");
		log.info("USER NAME :markreevs0@gmail.com");
		Reporter.log("USER NAME :markreevs0@gmail.com");
		ATUReports.add("Enter User Name", "markreevs0@gmail.com", "markreevs0@gmail.com", "markreevs0@gmail.com",true);
		WebElement psw =driver.findElement(By.xpath("//input[@id='pass']"));
		psw.clear();
		psw.sendKeys("P@ssw0rd2");
		Reporter.log("PASSWORD: P@ssw0rd2");
		log.info("PASSWORD: P@ssw0rd2");
		ATUReports.add("Enter Password", "P@ssw0rd2", "P@ssw0rd2", "P@ssw0rd2",true);
		WebElement button = driver.findElement(By.id("loginbutton"));
		button.click();
		ATUReports.add("Button Click", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		log.info("Login Button Clicked");
		Reporter.log("Login Button Clicked");
		driverwait();
    }

	 public void FBChatInitiation()throws Exception{
		 ATUReports.setWebDriver(driver);
			    
		 WebElement chat = driver.findElement(By.xpath("//div[2]/div[2]/div/a/div"));
		 chat.click();
		 driverwait();
		 log.info("Chat Icon clicked");
		 Reporter.log("Chat Icon clicked");
		 ATUReports.add("Chat Icon", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 WebElement seeMore = driver.findElement(By.xpath("//a[@class='seeMore' and @accesskey='4']"));
		 seeMore.click();
		 driverwait();
		 log.info("View more chat details tab clicked");
		 Reporter.log("View more chat details tab clicked");
		 ATUReports.add("seeMore", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 driver.findElement(By.xpath("//input[@class='_58al' and @type='text']")).sendKeys("SBSA South Africa");
		 ATUReports.add("SBSA Input", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 log.info("SBSA South Africa value Entered");
		 Reporter.log("SBSA South Africa value Entered");
		 driver.findElement(By.xpath("//div[2]/ul/li[1]/a/div/div[1]/div/div/div[1]/img")).click();
		 driverwait();
		 log.info("SBSA logo clicked");
		 Reporter.log("SBSA logo clicked");
		 ATUReports.add("SBSA Logo", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 act = new Actions(driver);
		 act.moveToElement(driver.findElement(By.xpath("//div[@class='_1mf _1mj']")));
		 act.click();
		 act.sendKeys("Hello");
		 act.build().perform();
		 driverwait();			
		 log.info("Hello value entered");
		 Reporter.log("Hello value entered");
		 ATUReports.add("Hello Message", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));						
		 WebElement send = driver.findElement(By.xpath("//em[text()='Send']"));
		 ////div[1]/div/ul/a[@data-tooltip-content='Press Enter to send']
		 send.click();
		 driverwait();
		 ATUReports.add("Send", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 log.info("Send button clicked");	
		 Reporter.log("Send button clicked");
	}
	 public void FBLogout()throws Exception{
	 		
	 	ATUReports.setWebDriver(driver);
	 	WebElement usr =driver.findElement(By.xpath("//div[@id='userNavigationLabel']"));
		usr.click();
		driverwait();
		ATUReports.add("Dropdown Clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		log.info("Logout dropdown button clicked");
		Reporter.log("Logout dropdown button clicked");
		WebElement psw =driver.findElement(By.xpath("//li[12]/a[@role='menuitem']"));
		psw.click();
		driverwait();
		ATUReports.add("Logout Clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		log.info("Logout tab clicked");
		Reporter.log("Logout tab clicked");
	    }
	 
	public void driverwait() throws InterruptedException{
			
			Thread.sleep(3000);
			
	}	

	 	public void close() {
		driver.quit();
		ATUReports.setWebDriver(driver);
		ATUReports.add("Facebook test End", true);
		log.info("Browser Close");
		Reporter.log("Browser Close");
	}
}
