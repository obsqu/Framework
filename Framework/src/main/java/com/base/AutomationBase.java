package com.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;

public class AutomationBase {
	static WebDriver driver;
	
	BrowserUtils brwsrUtil;
	LoginPage loginpg;
	PropertyUtil property;
	
@BeforeTest
public void prerun() throws IOException
{
	loginpg=new LoginPage(driver);
	brwsrUtil=new BrowserUtils();
	Properties allProp=property.getAllProperties("config.properties");
	brwsrUtil.launchUrl(driver,allProp.getProperty("url"));
}
@Parameters("browserName")
	public void launchBrowser(String browserName) throws Exception
	{
		switch(browserName)
		{
		case "chrome":
			launchChromeBrowser();
			break;
			
		case "edge":
			launchEdgeBrowser();
			break;
			
		case "firefox":
			launchFireFoxBrowser();
			break;	
		default:
			//System.out.println(AutomationConsttants.CHECKBROWSER_MESSAGE);
			break;
		}
		return driver;
	}
	
	private void launchChromeBrowser() throws Exception
	{
		try
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
		}catch(Exception e)
		{
			throw new Exception(e);
		}
	}
	
	private void launchEdgeBrowser() throws Exception
	{
		try
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			
		}catch(Exception e)
		{
			throw new Exception(e);
		}
	}
	
	private void launchFireFoxBrowser() throws Exception
	{
		try
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}catch(Exception e)
		{ 
			throw new Exception(e);
		}
	}

	public static  WebDriver getDriver() {
		
		return driver;
	}
	
	

}
