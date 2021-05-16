package com.csagroup.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.*;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;




public class ProductSearch extends CSA_Actions {
	public static Logger Log = LogManager.getLogger(ProductSearch.class.getName());
	public WebDriver driver;
	public static String ProductName;
	
	public ProductSearch(WebDriver driver)
	{
		super(driver);
	}
	
	By SearchItem = By.xpath("(//input[@placeholder='Search Products'])[2]");
	By ProductList = By.xpath("//div[@class='products_1_row_medium_item cc_product_item cc_row_item']");
	
	By Products = By.xpath("//a[text()='"+ProductName+"']");
	// 2018 Canadian Electrical Practice Exam ( CEPE )
	By ProductTilte=By.xpath("//*[@class='pdp productName product_title cc_product_title']");
	By ProductLanguage=By.xpath("//input[@name='Language'] [@value='English']");
	
	By QuantityIncrease = By.xpath("//button[@class='plus_minus-btn plus-btn plusCSA btn-csa']");
	By QuantityDecrease = By.xpath("//button[@class='plus_minus-btn minus-btn minusCSA btn-csa']");
	
	By AddToCart = By.xpath("//button[@class='addCart-btn btn btn-default addItem btn-csa']");
	By Cart= By.xpath("//button[@id='my-cart']");
	//Cart Page Quantity buttons 
	By QuantityPlus = By.xpath("//button[@class='plus_minus-btn plus-btn plus']");
	By QuantityMinus = By.xpath("//button[@class='plus_minus-btn minus-btn minus']");
	
	By CartUpdate = By.xpath("//button[@class='btn btn-default btn-csa updateCartButton']");
	By Checkout= By.xpath("//button[@class='checkout-btn btn btn-default btn-csa checkOutBtn']");
	
	By Continue = By.xpath("//input[@type='button'] [@value='Continue']");
	By ShippingContinue = By.xpath("//input[@type='button'] [@value='Continue']");
	By ProceedPayment = By.xpath("(//input[@class='btn btn-default btn-sm processReview proceed cc_process_review'])[2]");
	
	// Payment Details
	By PaymentdetailsTitle= By.xpath("//div[@class='panel-heading cc_heading']");
	By Payment_Firstname = By.xpath("//input[@name='first_name']");
	By Paymen_Lastname = By.xpath("//input[@name='last_name']");
	By CardNumber = By.xpath("//input[@name='card_number']");
	By CardType = By.xpath("//select[@name='card_type']");
	
	By ExpirationMonth = By.xpath("//select[@name='card_expirationMM']");
	By ExpirationYear = By.xpath("//select[@name='card_expirationYYYY']");
	By CVV = By.xpath("//input[@name='card_cvn']");
	By ProcessPayment = By.xpath("//input[@name='sopccMakePayment']");
	// Order confirmation 
	//By OrderConfirm = By.xpath("//div[@class='cc_order_confirmation_date']");
	By OrderConfirm = By.xpath("//div[@class='panel-body cc_body']/h4");
	
	public void verifyProductTitle(String producttext)
	{
		readText(ProductTilte);
		Assert.assertEquals(producttext, ProductTilte);
	}
	public void verifyLanguage(String langtext)
	{
		readText(ProductLanguage);
		Assert.assertEquals(langtext, ProductLanguage);
	}
	public void Cart()
	{
		click(Cart);
	}
	public void AddtoCart()
	{
		click(AddToCart);
		waitForPageToLoad();
		click(Cart);
		click(QuantityPlus);
		click(Checkout);
	}
	public void CheckoutClicking()
	{
		click(Checkout);
	}
	
	public void Continue()
	{
		scrollIntoView(Continue);
		click(Continue);
	}
	public void ShippingContinue()
	{
		click(ShippingContinue);
	}
	public void ProceedToPayment()
	{
		click(ProceedPayment);
	}
	
	public void PaymentDetails(String firstname, String lastname, String cnumber, String cardtype, String expmonth, String expyear, String cvv)
	{
		writeText(Payment_Firstname,firstname);
		writeText(Paymen_Lastname, lastname);
		writeText(CardNumber, cnumber);
		selectByVisibleText(CardType, cardtype);
		selectByVisibleText(ExpirationMonth, expmonth);
		selectByVisibleText(ExpirationYear, expyear);
		writeText(CVV, cvv);
		click(ProcessPayment);		
	}
	public void OrderConfirmation(String orderText)
	{
		waitForPageToLoad();
		readText(OrderConfirm);
		Assert.assertEquals(orderText, OrderConfirm);
	}
	
	public void IncreaseQuantity()
	{
		click(QuantityPlus);
	}
	
	public void SearchTerm(String searchTerms)
	{
		click(SearchItem);
		//logger.info("Click on the Search Textbox");
		getSearch(SearchItem, searchTerms);
		//logger.info("Enter and select Product from Search");
	}
	public void ProductList()
	{
		List<WebElement>products=getElements(ProductList);
		int count = products.size();
		for(int i=0;i<count; i++)
		{
			scroll();
			System.out.println(products.get(i).getText());
		}
	}
	
	public void ProductClick(String ProductName)
	{
		click(Products);
		waitForPageToLoad();
	}
	
	public void SelectProduct(String textname)
	{
		List<WebElement>products=getElements(ProductList);
		int count = products.size();
		for(int i=0;i<count; i++)
		{
			String productname = products.get(i).getText();
			if(productname.contains(textname))
			{
				products.get(i).click();
				break;
			}
		}
	}

}
