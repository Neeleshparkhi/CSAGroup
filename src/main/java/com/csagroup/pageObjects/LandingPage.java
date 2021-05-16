package com.csagroup.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;
import com.csagroup.Utilities.ImageHandler;

public class LandingPage extends CSA_Actions {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	By Logo_Image = By.xpath("(//img[contains(@src,'/csa-group-logo.png')])[1]");
	By fblogo = By.xpath("//*[@id=\"csa\"]/footer/div/div/div[2]/div/div[1]/div[1]/div[1]/a/img");
	By Search = By.xpath("(//input[@placeholder='Search Products'])[2]");

	By CSAOnDemand = By.xpath("(//a[text()='CSA OnDemand™'])[2]");
	By verifyTitle = By.xpath("//div[@class='h4']"); // Welcome, Vitrium813
	By InviteUsers = By.xpath("(//a[@class='link-alt'])[1]"); // 'Invite users to Register '
	By SubscriptionTime = By.xpath("//div[@class='h4 days-left']"); // 352 Days
	By Emailaddress = By.xpath("(//div[@class='support-content']//a)[1]");
	// csaqatest+dec15Vit@gmail.com
	By AccountManagement = By.xpath("(//a[@class='dropdown-toggle'])[2]");
	By Support = By.xpath("(//a[@class='dropdown-toggle'])[3]");
	By OrderManagement = By.xpath("(//a[text()='Order Management'])[2]"); // Order Management

	public void OnDemandClick() {
		click(CSAOnDemand);
	}

	public void verifyPageTitle(String title) {
		readText(verifyTitle);
		System.out.println(readText(verifyTitle));
		Assert.assertEquals(readText(verifyTitle), title);
	}

	public void verifyInviteUsersTitle(String userTitle) {
		readText(InviteUsers).trim().replaceAll("\n+", " ");
		Assert.assertEquals(readText(InviteUsers).trim().replaceAll("\n+", " "), userTitle);
	}

	public void verifyTitleSubscription(String days) {
		readText(SubscriptionTime);
		Assert.assertEquals(readText(SubscriptionTime), days);
	}

	public void verifyEmailAddress(String email) {
		readText(Emailaddress);
		Assert.assertEquals(readText(Emailaddress), email);
	}

	public void verifyHeaderTitles(String accmngt, String support, String ordermgnt) {
		readText(AccountManagement);
		Assert.assertEquals(readText(AccountManagement), accmngt);
		readText(Support);
		Assert.assertEquals(readText(Support), support);
		readText(OrderManagement);
		Assert.assertEquals(readText(OrderManagement), ordermgnt);
	}

	public void verifyCSAgroupLogo() throws IOException {

		String actualImage = System.getProperty("user.dir")
				+ "/src/main/java/com/csagroup/resources/actual-csa-group-logo.png";

		ImageHandler.downloadImageFromURL(
				"https://b2buat-csastandards.cs93.force.com/store/resource/1555026574000/CC_CSA_Content/images/csa-group-logo.png",
				actualImage);

		String expectedImage = System.getProperty("user.dir")
				+ "/src/main/java/com/csagroup/resources/expected-csa-group-logo.png";

		Boolean boo = ImageHandler.compareImages(actualImage, expectedImage);
		Assert.assertTrue(boo);

	}

}
