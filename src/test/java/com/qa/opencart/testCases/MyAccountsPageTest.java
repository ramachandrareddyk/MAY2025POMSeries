package com.qa.opencart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.testBase.BaseTest;

public class MyAccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accountsPageSetup() {
		accountpage= login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void accountsPageTitleTest() {
		String ActTitle= accountpage.getAccPageTitle();
		Assert.assertEquals(ActTitle, AppConstants.MY_ACCOUNT_PAGE_TITLE);
	
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountpage.isLogoutlinkExist());
	}
	
	@Test
	public void isMYAccountHeaderIsExistTest() {
		Assert.assertTrue(accountpage.isMyACcountHeaderExist());
	}
	
	
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook",3},
			{"imac",1},
			{"samsung",2}
		};
	}
	
	
	
	
	@Test(dataProvider ="getSearchKey")
	public void searchCountTest(String searchkey, int count) throws InterruptedException {
		//String productName="macbook";
		resultspage= accountpage.doSaerch(searchkey);
		Assert.assertEquals(resultspage.getGetSearchResultsCount(), count);
		
	}
	
	
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"macbook","MacBook Air"},
			{"macbook","MacBook Pro"},
			{"imac","iMac"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"samsung","Samsung Galaxy Tab 10.1"}		
		};
	}
	
	@Test(dataProvider ="getSearchData")
	public void searchTest(String Searchkey, String ProductName) throws InterruptedException {
		//String productName="MacBook";
		resultspage= accountpage.doSaerch(Searchkey);
		Thread.sleep(3000);
		productpage= resultspage.selectProduct(ProductName);
		Assert.assertEquals(productpage.getProductHeader(),ProductName);
		
		
	}
	
	

}
