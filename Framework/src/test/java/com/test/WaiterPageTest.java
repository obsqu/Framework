package com.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CommonDatas;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class WaiterPageTest extends AutomationBase{

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	WaiterPage watrpg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	SoftAssert soft=new SoftAssert();
	PropertyUtil property=new PropertyUtil();
	WaitUtils waitutil=new WaitUtils();
	CommonDatas comon=new CommonDatas();
	
	@BeforeMethod
	public void preRun() throws IOException
	{
       driver=getDriver();
		
		Properties allProp=property.getAllProperties("config.properties");
		String site=allProp.getProperty("url");
		brwsrUtil.launchUrl(driver,site);
		//waitutil.implicitWait(driver,30);
		
		loginpg=new LoginPage(driver);
		homepg=new HomePage(driver);
		watrpg=homepg.navigateToWaiterPage();
		
		
		
	}
	
	@Test(priority=1,enabled=true)
	public void validateAddWaiterDatas() throws Exception {
		
		//comon.ClickOnAddButton();
		watrpg.ClickOnAddWaiterButton();
		watrpg.clickOnWaitername();
		waitutil.waitForAnElement(driver,By.xpath("//input[@id='WaiterName']"), 10);
		watrpg.enterValueForWaiterName("Shibina");
		waitutil.waitForAnElement(driver,By.xpath("//input[@id='WaiterPhone']"), 10);
		watrpg.enterValueForWaiterPhone("9857463524");
		watrpg.enterValueForWaiterEmailId("shib@gmail.com");
		watrpg.selectValueForWaiterStore("MCDS");
		
		//comon.ClickOnSubmitDetails();
		watrpg.submitWaiterValues();
		//comon.SearchDetails("Shibina");
		watrpg.searchWaiterLink("Shibina");
		
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"Shibina","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(),"9857463524","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(),"shib@gmail.com","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(),"MCDS","Failure message : Waiter name not matched");
		soft.assertAll();
	}
	
	@Test(priority=3,enabled=false)
	public void validateDeleteWaiterData() {
		
		watrpg.searchWaiterLink("shibina");
		watrpg.clickDeleteWaiterDataButton();
		watrpg.searchWaiterLink("shibina");
		Assert.assertEquals(watrpg.getWaiterNameFromSearchResult(),"No matching records found","Failure message : Waiter name not matched");
		
	}
	
	@Test(priority=2,enabled=false)
	public void validateEditButoonForWaiter() {
		
		watrpg.searchWaiterLink("shibi");
		watrpg.clickEditWaiterDataButton();
		watrpg.enterValueForWaiterName("Miraj");
		watrpg.enterValueForWaiterPhone("9857463565");
		watrpg.enterValueForWaiterEmailId("mir@gmail.com");
		watrpg.selectValueForWaiterStore("MNC");
		
		watrpg.submitWaiterValues();
		watrpg.searchWaiterLink("Miraj");
		
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"Miraj","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(),"9857463565","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(),"mir@gmail.com","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(),"MNC","Failure message : Waiter name not matched");
		soft.assertAll();
	}

		
}
