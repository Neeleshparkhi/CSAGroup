package com.csagroup.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.csagroup.Actions.BasePage;
import com.csagroup.Actions.CSA_Actions;

public class CSAOnDemand extends CSA_Actions {

	public CSAOnDemand(WebDriver driver) {
		super(driver);
	}

	By CSAOnDemand = By.xpath("(//a[text()='CSA OnDemand™'])[2]");
	By MyLibrary = By.xpath("(//a[@class='link-alt'])[2]");
	By DocumentList = By.xpath("//div[@class='document-product-parent']");
	By Documents = By.xpath("//div[@class='document-product-parent']/div[1]/div/a");

	By SearchItem = By.xpath("//input[@placeholder='Search Products']");

	public void SearchTerm(String searchTerms) {
		click(SearchItem);
		clear(SearchItem);
		//Log.info("Click on the Search Textbox");
		getSearch(SearchItem, searchTerms);
		//logger.info("Enter and select Product from Search");
	}

	public void ProductList() {
		List<WebElement> products = getElements(DocumentList);
		int count = products.size();
		for (int i = 0; i < count; i++) {
			scrollIntoView(DocumentList);
			System.out.println(products.get(i).getText());
		}
	}

	public void ClickCSAOnDemand() {
		click(CSAOnDemand);
	}

	public void ClickMyLibrary() {
		click(MyLibrary);
	}

	public void ListofDocuments() {
		List<WebElement> Documents = getElements(DocumentList);
		int count = Documents.size();
		for (int i = 0; i < count; i++) {
			System.out.println(Documents.get(i).getText());
		}
	}

	public void SelectDocument(String Docname) {
		List<WebElement> Documents = getElements(DocumentList);
		int count = Documents.size();
		for (int i = 0; i < count; i++) {
			String productname = Documents.get(i).getText();
			if (productname.contains(Docname)) {
				Documents.get(i).click();
				break;
			}
		}
	}

}