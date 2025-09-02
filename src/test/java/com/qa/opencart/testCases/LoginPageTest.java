package com.qa.opencart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.testBase.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1, enabled = true)
	public void loginpageTitleTest() {
		String Acttitle=login.getLoginPageTitle();
		Assert.assertEquals(Acttitle, AppConstants.LOGINPAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginpageUrlTest() {
		String ActUrl=login.getLoginPageURL();
		Assert.assertTrue(ActUrl.contains(AppConstants.LOGIN_PAGE_URL));
	}
	
	@Test(priority = 3)
	public void ForgetPasswordLinkExistTest() {
		Assert.assertTrue(login.isForgetPasswordLinkExist());
	}
	
	@Test(priority = 4)
	public void logoExistTest() {
		Assert.assertTrue(login.islogoExist());
	}
	
	@Test(priority = 5)
	public void doLoginTest() throws InterruptedException {
		accountpage= login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		Assert.assertEquals(accountpage.getAccPageTitle(),AppConstants.MY_ACCOUNT_PAGE_TITLE);
	}

}
