package com.csagroup.Actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.csagroup.Utilities.PropertyReader;
import com.csagroup.Utilities.Screenshot;
import com.csagroup.excelReader.ExcelReader;
import com.csagroup.Listeners.Log;

public class BasePage {


	public WebDriver driver;
	public WebDriverWait wait;
	public Select select;
	public Actions actions;
	public Alert alert;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	public static String testName;
	public static String title;
	ExcelReader excel;

	PropertyReader pr = new PropertyReader();
	Screenshot screenhsot;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}
	// Wait for element to appear
	public void waitForElementToAppear(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
		highLightElement(elementBy);
	}
	// Wait for element to be clickable
	public void waitForElementToClick(By elementBy) {
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
		highLightElement(elementBy);
	}
	// Wait for alert to appear
	public void waitForAlertToAppear() {
		alert = wait.until(ExpectedConditions.alertIsPresent());
		if (alert != null) {
			isAlertPresent();
		}
	}
    //
	public boolean isElementPresent(By elementBy) {
		try {
			if (driver.findElements(elementBy).size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
    // 
	public boolean isElementVisible(By elementBy) {
		if (driver.findElement(elementBy).isDisplayed()) {
			System.out.println("Element is Visible");
			return true;

		} else {
			System.out.println("Element is InVisible");
			return false;

		}
	}
	// Highlight Element
	public void highLightElement(By elementBy) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: 5px solid red;');", driver.findElement(elementBy));
		sleepTime(3);
		Screenshot.captureScreen(driver, title, testName);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy), "");
	}
	//
	public void unHighLightElement(By elementBy) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy), "");
		sleepTime(1);
		
	}
	// Check alert present
	public boolean isAlertPresent() {
		boolean presentFlag = false;
		try {
			alert = driver.switchTo().alert();
			presentFlag = true;
			alert.accept();
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		}
		return presentFlag;
	}
	// click
//	public void click(By elementBy) {
//		waitForElementToClick(elementBy);
//		driver.findElement(elementBy).click();
//	}
	public void click(By elementBy) {
			WebElement element=driver.findElement(elementBy);
			Log.info("Trying to find element : "+element.getText());
			waitForElementToClick(elementBy);
			highLightElement(elementBy);
			String temp = Screenshot.captureScreen(driver, title, testName);
			Log.info(temp, "Clicking on : "+element.getText()+" button");
			unHighLightElement(elementBy);
			element.click();		
	}
	// clear
	public void clear(By elementBy) {
		waitForElementToClick(elementBy);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", driver.findElement(elementBy));
	}
	// Double click
	public void doubleClick(By elementBy) {
		 waitForElementToClick(elementBy);
		actions = new Actions(driver);
		actions.doubleClick(driver.findElement(elementBy)).perform();
	}
	// Write text
//	public void writeText(By elementBy, String text) {
//		waitForElementToAppear(elementBy);
//		driver.findElement(elementBy).clear();
//		driver.findElement(elementBy).sendKeys(text);
//	}
	public void writeText(By elementBy, String text) {
			WebElement element= driver.findElement(elementBy);
			waitForElementToAppear(elementBy);
			Log.info("Entering "+text+ " value to : "+element.getAttribute("name"));
			highLightElement(elementBy);
			element.clear();
			element.sendKeys(text);
			String temp = Screenshot.captureScreen(driver, title, testName);
			Log.info(temp, "Entered "+text+ " value to : "+element.getAttribute("name"));
			unHighLightElement(elementBy);			
	}
	// Read text
//	public String readText(By elementBy) {
//		waitForElementToAppear(elementBy);
//		return driver.findElement(elementBy).getText();
//	}
	public String readText(By elementBy) {
		WebElement element= driver.findElement(elementBy);
		waitForElementToAppear(elementBy);
		highLightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp, "Reading the text value from: "+element.getText());
		unHighLightElement(elementBy);
		return element.getText();
	}
	// Get element
//	public WebElement getElement(By elementBy) {
//		waitForElementToAppear(elementBy);
//		return driver.findElement(elementBy);
//	}
	public WebElement getElement(By elementBy) {
		WebElement element= driver.findElement(elementBy);
		waitForElementToAppear(elementBy);
		highLightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp, "Getting the WebElement from : "+element.getText());
		unHighLightElement(elementBy);
		return driver.findElement(elementBy);
	}
	// Get title
	public String getPageTitle() {
		return driver.getTitle();
	}
    //
	public String switchToWindow_GetTitle() {
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		String title = null;
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				title = driver.switchTo().window(child_window).getTitle();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		return title;
	}
	// Get elements
	public List<WebElement> getElements(By elementBy) {
		// waitForElementToAppear(elementBy);
		return driver.findElements(elementBy);
	}
    //
	public void keysEnter(By elementBy) {
		waitForElementToClick(elementBy);
		driver.findElement(elementBy).sendKeys(Keys.ENTER);
	}
    //
	public WebElement getSearch(By elementBy, String text) {
		waitForElementToAppear(elementBy);
		driver.findElement(elementBy).sendKeys(text);
		Log.info("Enter the Data in Search textbox:" + elementBy);
		driver.findElement(elementBy).sendKeys(Keys.DOWN);
		Log.info("Selecting Item to down:" + elementBy);
		driver.findElement(elementBy).sendKeys(Keys.ENTER);
		Log.info("Select Item is Enter:" + elementBy);
		return driver.findElement(elementBy);
	}
	// Multiple selection by text
	public void multiSelectByText(By elementBy, String xPathValue) {
			//waitForElementToAppear(elementBy, "Selecting "+xPathValue+" from :"+elementBy.toString());
			int size = driver.findElements(By.xpath(xPathValue)).size();
			System.out.println(size + " mapsets found");
			boolean element = isElementPresent(By.xpath(xPathValue));
			if (element == true) {
				driver.findElement(By.xpath("(" + xPathValue + ")[" + size + "]")).click();
			} else {

			}
			System.out.println("changes are made to the most recent  mapset");
	}
	// Select by visible text
	public void selectByVisibleText(By elementBy, String value) {
			WebElement element= driver.findElement(elementBy);
			Log.info("Trying to find : "+element.getAttribute("name"));
			waitForElementToAppear(elementBy);
			highLightElement(elementBy);
			select = new Select(element);
			select.selectByVisibleText(value);
			String temp = Screenshot.captureScreen(driver, title, testName);
			Log.info(temp, "Selected : "+value+" from : "+element.getAttribute("name"));
			unHighLightElement(elementBy);
	}
	// Select by value
	public void selectByValue(By elementBy, String value) {			
			WebElement element= driver.findElement(elementBy);
			Log.info("Trying to find : "+element.getAttribute("name"));
			waitForElementToAppear(elementBy);
			highLightElement(elementBy);
			select = new Select(element);
			select.selectByValue(value);
			String temp = Screenshot.captureScreen(driver, title, testName);
			Log.info(temp, "Selected : "+value+" from : "+element.getAttribute("name"));
			unHighLightElement(elementBy);
	}
	// Get select value
	public String getSelectedValue(By elementBy) {
			//waitForElementToAppear(elementBy, "Getting Selected value from : "+elementBy.toString());
			Select select = new Select(driver.findElement(elementBy));
			return select.getFirstSelectedOption().getText();
	}
	// Element to be click from the list
	public void elementTobeClickFromList(By elementBy, String value, String logMsg) {
			//highLightElement(elementBy, logMsg);
			List<WebElement> checkBoxes = getElements(elementBy);
			for (WebElement boxes : checkBoxes) {
				String textValues = boxes.getText();
				if (textValues.contains(value)) {

					boxes.click();
					break;
				} else
					throw new RuntimeException(value + " is not available in the list");
			}
	}
	// JavaScript click
	public void javaScriptClick(By elementBy, String logMsg) {
			WebElement element=driver.findElement(elementBy);
			Log.info("Trying to find element : "+element.getText());
			waitForElementToClick(elementBy);
			highLightElement(elementBy);
			String temp = Screenshot.captureScreen(driver, title, testName);
			Log.info(temp, "Clicking on :"+element.getText());
			unHighLightElement(elementBy);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);			
	}
	// Scroll into view
	public void scrollIntoView(By elementBy) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementBy));
	}
	// Scroll page
	public void scroll() {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,400)", "");
	}
	// Scroll page
	public void scrollUp() {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("scroll(0, -250);");
			jse.executeScript("window.scrollBy(0, -250)", "");
	}
	// Thread wait
	public void sleepTime(int seconds) {
			try {
				Thread.sleep(1000 * seconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	// Wait for page ro load
	public void waitForPageToLoad() {
			sleepTime(1);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = (String) js.executeScript("return document.readyState");
			while (!state.equals("complete")) {
				sleepTime(20);
				state = (String) js.executeScript("return document.readyState");
			}
	}
	// Convert date
	public String convertDate(String inputdate) {
			System.out.println("input date" + inputdate);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = null;
			try {
				System.out.println("input date in concert date****" + inputdate);
				date = new SimpleDateFormat("MM/dd/yyyy").parse(inputdate);
				System.out.println("Date in concert date****" + date);
			} catch (Exception e) {
				e.getMessage();
			}
			return df.format(date);
	}
    //
	public void maximizeBrowser() {
			driver.manage().window().maximize();
	}
	// Get Screenshot
	public void takeScreenShot() {
			Date d = new Date();
			String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
			// String filePath = CRConstants.REPORTS_PATH + "screenshots//"
			// +//screenshotFile;
			String filePath = "";
			// store screenshot in that file
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileHandler.copy(scrFile, new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
    //
	public WebDriver getDriver() {
			return driver;
	}
    //
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
	// Excel Data 
	// Excel Reader Method
		public String[][] getData(String ExcelName, String sheetName) {
			// /uiAutoframework/src/main/java/com/test/Autoframework/uiAutoframework/data/TestData.xlsx
			String path = System.getProperty("user.dir") + "/src/main/java/com/csagroup/resources/" + ExcelName;
			excel = new ExcelReader(path);
			String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
			return data;
		}
}
