
package com.csagroup.LoginTestcases;


import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.LoginPage;
@Listeners(com.csagroup.Listeners.Log.class)
public class LoginTest extends DriverManager {
	
	LoginPage lp;
	@BeforeTest
	public void BrowserInvoke() throws IOException
	{
		DriverManager.getDriver().get(prop.getProperty("url"));		
	}
	@Test
	public void Loginverify() throws InterruptedException
	{
		lp = new LoginPage(driver);
		lp.testName="Login";
		lp.title="Login";
		lp.waitForPageToLoad();
		lp.getLoginverify(prop.getProperty("username"), prop.getProperty("password"));
		lp.waitForPageToLoad();
		lp.verifyLoginPage(prop.getProperty("ExpectedTile"));
		lp.Logout();
	}
//	@AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//	}
}
