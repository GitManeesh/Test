package com.BankerChat.customListner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BankerChat.TestSuiteBase.TestBase;

public class GetScreenshot extends TestBase {
	
	public static String capture(String screenshot){
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\src\\com\\BankerChat\\screenShot\\"+screenshot+".jpg";
		File des = new File(destination);
		
		
		try {
			FileUtils.copyFile(scrFile, des);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destination;
	}
}
