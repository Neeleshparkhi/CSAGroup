package com.csagroup.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.csagroup.excelReader.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	protected static WebDriver driver;
	public static Properties prop;
	ExcelReader excel;

	public static WebDriver getDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/com/csagroup/resources/config.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/WebDrivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			// firefox code
		} else if (browserName.equals("ie")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/WebDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	// For testing
	public static void main(String[] args) throws IOException {
		DriverManager.getDriver().get("https://b2buat-csastandards.cs93.force.com/store");
	}

	// public void ScrollPage() {
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("window.scrollBy(0,500)");
	// }
	protected void waitForVisibility(WebElement element) throws Error {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
	}

	// Excel Reader Method
	public String[][] getData(String ExcelName, String sheetName) {
		// /uiAutoframework/src/main/java/com/test/Autoframework/uiAutoframework/data/TestData.xlsx
		String path = System.getProperty("user.dir") + "/src/main/java/com/csagroup/resources/" + ExcelName;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
		return data;
	}
}
