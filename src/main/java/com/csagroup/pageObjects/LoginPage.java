package com.csagroup.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;
import com.csagroup.Listeners.Log;
import com.csagroup.Utilities.PropertyReader;


public class LoginPage extends CSA_Actions {
	
	public WebDriver driver;
	//public static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	PropertyReader prop = new PropertyReader();
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		//this.driver = driver;
	}	
	By Login = By.xpath("//div[@class='header-login-account-container']//button");
	By CreateAccount = By.xpath("//input[@value='Create an Account']");
	By Username = By.xpath("//input[@id='emailField']");
	By Password = By.xpath("//input[@id='passwordField']");
	By Loginbtn = By.xpath("//input[@id='send2Dsk']");
	By Logout = By.xpath("(//button[@id='logout'])[2]");
	By HeaderTitle= By.xpath("(//div[@class='searchbar-header-title'])[3]");
		
	public WebElement getLogin()
	{
		return driver.findElement(Login);
	}
	public WebElement getCreateAccount()
	{
		return driver.findElement(CreateAccount);
	}
	public WebElement getUsername()
	{
		return driver.findElement(Username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	public WebElement getLoginBtn()
	{
		return driver.findElement(Loginbtn);
	}
	
	public void getLoginverify(String uname, String pswd) throws InterruptedException
	{
		Thread.sleep(5000);
		javaScriptClick(Login,"");
		Log.info("click on Login button");
		scrollIntoView(Login);
		Log.info("Scroll the Page");
		writeText(Username, uname);
		Log.info("Enter the username:");
		writeText(Password, pswd);
		Log.info("Enter the password:");
		click(Loginbtn);
		Log.info("click Login button action is Completed");
	}

	public void Login()
	{
		click(Login);		
	}
	public void CreateAccount()
	{
		click(CreateAccount);
	}
	public void Logout()
	{
		click(Logout);
	}
	public void verifyLoginPage(String Title)
	{
		readText(HeaderTitle);
		Assert.assertEquals(readText(HeaderTitle), Title);
	}
}
