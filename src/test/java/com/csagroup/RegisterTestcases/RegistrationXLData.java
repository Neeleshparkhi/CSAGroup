package com.csagroup.RegisterTestcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.LoginPage;
import com.csagroup.pageObjects.Register;
@Listeners(com.csagroup.Listeners.Log.class)
public class RegistrationXLData extends DriverManager {

	
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
	
	@Test(dataProvider="getRegistration")
	public void Registration(String Prefix, String FirstName, String LastName, String PhoneNumber, String PreferredLanguage, String CompanyName,
			String Industry, String Market, String JobFunction, String JobTitle, String Email, String Password, String ConfirmPassword, String BillingAddress,
			String Country, String State, String City, String ZipCode, String ShippingAddress,
			String ShippingCountry, String ShippingState, String ShippingCity, String ShippingZipCode) throws InterruptedException
	{
		lp = new LoginPage(driver);
	    reg = new Register(driver);
		lp.testName="Register";
		lp.title="Register";
		//reg.PopupClose();
		lp.Login();
		Log.info("Click on the Login");
		lp.CreateAccount();
		Log.info("Click on the Create Account");
		Thread.sleep(5000);
		//reg.PopupClose();
		reg.selectTitle(Prefix);
		Log.info("Select the Title");
		reg.FirstName(FirstName);
		Log.info("Enter the FirstName");
		reg.LastName(LastName);
		Log.info("Enter the LastName");
		reg.Phonenumber(PhoneNumber);
		Log.info("Enter the Phonenumber");
		reg.scroll();
		Log.info("Scroll the Page");
		reg.selectLanguage(PreferredLanguage);
		Log.info("Select the Language");
		reg.Companyname(CompanyName);
		Log.info("Enter the Company CompanyName");
		reg.selectIndustry(Industry);
		Log.info("Select the Industry");
		reg.selectMarket(Market);
		Log.info("Select the Market");
		reg.scroll();
		reg.selecctJobFuction(JobFunction);
		Log.info("Select the Jon Function");
		reg.Jobtitle(JobTitle);
		Log.info("Enter the Job Title");
		reg.EmailAddress(Email);
		Log.info("Enter the Email address");
		reg.Password(Password);
		Log.info("Enter the Password");
		reg.ConfirmPassword(ConfirmPassword);
		Log.info("Enter the ConfirmPassword");
		Thread.sleep(3000);
		reg.scroll();
		Log.info("Scroll the Page");
		reg.getAddress(BillingAddress);
		Log.info("Enter the Address");
		reg.selectCountry(Country);
		Log.info("Select the Country");
		reg.selectState(State);
		Log.info("Select the State");
		reg.city(City);
		Log.info("Select the City");
		reg.postalCode(ZipCode);
		Log.info("Select the Postal Code");
		reg.scroll();
		Log.info("Scroll the Page");
		reg.Shippingaddress(ShippingAddress);
		Log.info("Enter the Shipping Address");
		reg.ShipCountry(ShippingCountry);
		Log.info("Select the Shipping Country");
		reg.ShipState(ShippingState);
		Log.info("Select the Shipping State");
		reg.ShipCity(ShippingCity);
		Log.info("Enter the Shipping City");
		reg.ShipPostalCode(ShippingZipCode);
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
	@DataProvider
	public String [][] getRegistration(){		
		String [][] dataRecords = getData("Register.xlsx","Registration");
		return dataRecords;
	}
//	@AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//		Log.info("Close the Browser");
//	}
}
