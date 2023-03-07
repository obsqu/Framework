package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomationBase {
	static WebDriver driver;
	
@BeforeTest
@Parameters("browserName")
	public WebDriver launchBrowser(String browserName) throws Exception
	{
		switch(browserName)
		{
		case "chrome":
			launchChromeBrowser();
			break;
			
		case "edge":
			launchChromeBrowser();
			break;
			
		case "firefox":
			launchChromeBrowser();
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
	
	public WebDriver getDriver()
	{
	   return driver;	
	}

}
