package com.csagroup.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.csagroup.excelReader.ExcelReader;

public class WebDriverManager {
	
	protected static WebDriver driver;
	public static Properties prop;
	ExcelReader excel;
	public static WebDriver getDriver(String browser) throws IOException
	{	
	prop= new Properties();
	FileInputStream fis=new FileInputStream("src/main/java/com/csagroup/resources/config.properties");

	prop.load(fis);
	//String browserName=prop.getProperty("browser");
	System.out.println(browser);

	if(browser.equals("chrome"))
	{
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/WebDrivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 //execute in chrome driver	
	}
	else if (browser.equals("Edge"))
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/WebDrivers/MicrosoftWebDriver.exe");
		 driver= new EdgeDriver();
		//firefox code
	}
	else if (browser.equals("ie"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/WebDrivers/IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	}
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
	}
	
	public String[][] getData(String ExcelName, String sheetName)
	{ 
		// /uiAutoframework/src/main/java/com/test/Autoframework/uiAutoframework/data/TestData.xlsx
		String path = System.getProperty("user.dir")+ "/src/main/java/com/csagroup/resources/"+ ExcelName;
		excel = new ExcelReader(path);
	    String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
	    return data;
	}

}
