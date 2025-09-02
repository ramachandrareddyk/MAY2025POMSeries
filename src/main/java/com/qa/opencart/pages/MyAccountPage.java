package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class MyAccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	private By logoutLink=By.linkText("Logout");
	private By MyAccountHeader=By.xpath("//h2[normalize-space()='My Account']");
	private By Search=By.xpath("//input[@placeholder='Search']");
	private By serachBtn=By.xpath("//button[@class='btn btn-default btn-lg']");
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		eleUtils= new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		String title=eleUtils.waitForTitleContainsAndReturn(AppConstants.MY_ACCOUNT_PAGE_TITLE, AppConstants.DEFAULT_MEDIAM_TIME_OUT);
		System.out.println("Accont page title is: "+title);
		return title;
	}
	
	public boolean isLogoutlinkExist() {
		return eleUtils.isElementDisplayed(logoutLink);
	}
	public boolean isMyACcountHeaderExist() {
		return eleUtils.isElementDisplayed(MyAccountHeader);
	}
	
	public ResultsPage doSaerch(String ProductName) throws InterruptedException {
		Thread.sleep(2000);
		WebElement searchbox= eleUtils.waitForElementVisible(Search, AppConstants.DEFAULT_MEDIAM_TIME_OUT);
		searchbox.clear();
		searchbox.sendKeys(ProductName);
		eleUtils.doClick(serachBtn);
		
		return new ResultsPage(driver);
	}
	

}
