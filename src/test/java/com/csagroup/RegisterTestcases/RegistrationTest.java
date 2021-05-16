package com.csagroup.RegisterTestcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.Utilities.PropertyReader;
import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.LoginPage;
import com.csagroup.pageObjects.Register;
@Listeners(com.csagroup.Listeners.Log.class)
public class RegistrationTest extends DriverManager {
	
	public static Logger Log = LogManager.getLogger(RegistrationTest.class.getName());
    Register reg;
    LoginPage lp;
	@BeforeTest
	public void BrowserInvoke() throws IOException, InterruptedException
	{
		DriverManager.getDriver().get(prop.getProperty("url"));
		Log.info("Launching Browser and enter the URL");
		Thread.sleep(3000);
	}
	@Test
	public void Registration() throws InterruptedException
	{
		lp = new LoginPage(driver);
	    reg = new Register(driver);
		lp.testName="Register";
		lp.title="Register";
		reg.PopupClose();
		lp.Login();
		Log.info("Click on the Login");
		lp.CreateAccount();
		Log.info("Click on the Create Account");
		Thread.sleep(5000);
		//reg.PopupClose();
		reg.selectTitle(prop.getProperty("Title"));
		Log.info("Select the Title");
		reg.FirstName(prop.getProperty("Firstname"));
		Log.info("Enter the FirstName");
		reg.LastName(prop.getProperty("Lastname"));
		Log.info("Enter the LastName");
		reg.Phonenumber(prop.getProperty("Phone"));
		Log.info("Enter the Phonenumber");
		reg.scroll();
		Log.info("Scroll the Page");
		reg.selectLanguage(prop.getProperty("Language"));
		Log.info("Select the Language");
		reg.Companyname(prop.getProperty("Company"));
		Log.info("Enter the Company CompanyName");
		reg.selectIndustry(prop.getProperty("Industry"));
		Log.info("Select the Industry");
		reg.selectMarket(prop.getProperty("Market"));
		Log.info("Select the Market");
		reg.scroll();
		reg.selecctJobFuction(prop.getProperty("JobFunction"));
		Log.info("Select the Jon Function");
		reg.Jobtitle(prop.getProperty("JobTitle"));
		Log.info("Enter the Job Title");
		reg.EmailAddress(prop.getProperty("Email"));
		Log.info("Enter the Email address");
		reg.Password(prop.getProperty("Password"));
		Log.info("Enter the Password");
		reg.ConfirmPassword(prop.getProperty("ConfirmPassword"));
		Log.info("Enter the ConfirmPassword");
		Thread.sleep(3000);
		reg.scroll();
		Log.info("Scroll the Page");
		reg.getAddress(prop.getProperty("BillingAddress"));
		Log.info("Enter the Address");
		reg.selectCountry(prop.getProperty("Country"));
		Log.info("Select the Country");
		reg.selectState(prop.getProperty("State"));
		Log.info("Select the State");
		reg.city(prop.getProperty("City"));
		Log.info("Select the City");
		reg.postalCode(prop.getProperty("PostalCode"));
		Log.info("Select the Postal Code");
		reg.scroll();
		Log.info("Scroll the Page");
		reg.Shippingaddress(prop.getProperty("ShippingAddress"));
		Log.info("Enter the Shipping Address");
		reg.ShipCountry(prop.getProperty("ShippingCountry"));
		Log.info("Select the Shipping Country");
		reg.ShipState(prop.getProperty("ShippingState"));
		Log.info("Select the Shipping State");
		reg.ShipCity(prop.getProperty("ShippingCity"));
		Log.info("Enter the Shipping City");
		reg.ShipPostalCode(prop.getProperty("ShippingPostalCode"));
		Log.info("Enter the Shipping PostalCode");
		reg.scroll();
		Log.info("Scroll the Page");
		reg.ClickonTermsAndCondition();
		Log.info("Click on the Terms&Conditions checkbox");
		reg.ClickonPprivacyPolicy();
		Log.info("Click on the PrivacyPolicy checkbox");
		Thread.sleep(3000);
		reg.CreateAccountBtn();
		Log.info("Click on the Submition the Register Form");		
		Thread.sleep(8000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		Log.info("Close the Browser");
	}
}
