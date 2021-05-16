package com.csagroup.addToCart;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;
import com.csagroup.SearchTestcases.SearchProductTerms;
import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.LoginPage;
import com.csagroup.pageObjects.ProductSearch;

public class ProductAddToCart extends DriverManager{
	public static Logger logger = LogManager.getLogger(ProductAddToCart.class.getName());
	CSA_Actions base;
    ProductSearch search;
    LoginPage lp;
	@BeforeTest
	public void BrowserInvoke() throws IOException, InterruptedException
	{
		DriverManager.getDriver().get(prop.getProperty("url"));
		logger.info("Launching Browser and enter the URL");
		//base.waitForPageToLoad();
	}
	@Test()
	public void ProductAddToCart() throws InterruptedException
	{		
		search = new ProductSearch(driver);
		search.testName="ProductAddToCart";
		search.title="AddToCart";
		search.waitForPageToLoad();
		logger.info("Search Products Page Loading");
		search.SearchTerm(prop.getProperty("SearchTerm"));
		logger.info("Select the Product from Search");
		search.waitForPageToLoad();
		logger.info("Products Page Loading");
		search.SelectProduct(prop.getProperty("ProductName"));
		search.AddtoCart();
		lp = new LoginPage(driver);
		lp.waitForPageToLoad();
		lp.getLoginverify(prop.getProperty("username"), prop.getProperty("password"));
		search.Cart();
		search.CheckoutClicking();
		search.Continue();
		search.ShippingContinue();
		search.ProceedToPayment();
		search.PaymentDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("cardnumber"), prop.getProperty("cardtype"), prop.getProperty("expmonth"), prop.getProperty("expyear"), prop.getProperty("cvv"));
		search.OrderConfirmation("Thank you for placing your order.");
	}
}
