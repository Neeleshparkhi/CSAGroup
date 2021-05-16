package com.csagroup.LoginTestcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.csagroup.config.DriverManager;
import com.csagroup.config.WebDriverManager;
import com.csagroup.pageObjects.LoginPage;
@Listeners(com.csagroup.Listeners.Log.class)
public class LoginCrossBrowserTest extends WebDriverManager {

	LoginPage lp;
	@Parameters("browser")
	@BeforeTest
	public void BrowserInvoke(String browser) throws IOException
	{
		WebDriverManager.getDriver(browser).get(prop.getProperty("url"));
	}
	@Test
	public void Loginverify() throws InterruptedException
	{
		lp = new LoginPage(driver);
		lp.testName="LoginCross";
		lp.title="Login";
		lp.waitForPageToLoad();
		lp.getLoginverify(prop.getProperty("username"), prop.getProperty("password"));
		lp.waitForPageToLoad();
		lp.verifyLoginPage(prop.getProperty("ExpectedTile"));
		lp.Logout();
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
