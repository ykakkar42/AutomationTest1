package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listnerDemo implements ITestListener{
	
	public  void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Passed "+result.getMethod().getMethodName());
	}
	
	public  void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed"+result.getMethod().getMethodName());
		System.out.println("Expection generated from the test "+result.getThrowable().getMessage());
	}

}
