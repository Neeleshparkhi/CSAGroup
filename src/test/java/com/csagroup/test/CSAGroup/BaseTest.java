package com.csagroup.test.CSAGroup;

import java.io.IOException;

import org.testng.annotations.Test;

import com.csagroup.Utilities.PropertyReader;
import com.csagroup.config.DriverManager;

public class BaseTest {
	public PropertyReader prop = new PropertyReader();
	@Test
	public void DriverTest() throws IOException
	{
		DriverManager.getDriver().get(prop.getProperty("url"));;
	}

}
