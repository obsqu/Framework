package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WebElementUtils;

public class LoginPageTest extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	
	PropertyUtil property=new PropertyUtil();
	
	@BeforeMethod
	public void preRun() throws IOException
	{
		driver=getDriver();
		
		Properties allProp=property.getAllProperties("config.properties");
		String site=allProp.getProperty("url");
		brwsrUtil.launchUrl(driver,site);
		
		
		loginpg=new LoginPage(driver);
		homepg=new HomePage(driver);
		
		
	}
	@Test
	public void validateLogin()
	{
		loginpg.enterValuetoUsername("admin");
		loginpg.enterValuetoPassword("password");
		loginpg.clickLoginButton();
		
		
		Assert.assertTrue(homepg.isPosDisplayed(),"Failure : Login failed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*@Test
	public void invalidLogin()
	{
		loginpg.enterValuetoUsername("shibina");
		loginpg.enterValuetoPassword("password");
		loginpg.clickLoginButton();
	}
	
	@Test
	public void emptyLogin()
	{
		loginpg.enterValuetoUsername("");
		loginpg.enterValuetoPassword("");
		loginpg.clickLoginButton();
	}*/
}
