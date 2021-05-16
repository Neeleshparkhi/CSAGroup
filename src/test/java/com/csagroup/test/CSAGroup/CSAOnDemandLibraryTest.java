package com.csagroup.test.CSAGroup;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.CSAOnDemand;
import com.csagroup.pageObjects.LoginPage;
import com.csagroup.pageObjects.ProductSearch;
@Listeners(com.csagroup.Listeners.Log.class)
public class CSAOnDemandLibraryTest extends DriverManager {
	
	LoginPage lp;
    CSAOnDemand csad;
	ProductSearch search;
	@BeforeTest
	public void BrowserInvoke() throws IOException, InterruptedException
	{
		DriverManager.getDriver().get(prop.getProperty("url"));	
		lp = new LoginPage(driver);
		lp.testName="OnDemandLibrary";
		lp.title="OnDemandLibrary";
		lp.waitForPageToLoad();
		lp.getLoginverify(prop.getProperty("username"), prop.getProperty("password"));
		lp.waitForPageToLoad();
		csad= new CSAOnDemand(driver);
		csad.ClickCSAOnDemand();	
	}
	@Test(dataProvider="getDocuments")
	public void OnDemandLibrary(String SearchTerms) throws InterruptedException
	{					
		csad= new CSAOnDemand(driver);
		csad.SearchTerm(SearchTerms);
		csad.ProductList();		
	}
	@DataProvider
	public String [][] getDocuments(){		
		String [][] dataRecords = getData("Documents.xlsx","Sheet1");
		return dataRecords;
	}
	@AfterTest
    public void tearDown()
    {
    	driver.quit();
    }
}
