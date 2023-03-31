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
import com.utilities.ExcelUtils;
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
	ExcelUtils excelutil;
	
	@BeforeMethod
	public void preRun() throws IOException
	{
		excelutil=new ExcelUtils("RestaurantDatas.xlsx");
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
		
		String waiternm=excelutil.readStringData("Waiter",2,1);
		String waiterphn=excelutil.readStringData("Waiter",2,2);
		String waiteremail=excelutil.readStringData("Waiter",2,3);
		String waiterstr=excelutil.readStringData("Waiter",2,4);
		
		watrpg.clickOnWaitername();
		waitutil.waitForAnElement(driver,By.xpath("//input[@id='WaiterName']"), 10);
		watrpg.enterValueForWaiterName(waiternm);
		waitutil.waitForAnElement(driver,By.xpath("//input[@id='WaiterPhone']"), 10);
		watrpg.enterValueForWaiterPhone(waiterphn);
		watrpg.enterValueForWaiterEmailId(waiteremail);
		watrpg.selectValueForWaiterStore(waiterstr);
		
		//comon.ClickOnSubmitDetails();
		watrpg.submitWaiterValues();
		//comon.ClickOnSearchDetails("Shibina");
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
		
		watrpg.searchWaiterLink("Miraj");
		watrpg.clickEditWaiterDataButton();
		watrpg.enterValueForWaiterName("shibi");
		watrpg.enterValueForWaiterPhone("84574635");
		watrpg.enterValueForWaiterEmailId("shibi@gmail.com");
		watrpg.selectValueForWaiterStore("MNC");
		
		watrpg.submitWaiterValues();
		watrpg.searchWaiterLink("shibi");
		
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"shibi","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(),"84574635","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(),"shibi@gmail.com","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(),"MNC","Failure message : Waiter name not matched");
		soft.assertAll();
	}

		
}
