package com.qa.opencart.testBase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.testCases.MyAccountsPageTest;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory  factory;
	protected Properties prop;

	protected LoginPage login;
	protected MyAccountPage accountpage;
	protected ResultsPage resultspage;
	protected ProductInfoPage productpage;
	protected RegisterPage registerpage;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName ) {
		factory= new DriverFactory();
		prop=factory.initProperties();
		
		//if browsername is not null,set it in the properties file
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		
		
		driver=factory.initBrowser(prop);
		
		login = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
