package com.csagroup.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;

public class Register extends CSA_Actions {
	
	public WebDriver driver;
	// Customer Details
	By LPClose = By.xpath("//*[@class='LPMcloseButton']");
	By Title = By.xpath("//select[@id='salutation']");
	By Firstname = By.xpath("//input[@id='firstName']");
	By Lastname = By.xpath("//input[@id='lastName']");
	By PrimaryPhone = By.xpath("//input[@id='primaryPhone']");
	By Language = By.xpath("//select[@id='language']");
	// Additional Details
	By CompanyName = By.xpath("//input[@id='companyName']");
	By Industry = By.xpath("//*[@id='companyType']");
	By Market = By.xpath("//*[@id='market']");
	By JobFuction = By.xpath("//*[@id='jobFunction']");
	By JobTitle = By.xpath("//*[@id='jobTitle']");
	// Sign in Details
	By username = By.xpath("//*[@id='username']");
	By password = By.xpath("//*[@id='NewPassword']");
	By ConfirmPassword = By.xpath("//*[@id='ConfirmPassword']");
	// Billing Details
	By Address = By.xpath("//*[@id='billingAddress.address1']");
	By Address2 = By.xpath("//*[@id='billingAddress.address2']");
	By Country = By.xpath("//*[@name='billingAddress.countryCode']");
	By State = By.xpath("//select[@name='billingAddress.stateCode']");
	By City = By.xpath("//input[@name='billingAddress.city']");
	By PostalCode = By.xpath("//input[@name='billingAddress.postalCode']");
	// Shipping Details
	By ShippingAddress = By.xpath("//input[@name='shippingAddress.address1']");
	By ShippingAddress2 = By.xpath("//input[@name='shippingAddress.address2']");
	By ShippingCountry = By.xpath("//select[@name='shippingAddress.countryCode']");
	By ShippingState = By.xpath("//select[@name='shippingAddress.stateCode']");
	By ShippingCity = By.xpath("//input[@name='shippingAddress.city']");
	By ShippingPostalCode = By.xpath("//input[@name='shippingAddress.postalCode']");
   // Term & Conditions
	By TermsandConditions = By.xpath("//input[@name='tocFlag']");
	By PrivacyPolicy = By.xpath("//input[@name='privacyAcceptFlag']");
	By updates = By.xpath("//input[@name='emailOptInFlag']");
	// Submittion
	By SubmitAccount = By.xpath("//input[@id='btn-registration-submit']");
	
	public Register(WebDriver driver) {
		super(driver);
		//this.driver = driver;
	}
	public void PopupClose()
	{
		click(LPClose);
	}
	public void SelectTitle(String title)
	{
		WebElement Titledrp = driver.findElement(Title);
		Titledrp.click();
		Select Title = new Select(Titledrp);
		Title.selectByVisibleText(title);		
	}
	public WebElement FirstName()
	{
		return driver.findElement(Firstname);
	}
	public WebElement LastName()
	{
		return driver.findElement(Lastname);
	}
	public WebElement PrimaryPhone()
	{
		return driver.findElement(PrimaryPhone);
	}
	public void SelectLanguage(String language)
	{
		waitForElementToClick(Language);
		WebElement Lang = driver.findElement(Language);
		Lang.click();
		Select languagedrp = new Select(Lang);
		languagedrp.selectByVisibleText(language);
	}
	public WebElement CompanyName()
	{
		return driver.findElement(CompanyName);
	}
	public void SelectIndustry(String companytype)
	{
		WebElement industry=driver.findElement(Industry);
		industry.click();
		Select industrydrp = new Select(industry);
		industrydrp.selectByVisibleText(companytype);
	}
	public void SelectMarket(String markets)
	{
		WebElement market=driver.findElement(Market);
		market.click();
		Select marketdrp = new Select(market);
		marketdrp.selectByVisibleText(markets);
	}
	public void SelectJobFuction(String job)
	{
		WebElement jobfunction=driver.findElement(JobFuction);
		jobfunction.click();
		Select jobfunctiondrp = new Select(jobfunction);
		jobfunctiondrp.selectByVisibleText(job);
	}
	public WebElement JobTitle()
	{
		return driver.findElement(JobTitle);
	}
	public WebElement getEmail()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getConfirmPassword()
	{
		return driver.findElement(ConfirmPassword);
	}
	public WebElement Address()
	{
		return driver.findElement(Address);
	}
	public WebElement Address2()
	{
		return driver.findElement(Address2);
	}
	public void SelectCountry(String country)
	{
		WebElement Countries = driver.findElement(Country);
		Countries.click();
		Select countrydrp = new Select(Countries);
		countrydrp.selectByVisibleText(country);
	}
	public WebElement State()
	{
		return driver.findElement(State);
	}
	
	public void SelectState(String state)
	{
		WebElement states = driver.findElement(State);
		states.click();
		Select countrydrp = new Select(states);
		countrydrp.selectByVisibleText(state);	
		states.click();
	}
	public WebElement City()
	{
		return driver.findElement(City);
	}
	public WebElement PostalCode()
	{
		return driver.findElement(PostalCode);
	}
	public WebElement ShippingAddress()
	{
		return driver.findElement(ShippingAddress);
	}
	public WebElement ShippingAddress2()
	{
		return driver.findElement(ShippingAddress2);
	}
	public void SelectShippingCountry(String country)
	{
		WebElement Countries = driver.findElement(ShippingCountry);
		Countries.click();
		Select countrydrp = new Select(Countries);
		countrydrp.selectByVisibleText(country);
	}
	public WebElement ShippingState()
	{
		return driver.findElement(ShippingState);
	}
	public void SelectShippingState(String state)
	{
		WebElement shipstates = driver.findElement(ShippingState);
		shipstates.click();
		Select countrydrp = new Select(shipstates);
		countrydrp.selectByVisibleText(state);		
	}
	public WebElement ShippingCity()
	{
		return driver.findElement(ShippingCity);
	}
	public WebElement ShippingPostalCode()
	{
		return driver.findElement(ShippingPostalCode);
	}
	public WebElement TermsandConditions()
	{
		return driver.findElement(TermsandConditions);
	}
	public WebElement PrivacyPolicy()
	{
		return driver.findElement(PrivacyPolicy);
	}
	public WebElement Updates()
	{
		return driver.findElement(updates);
	}
	public WebElement CreateAccount()
	{
		return driver.findElement(SubmitAccount);
	}
	public WebElement Industry()
	{
		return driver.findElement(Industry);
	}
	
	public void selectTitle(String title)
	{
		click(Title);
		selectByVisibleText(Title, title);
	}
	public void FirstName(String fname)
	{
		writeText(Firstname, fname);
	}
	public void LastName(String lname)
	{
		writeText(Lastname, lname);
	}
	public void Phonenumber(String phone)
	{
		writeText(PrimaryPhone,phone);
	}
	public void selectLanguage(String language)
	{
		click(Language);
		selectByVisibleText(Language, language);
	}
	public void Companyname(String company)
	{
		writeText(CompanyName,company);
	}
	public void selectIndustry(String industry)
	{
		click(Industry);
		selectByVisibleText(Industry, industry);
	}
	public void selectMarket(String market)
	{
		click(Market);
		selectByVisibleText(Market, market);
	}
	public void selecctJobFuction(String jobfunction)
	{
		click(JobFuction);
		selectByVisibleText(JobFuction, jobfunction);
	}
	public void Jobtitle(String title)
	{
		writeText(JobTitle,title);
	}
	public void EmailAddress(String email)
	{
		writeText(username,email);
	}
	public void Password(String pswd)
	{
		writeText(password, pswd);
	}
	public void ConfirmPassword(String cpswd)
	{
		writeText(ConfirmPassword, cpswd);
	}
	public void getAddress(String add) {
		writeText(Address,add);
	}
	public void selectCountry(String country)
	{
		click(Country);
		selectByVisibleText(Country, country);
	}
	public void selectState(String state)
	{
		waitForElementToAppear(State);
		click(State);
		selectByVisibleText(State, state);
	}
	public void city(String city)
	{
		writeText(City, city);
	}
	public void postalCode(String pcode)
	{
		writeText(PostalCode, pcode);
	}
	public void Shippingaddress(String ShipAddress)
	{
		writeText(ShippingAddress, ShipAddress);
	}
	public void ShipCountry(String shipcountry)
	{
		click(ShippingCountry);
		selectByVisibleText(ShippingCountry, shipcountry);
	}
	public void ShipState(String shipstate)
	{
		waitForElementToAppear(ShippingState);
		click(ShippingState);
		selectByVisibleText(ShippingState, shipstate);
	}
	public void ShipCity(String shipcity)
	{
		writeText(ShippingCity,shipcity);
	}
	public void ShipPostalCode(String ShipPCode)
	{
		writeText(ShippingPostalCode,ShipPCode);
	}
	public void ClickonTermsAndCondition()
	{
		click(TermsandConditions);
	}
	public void ClickonPprivacyPolicy()
	{
		click(PrivacyPolicy);
	}
	public void CreateAccountBtn()
	{
		click(SubmitAccount);
	}
	
	
	
}
