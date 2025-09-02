package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	
	private By reults=By.cssSelector("div.product-thumb");
	private By serachHeader=By.cssSelector("div#content h2");
	
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		eleUtils= new ElementUtil(driver);
	}
	
	public String getSearchHeader() {
		String SearchHeaderValue= eleUtils.waitForElementVisible(serachHeader, AppConstants.DEFAULT_MEDIAM_TIME_OUT).getText();
	return SearchHeaderValue;
	}
	
	public int getGetSearchResultsCount() {
		
		int resultsCount= eleUtils.waitForElementsVisible(reults,AppConstants.DEFAULT_MEDIAM_TIME_OUT).size();
		System.out.println("Search results count=====> "+resultsCount);
		return resultsCount;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		eleUtils.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
	

}
