package com.csagroup.test.CSAGroup;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.csagroup.Utilities.SubscritptionTime;
import com.csagroup.config.DriverManager;
import com.csagroup.pageObjects.LandingPage;
import com.csagroup.pageObjects.LoginPage;
@Listeners(com.csagroup.Listeners.Log.class)
public class CSAOnDemandTest extends DriverManager {

	LoginPage lp;
	LandingPage land;

	@BeforeTest
	public void BrowserInvoke() throws IOException {
		DriverManager.getDriver().get(prop.getProperty("url"));
	}

	@Test
	public void OnDemandVerification() throws InterruptedException, IOException, URISyntaxException {

		lp = new LoginPage(driver);
		lp.testName = "OnDemand";
		lp.title = "OnDemandVerification";
		lp.waitForPageToLoad();
		lp.getLoginverify(prop.getProperty("username"), prop.getProperty("password"));
		lp.waitForPageToLoad();
		land = new LandingPage(driver);
		land.OnDemandClick();
		Thread.sleep(5000);
		land.verifyPageTitle("Welcome, automation2");
		land.verifyInviteUsersTitle("Invite users to Register edit");
		// land.verifyTitleSubscription(SubscritptionTime.getSubscriptionDays() + "
		// Days");
		land.verifyEmailAddress("csaqatest+dec151@gmail.com");
		land.verifyHeaderTitles("ACCOUNT MANAGEMENT", "SUPPORT", "ORDER MANAGEMENT");
		land.verifyCSAgroupLogo();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
