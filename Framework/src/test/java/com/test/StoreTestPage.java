package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;

public class StoreTestPage extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	StorePage storepg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	
	
	@BeforeMethod
	public void preRun()
	{
		driver=getDriver();
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		homepg=loginpg.login("admin","password");
		//storepg=homepg.navigateToStorePage();
	}
	
	@Test
	public void addDatasToStore()
	{
		storepg.addStoreName("ADSC");
		storepg.addEmailId("sh@gmail.com");
		storepg.addStorePhone("345487643");
		storepg.addCountry("India");
		storepg.addCity("TVM");
		storepg.addAddress("Sn manjf");
		storepg.addCustomFooter("ashkjhsdfkjhj");
	}

}
