package com.csagroup.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;

public class HomePage extends CSA_Actions {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	By ProductName = By.xpath("//div[@class='jumbotron']//h2");

	// Buckets home- h3 Text
	By Bukets_Home_Link1_H3 = By.xpath("(//section[@class='buckets-home']//h3)[1]");
	By Bukets_Home_Link2_H3 = By.xpath("(//section[@class='buckets-home']//h3)[2]");
	By Bukets_Home_Link3_H3 = By.xpath("(//section[@class='buckets-home']//h3)[3]");

	// CSA Group - Online Store In Demand Purchases
	// Codes & Standards
	By OnlineStore_DemandPurchases_Link1_span = By.xpath("(//span[@class='featured-product_category'])[1]");
	By OnlineStore_DemandPurchases_Link2_span = By.xpath("(//span[@class='featured-product_category'])[2]");
	By OnlineStore_DemandPurchases_Link3_span = By.xpath("(//span[@class='featured-product_category'])[3]");
	By OnlineStore_DemandPurchases_Link4_span = By.xpath("(//span[@class='featured-product_category'])[4]");

	// CSA Group - Online Store In Demand Purchases
	// Training & Supplementary Products

	By TrainingLink = By.linkText("Training");
	By OnlineStore_DemandPurchases_Link1_h4 = By.xpath("(//div[@id='standards']//h4)[1]");
	By OnlineStore_DemandPurchases_Link2_h4 = By.xpath("(//div[@id='standards']//h4)[2]");
	By OnlineStore_DemandPurchases_Link3_h4 = By.xpath("(//div[@id='standards']//h4)[3]");
	By OnlineStore_DemandPurchases_Link4_h4 = By.xpath("(//div[@id='standards']//h4)[4]");
	By Supplementary_ProductsLink = By.linkText("Supplementary Products");

	// Solutions to meet your every need

	By Container_Buy_h3 = By.xpath("(//div[@class='container c-container']//h3)[1]");
	By Container_Subscribe_h3 = By.xpath("(//div[@class='container c-container']//h3)[2]");
	By Container_Services_h3 = By.xpath("(//div[@class='container c-container']//h3)[3]");

	// Standards – New Releases

	By Standards_New_Releases_Link1_h3 = By.xpath("(//div[@class='slick-list draggable']//h3)[1]");
	By Standards_New_Releases_Link2_h3 = By.xpath("(//div[@class='slick-list draggable']//h3)[2]");
	By Standards_New_Releases_Link3_h3 = By.xpath("(//div[@class='slick-list draggable']//h3)[3]");
	By Standards_New_Releases_Link4_h3 = By.xpath("(//div[@class='slick-list draggable']//h3)[4]");

	// Top Selling Training Courses

	By Selling_Training_Courses_Name = By.xpath("//div[@class='container c-container CsaContainer']//h2");
	By Selling_Training_Courses_Links = By
			.xpath("//div[@class='courseBlock TopSellingBlock  displaynone']//div[ @class='title en_traning']");

	// Social Media Icon
	By Social_Icon_Facebook = By.xpath("//a[@alt='Facebook']");
	By Social_Icon_LinkedIn = By.xpath("//a[@alt='LinkedIn']");
	By Social_Icon_Twitter = By.xpath("//a[@alt='Twitter']");
	By Social_Icon_YouTube_Play = By.xpath("//a[@alt='YouTube Play']");

	// Subscribe
	By Subscribe = By.linkText("Subscribe");

	// Menu footer list
	By footerMenu = By.xpath("(//ul[@class='menu'])[1]/li");

	// copyright
	By Copyright = By.xpath("//div[@class='copyright col-lg-4 col-xs-12']//div");

	By productSearch = By.xpath("(//input[@placeholder='Search Products'])[2]");   // (//input[@class='form-control awesomplete searchTextCSA'])[1]
	By productSearch_Button = By.xpath("(//button[@class='btn-go doSearchCSA'])[1]");

	// products list after searching PLP
	By view20 = By.id("pagesize20");
	By productsList = By.xpath("//div[@class='productListContent cc_results_list']//a");

	public void verifyProductBannerName(String expected) {
		readText(ProductName);
		Assert.assertEquals(readText(ProductName), expected);
	}

	public void verifyBukets_Home_Link1_H3_Text(String expected) {
		scrollIntoView(Bukets_Home_Link1_H3);
		readText(Bukets_Home_Link1_H3);
		Assert.assertEquals(readText(Bukets_Home_Link1_H3), expected);
	}

	public void verifyBukets_Home_Link2_H3_Text(String expected) {
		readText(Bukets_Home_Link2_H3);
		Assert.assertEquals(readText(Bukets_Home_Link2_H3), expected);
	}

	public void verifyBukets_Home_Link3_H3_Text(String expected) {
		readText(Bukets_Home_Link3_H3);
		Assert.assertEquals(readText(Bukets_Home_Link3_H3), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link1_span(String expected) {
		readText(OnlineStore_DemandPurchases_Link1_span);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link1_span), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link2_span(String expected) {
		readText(OnlineStore_DemandPurchases_Link2_span);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link2_span), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link3_span(String expected) {
		readText(OnlineStore_DemandPurchases_Link3_span);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link3_span), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link4_span(String expected) {
		readText(OnlineStore_DemandPurchases_Link4_span);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link4_span), expected);
	}

	public void trainingLinkClick() {
		click(TrainingLink);
	}

	public void verifyOnlineStore_DemandPurchases_Link1_h4_Text(String expected) {
		readText(OnlineStore_DemandPurchases_Link1_h4);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link1_h4), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link2_h4_Text(String expected) {
		readText(OnlineStore_DemandPurchases_Link2_h4);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link2_h4), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link3_h4_Text(String expected) {
		readText(OnlineStore_DemandPurchases_Link3_h4);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link3_h4), expected);
	}

	public void verifyOnlineStore_DemandPurchases_Link4_h4_Text(String expected) {
		readText(OnlineStore_DemandPurchases_Link4_h4);
		Assert.assertEquals(readText(OnlineStore_DemandPurchases_Link4_h4), expected);
	}

	public void Supplementary_ProductsClick() {
		click(Supplementary_ProductsLink);
	}

	public void verifyContainer_Buy_h3_Text(String expected) {
		scrollIntoView(Container_Buy_h3);
		readText(Container_Buy_h3);
		Assert.assertEquals(readText(Container_Buy_h3), expected);
	}

	public void verifyContainer_Subscribe_h3_Text(String expected) {
		readText(Container_Subscribe_h3);
		Assert.assertEquals(readText(Container_Subscribe_h3), expected);
	}

	public void verifyContainer_Services_h3_Text(String expected) {
		readText(Container_Services_h3);
		Assert.assertEquals(readText(Container_Services_h3), expected);
	}

	public void verifyStandards_New_Releases_Link1_h3_Text(String expected) {
		scrollIntoView(Standards_New_Releases_Link1_h3);
		readText(Standards_New_Releases_Link1_h3);
		Assert.assertEquals(readText(Standards_New_Releases_Link1_h3), expected);
	}

	public void verifyStandards_New_Releases_Link2_h3_Text(String expected) {
		readText(Standards_New_Releases_Link2_h3);
		Assert.assertEquals(readText(Standards_New_Releases_Link2_h3), expected);
	}

	public void verifyStandards_New_Releases_Link3_h3_Text(String expected) {
		readText(Standards_New_Releases_Link3_h3);
		Assert.assertEquals(readText(Standards_New_Releases_Link3_h3), expected);
	}

	public void verifyStandards_New_Releases_Link4_h3_Text(String expected) {
		readText(Standards_New_Releases_Link4_h3);
		Assert.assertEquals(readText(Standards_New_Releases_Link4_h3), expected);
	}

	public void verifySelling_Products_Text(String prodcutName) {
		scrollIntoView(Selling_Training_Courses_Name);
		List<WebElement> products = getElements(Selling_Training_Courses_Links);
		Boolean b = null;
		for (WebElement product : products) {
			String productText = product.getText();
			if (productText.equals(prodcutName)) {
				b = true;
				break;
			} else {
				b = false;
			}
		}
		Assert.assertTrue(b);

	}

	public void verifySocial_Icon_Facebook_PageTitle(String expected) {
		scroll();
		click(Social_Icon_Facebook);
		String actualTitle = switchToWindow_GetTitle();
		Assert.assertEquals(actualTitle, expected);
	}

	public void verifySocial_Icon_Twitter_PageTitle(String expected) {

		click(Social_Icon_Twitter);
		String actualTitle = switchToWindow_GetTitle();
		Assert.assertEquals(actualTitle, expected);
	}

	public void verifySocial_Icon_LinkedIn_PageTitle(String expected) {

		click(Social_Icon_LinkedIn);
		String actualTitle = switchToWindow_GetTitle();
		Assert.assertEquals(actualTitle, expected);
	}

	public void verifySocial_Icon_Youtube_Play_PageTitle(String expected) {
		click(Social_Icon_YouTube_Play);
		String actualTitle = switchToWindow_GetTitle();
		Assert.assertEquals(actualTitle, expected);
	}

	public void verifySubscribe_PageTitle(String expected) {
		scroll();
		click(Subscribe);
		String actualTitle = switchToWindow_GetTitle();
		Assert.assertEquals(actualTitle, expected);
	}

	public void printAll_Menu_Li_Objects() {
		scroll();
		sleepTime(4);
		List<WebElement> products = getElements(footerMenu);
		System.out.println("********** ALL FOOTER MENU OBJECTS ***************");
		for (WebElement product : products) {
			String productText = product.getText();
			System.out.println(productText);
		}

		System.out.println("**************************************************");

	}

	public void verifyCopyright_Text(String expected) {

		readText(Copyright);
		Assert.assertEquals(readText(Copyright).replaceAll("\n+", ""), expected);
	}

	public void printAll_h1_tags() {
		sleepTime(3);
		List<WebElement> h1Tags = getElements(By.tagName("h1"));
		System.out.println("********** ALL h1 tag Objects ***************");
		for (WebElement h1Tag : h1Tags) {
			String productText = h1Tag.getText();
			System.out.println(productText);
		}

		System.out.println("**************************************************");
	}

	public void printAll_h2_tags() {
		List<WebElement> h2Tags = getElements(By.tagName("h2"));
		System.out.println("********** ALL h2 tag Objects ***************");
		for (WebElement h2Tag : h2Tags) {
			String productText = h2Tag.getText();
			System.out.println(productText);
		}

		System.out.println("**************************************************");
	}

	public void printAll_h3_tags() {
		List<WebElement> h3Tags = getElements(By.tagName("h3"));
		System.out.println("********** ALL h3 tag Objects ***************");
		for (WebElement h3Tag : h3Tags) {
			String productText = h3Tag.getText();
			System.out.println(productText);
		}

		System.out.println("**************************************************");
	}

	public void printAll_h4_tags() {
		List<WebElement> h4Tags = getElements(By.tagName("h4"));
		System.out.println("********** ALL h4 tag Objects ***************");
		for (WebElement h4Tag : h4Tags) {
			String productText = h4Tag.getText();
			if (productText == "" || productText == null || productText.isEmpty()) {
			} else {
				System.out.println(productText);
			}
		}

		System.out.println("**************************************************");
	}

	public void print_All_Electrical_Codes(String electricalCode) {
		sleepTime(4);
		waitForPageLoaded();
		click(By.xpath("//img[@class='jumbotron']"));
		// javaScriptClick(productSearch);
		// doubleClick(productSearch);
		waitForElementToAppear(productSearch);
		isElementVisible(productSearch);
		// waitForElementToClick(productSearch);
		getDriver().findElement(productSearch).sendKeys(electricalCode);
		// writeText(productSearch, electricalCode);
		javaScriptClick(productSearch_Button,"");
		sleepTime(4);
		scrollIntoView(view20);
		click(view20);
		List<WebElement> products = getElements(productsList);
		System.out.println("********** ALL " + electricalCode + "  electrical codes ***************");
		for (WebElement product : products) {
			String productText = product.getText();
			if (productText == "" || productText == null || productText.isEmpty()) {
			} else {
				System.out.println(productText);
			}
		}

		System.out.println("**************************************************");
		printAll_h1_tags();
		printAll_h2_tags();
		printAll_h3_tags();
		printAll_h4_tags();

	}

}
