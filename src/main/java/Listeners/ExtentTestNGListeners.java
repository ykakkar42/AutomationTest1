package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BrowserFactory.browserFactory;
import Utility.Helper;

public class ExtentTestNGListeners implements ITestListener {
	
	ExtentReports extent=ExtentManager.getInstance();
	ThreadLocal<ExtentTest> local=new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result)
	{
		ExtentTest et=extent.createTest(result.getMethod().getMethodName());
		local.set(et);
	}
	
	public void onTestSuccess(ITestResult result)
	{    
		String base64=Helper.captureScreenshotinBase64(browserFactory.getbrowserinstance());
		local.get().pass("Test passed ",
		MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}

	public void onTestFailure(ITestResult result)
	{
		String base64=Helper.captureScreenshotinBase64(browserFactory.getbrowserinstance());
		local.get().fail("Test Failed "+result.getThrowable().getMessage(),
		MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}

	public void onTestSkipped(ITestResult result) {
		String base64=Helper.captureScreenshotinBase64(browserFactory.getbrowserinstance());
		local.get().skip("Test Failed "+result.getThrowable().getMessage(),
		MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}
	
	public void onFinish(ITestContext context) {
	   extent.flush();
	  }

}
