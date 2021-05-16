package com.csagroup.HomePageTestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.HomePage;
@Listeners(com.csagroup.Listeners.Log.class)
public class HomePageTest extends DriverManager {

	HomePage hp;

	@BeforeTest
	public void BrowserInvoke() throws IOException {
		DriverManager.getDriver().get("https://b2buat-csastandards.cs93.force.com/store");
		hp = new HomePage(driver);
	}

	@Test(priority = 1)
	public void homePageVerify() {

		hp.verifyProductBannerName("CSA Z662:19 - Oil and gas pipeline systems products, available today!");
		hp.verifyBukets_Home_Link1_H3_Text("Canadian Electrical Code Training Options");
		hp.verifyBukets_Home_Link2_H3_Text("Workplace Electrical Safety Workshop based on CSA Z462-18");
		hp.verifyBukets_Home_Link3_H3_Text("Ontario Electrical Safety Code (OESC) - 2018");
	}

     @Test(priority = 2)
	public void homePage_OnlineStore_DemandPurchases_Codes_Standards_Verify() {
		hp.verifyOnlineStore_DemandPurchases_Link1_span("Installation Safety - Canadian Electrical Code Part I");
		hp.verifyOnlineStore_DemandPurchases_Link2_span("OHS Workplace Electrical Safety Standards");
		hp.verifyOnlineStore_DemandPurchases_Link3_span("Infection Prevention and Control");
		hp.verifyOnlineStore_DemandPurchases_Link4_span("Health Care Facilities");
	}

    @Test(priority = 3)
	public void homePage_OnlineStore_DemandPurchases_Training_Verify() {
		hp.trainingLinkClick();
		hp.verifyOnlineStore_DemandPurchases_Link1_h4_Text("Infection Control: Part 1 – Fundamentals");
		hp.verifyOnlineStore_DemandPurchases_Link2_h4_Text(
				"Detailed Overview of Changes – 2018 Canadian Electrical Code");
		hp.verifyOnlineStore_DemandPurchases_Link3_h4_Text("2018 Canadian Electrical Code: Grounding & Bonding");
		hp.verifyOnlineStore_DemandPurchases_Link4_h4_Text("Navigating the 2018 Canadian Electrical Code");
	}

	 @Test(priority = 4)
	public void homePage_OnlineStore_DemandPurchases_Supplementary_Products_Verify() {
		hp.Supplementary_ProductsClick();
		hp.verifyOnlineStore_DemandPurchases_Link1_h4_Text("2015 Canadian Electrical Practice Exam ( CEPE )");
		hp.verifyOnlineStore_DemandPurchases_Link2_h4_Text("Mobile Calculator 2018 Canadian Electrical Code");
		hp.verifyOnlineStore_DemandPurchases_Link3_h4_Text(
				"CMDRT (Personnel Certification) - Application and Exam Fee");
		hp.verifyOnlineStore_DemandPurchases_Link4_h4_Text("PLUS 9001 (5th ed. pub. 2017)");
	}

	 @Test(priority = 5)
	public void homePage_Container_Objects_Verify() {
		hp.verifyContainer_Buy_h3_Text("Buy");
		hp.verifyContainer_Subscribe_h3_Text("Subscribe");
		hp.verifyContainer_Services_h3_Text("Services");
	}

	 @Test(priority = 6)
	public void homePage_Standards_New_Releases_Verify() {
		hp.verifyStandards_New_Releases_Link1_h3_Text(
				"CSA W47.1:19, Certification of companies for fusion welding of steel");
		hp.verifyStandards_New_Releases_Link2_h3_Text("CSA PLUS 45001:19, The CSA Z45001 Application Handbook");
		hp.verifyStandards_New_Releases_Link3_h3_Text(
				"CSA EXP200:19, Evaluation of software development and cybersecurity programs");
		hp.verifyStandards_New_Releases_Link4_h3_Text("CSA PLUS 4013:19, Technical guide");
	}

	 @Test(priority = 7)
	public void homePage_Selling_Products_Verify() {

		hp.verifySelling_Products_Text(
				"Commercial, Industrial & Institutional Construction – 2018 Canadian Electrical Code Essentials");
		hp.verifySelling_Products_Text(
				"Fundamentals of Infection Control during Construction, Renovation and Maintenance of Healthcare Facilities");
		hp.verifySelling_Products_Text("CNG Cylinder and Fuel System Inspector Training");
	}

	@Test(priority = 8)
	public void homePage_Social_Icon_Verify() {
		hp.verifySocial_Icon_Facebook_PageTitle("CSA Group - Home | Facebook");
		hp.verifySocial_Icon_LinkedIn_PageTitle("CSA Group | LinkedIn");
		hp.verifySocial_Icon_Twitter_PageTitle("CSA Group (@CSA_Group) | Twitter");
		hp.verifySocial_Icon_Youtube_Play_PageTitle("CSA Group - YouTube");
	}

	@Test(priority = 9)
	public void homePage_Subscribe_TitleVerify() {
		hp.verifySubscribe_PageTitle("CSA Store - Standards | Training | Subscriptions | .");
	}
	@Test(priority = 10)
	public void printAll_Footer_Menu_Links() {
		hp.printAll_Menu_Li_Objects();
	}
	
	@Test(priority=11)
	public void homePage_Copyright_Verfity() {
		hp.verifyCopyright_Text("©2019 Canadian Standards Association, All Rights Reserved");
	}

	@Test(priority=12)
	public void homePage_print_All_tags() {
		hp.printAll_h1_tags();;
		hp.printAll_h2_tags();
		hp.printAll_h3_tags();
		hp.printAll_h4_tags();
	}

	@Test(priority=13)
	public void homePage_print_All_PLP_ElectricalCodes() {
		hp.print_All_Electrical_Codes("PLP");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
