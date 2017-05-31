package com.BankerChat.customListner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.BankerChat.utility.Utils;


public class Listner extends Utils implements ITestListener{
	
	public void onTestStart(ITestResult result) {
			
	}
	public void onTestSuccess(ITestResult result) {
		
		}
      

	
	public void onTestFailure(ITestResult result) {
		
	        try {
	        	
	        	Reporter.log("Test Failed");
				Reporter.log("<a href='" + GetScreenshot.capture(result.getName()) + "'> <img src='"+ GetScreenshot.capture(result.getName()) + "' height='100' width='100'/> </a>");
				
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	        Reporter.setCurrentTestResult(null);	
	}
		
	

	
	public void onTestSkipped(ITestResult result) {
	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
