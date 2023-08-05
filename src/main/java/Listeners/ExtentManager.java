package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.Helper;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else {
			return extent;
		}
	}
	
	
	public static ExtentReports createInstance()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Automation_"+Helper.getDateAndTime()+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Report");
		spark.config().setDocumentTitle("Sprint 1 Report");
		
		extent=new ExtentReports();
		extent.attachReporter(spark);
		
		return extent;
	}

}
