package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static Alert waitforalert(WebDriver driver) {
		Alert alt=null;
		for(int i=0;i<15;i++)
		{
			try {
				 alt = driver.switchTo().alert();
				 break;
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("waiting for 1 more second");
				waitforseconds(1);
			}
		}
		return alt;
	}
	
	public static WebElement waitforelement(WebDriver driver, By locator, int time)
	{
		WebElement element=null;
		
		for(int i=0;i<time;i++)
		 {
			 try {
				element=driver.findElement(locator);
				 if(element.isEnabled())
					 return element;
//					 break;
			} catch (NoSuchElementException e) {
				System.out.println("Element not found"+e.getMessage());
			}
			 catch (StaleElementReferenceException e) {
				 System.out.println("Element reference not found"+e.getMessage());
			}
			 waitforseconds(1);
		 }
		 
		 return null;
	}
	
	public static Alert waitforalert(WebDriver driver, int time) {
		Alert alt=null;
		for(int i=0;i<time;i++)
		{
			try {
				 alt = driver.switchTo().alert();
				 break;
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("waiting for 1 more second");
				waitforseconds(1);
			}
		}
		return alt;
	}
	
	public static void waitforseconds(int seconds)
		{
			try
			{
				Thread.sleep(seconds*1000);
			}
			catch(InterruptedException e)
			{
			e.printStackTrace();
			}
		}
	
	public static String captureScreenshotinBase64( WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String capture= ts.getScreenshotAs(OutputType.BASE64);
		return capture;
	}
	
	public static void captureScreenshot( WebDriver driver)
	{
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File scr=ts.getScreenshotAs(OutputType.FILE);
		File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./MyScreenshots/screenshot_"+getDateAndTime()+".png");
//		File dest=new File("./myscreenshot.png");
		
		try {
			FileHandler.copy(scr, dest);
		} catch (IOException e) {
			System.out.println("Something went wrong"+e.getMessage());
		}
	}

	public static String getDateAndTime()
	{
		String date=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		return date;
	}

	public static void captureScreenshotOfElement( WebDriver driver, WebElement element)
	{
		File scr= element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ElementScreenShots/screemshot"+getDateAndTime()+".png");
		
		try
		{
			FileHandler.copy(scr, dest);
		}
		catch(IOException e)
		{
			System.out.println("Something went wrong"+e.getMessage());
		}
	}
	
	public static WebElement highlight(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:purple; border:5px solid orange')", element);
		waitforseconds(1);
		js.executeScript("arguments[0].setAttribute('style','border:5px solid white')", element);
		return element;
	}
	
	public static WebElement highlight(WebDriver driver, By locator)
	{
		WebElement element=driver.findElement(locator);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:purple; border:5px solid orange')", element);
		waitforseconds(1);
		js.executeScript("arguments[0].setAttribute('style','border:5px solid white')", element);
		return element;
	}

}
