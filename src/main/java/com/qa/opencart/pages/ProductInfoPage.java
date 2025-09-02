package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	
	private By productHeader=By.tagName("h1");
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtils= new ElementUtil(driver);
	}
	
	public String getProductHeader() {
		String productHeaderValue=eleUtils.waitForElementVisible(productHeader, AppConstants.DEFAULT_MEDIAM_TIME_OUT).getText();
		return productHeaderValue;
	
	}

}
