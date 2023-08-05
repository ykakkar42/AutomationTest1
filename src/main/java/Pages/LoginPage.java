package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email= By.name("email1");
	By pass= By.name("password1");
	By login=By.className("submit-btn");
	
	public void LoginUser(String username, String password)
	{
		driver.findElement(email).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(login).click();
	}
}
