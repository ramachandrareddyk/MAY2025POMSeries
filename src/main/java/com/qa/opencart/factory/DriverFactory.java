package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.errors.AppErrors;
import com.qa.opencart.exceptions.BrowserExceptions;
import com.qa.opencart.exceptions.FrameworkExceptions;

public class DriverFactory {
	static WebDriver driver;
	Properties prop;
	
	public WebDriver initBrowser(Properties prop) {
		String browsername=prop.getProperty("browser");
		System.out.println("Browser name is = "+browsername);
		
		switch (browsername) {
		case "chrome":
			driver= new ChromeDriver();
			break;
		case "firefox":
			driver= new FirefoxDriver();
			break;
		case "safari":
			driver= new SafariDriver();
			break;

		default:
			System.out.println("Browser not supported: "+browsername+" invalid");
			throw new BrowserExceptions(AppErrors.INVALID_BROWSER_MSG);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	//mvn clean install -Denv="qa"
	public Properties initProperties() {
		prop= new Properties();
		FileInputStream fis=null;
		
		String envName=System.getProperty("env");
		System.out.println("Test cases are running on env: "+envName);
		
		try {
			if(envName==null) {
				System.out.println("env is nul...hence runnning the test cases on QA env");
				fis= new FileInputStream("./Resources/Config/qa.config.properties");
			}else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					fis= new FileInputStream("./Resources/Config/qa.config.properties");
					break;
				case "dev":
					fis= new FileInputStream("./Resources/Config/dev.config.properties");
					break;
				case "stage":
					fis= new FileInputStream("./Resources/Config/stage.config.properties");
					break;
				case "ust":
					fis= new FileInputStream("./Resources/Config/uat.config.properties");
					break;
				case "prod":
					fis= new FileInputStream("./Resources/Config/config.properties");
					break;

				default:
					System.out.println("Please pass the correct env name..."+envName);
					throw new FrameworkExceptions("=====INVALID ENVRONMENT=====");
				}
			}	
		
		prop.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unable to load properties");
		}
		return prop;
	}
	
	public static String getScreenshot(String methodName) {
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String path="D:\\Training Workspace\\May2025POMSeries\\screenshots\\"+methodName+"_"+System.currentTimeMillis()
	+".png";
	File destinantion= new File(path);
	try {
		org.openqa.selenium.io.FileHandler.copy(srcfile, destinantion);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return path;
	
	}
	
	

}
