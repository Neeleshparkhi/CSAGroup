package com.csagroup.SearchTestcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;
import com.csagroup.RegisterTestcases.RegistrationTest;
import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.LoginPage;
import com.csagroup.pageObjects.ProductSearch;
import com.csagroup.pageObjects.Register;
@Listeners(com.csagroup.Listeners.Log.class)
public class SearchProductTerms extends DriverManager {

	public static Logger Log = LogManager.getLogger(SearchProductTerms.class.getName());
	CSA_Actions base;
    ProductSearch search;
	@BeforeTest
	public void BrowserInvoke() throws IOException, InterruptedException
	{
		DriverManager.getDriver().get(prop.getProperty("url"));
		Log.info("Launching Browser and enter the URL");
		//base.waitForPageToLoad();
	}
	@Test(dataProvider="getProducts")
	public void productSearch(String SearchTerms)
	{		
		search = new ProductSearch(driver);
		search.testName="SearchProduct";
		search.title="Products";
		//search.waitForPageToLoad();
		Log.info("Search Products Page Loading");
		search.SearchTerm(SearchTerms);
		Log.info("Select the Product from Search");
		search.waitForPageToLoad();
		Log.info("Products Page Loading");
		search.ProductList();
		Log.info("Products list is displayed");
	}
	@DataProvider
	public String [][] getProducts(){		
		String [][] dataRecords = getData("Products.xlsx","Products");
		return dataRecords;
	}
    @AfterTest
    public void tearDown()
    {
    	driver.quit();
    	Log.info("Driver close");
    }
}
