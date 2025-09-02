package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constents.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	private By firstName= By.id("input-firstname");
	private By lastName= By.id("input-lastname");
	private By email=By.id("input-email");
	private By Telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By conformPassword=By.id("input-confirm");
	
	private By subscribYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@name='newsletter']");
	private By subscribNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@name='newsletter']");
	
	private By agreeCheckBox=By.name("agree");
	private By continueBtn=By.xpath("//input[@value='Continue']");
	
	private By successMessage=By.tagName("h1");
	
	private By logoutLink=By.linkText("Logout");
	private By Register=By.linkText("Register");
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtils= new ElementUtil(driver);
		
	}
	
	public boolean userRegistration(String firstname, String LastName, String Email, String phone, String Pass,String sub) {
		
		eleUtils.waitForElementVisible(this.firstName, AppConstants.DEFAULT_MEDIAM_TIME_OUT).sendKeys(firstname);
		eleUtils.doSendKeys(this.lastName, LastName);
		eleUtils.doSendKeys(this.email, Email);
		eleUtils.doSendKeys(this.Telephone, phone);
		eleUtils.doSendKeys(this.password, Pass);
		eleUtils.doSendKeys(this.conformPassword, Pass);
		
		if(sub.equalsIgnoreCase("yes")) {
			eleUtils.doClick(subscribYes);
		}else {
			eleUtils.doClick(subscribNo);
		}
		
		eleUtils.doClick(agreeCheckBox);
		eleUtils.doClick(continueBtn);
		
		String message=eleUtils.waitForElementVisible(successMessage, AppConstants.DEFAULT_LONG_TIME_OUT).getText();
		
		System.out.println(message);
		
		if(message.contains("Your Account Has Been Created!")) {
			eleUtils.doClick(logoutLink);
			eleUtils.doClick(Register);
			return true;
		}else {
			return false;
		}
	}
	
	

}
