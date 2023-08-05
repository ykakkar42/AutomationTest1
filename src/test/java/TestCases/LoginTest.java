package TestCases;

import org.testng.annotations.Test;

import BaseClass.baseClass;
import DataProvider.CustomDataProvider;
import Pages.LoginPage;

public class LoginTest extends baseClass{
	
	@Test(dataProvider = "login", dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.LoginUser(username,password);
	}

}
