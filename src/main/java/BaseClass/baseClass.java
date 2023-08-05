package BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import BrowserFactory.browserFactory;
import DataProvider.Configurator;

public class baseClass {
	
	public WebDriver driver;
	@BeforeMethod
	public void startBrowser()
	{
		System.out.println("LOG-INFO: Setting up browser");
		//config file usage- not suitable for cross browser test
		driver=browserFactory.startbrowser(Configurator.getproperty("./Config/Sample.properties", "browser"),Configurator.getproperty("./Config/Sample.properties", "url"));
		System.out.println("LOG-INFO: Browser and Application is up and running");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("LOG-INFO: Closing the browser");
		driver.quit();
		System.out.println("LOG-INFO: Browser closed");
	}

}
