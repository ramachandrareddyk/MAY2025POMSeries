package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	//1. private By locaters
	private By username=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgetPwd=By.linkText("Forgotten Password");
	private By logo=By.xpath("//img[@title='naveenopencart']");
	private By Register=By.linkText("Register");
	
	
	//2. constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtils= new ElementUtil(driver);
	}
	
	
	//3. Action methods
	
	public String getLoginPageTitle() {
		
		String title=eleUtils.waitForTitleContainsAndReturn(AppConstants.LOGINPAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page title is= "+title);
		return title;
	}
	public String getLoginPageURL() {
		
		String url=eleUtils.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		
		System.out.println("Login page URL is= "+url);
		return url;
	}
	
	public boolean isForgetPasswordLinkExist() {
		return eleUtils.isElementDisplayed(forgetPwd);
	}
	
	public boolean islogoExist() {
		return eleUtils.isElementDisplayed(logo);
	}
	
	public MyAccountPage doLogin(String userName, String pwd)  {
		
		eleUtils.waitForElementVisible(username, AppConstants.DEFAULT_MEDIAM_TIME_OUT).sendKeys(userName);
		eleUtils.doSendKeys(password, pwd);
		eleUtils.doClick(loginBtn);
		
	return new MyAccountPage(driver);
		
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtils.doClick(Register);
		return new RegisterPage(driver);
	}

}
