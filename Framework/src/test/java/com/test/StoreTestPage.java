package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class StoreTestPage extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	StorePage storepg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	SoftAssert soft=new SoftAssert();
	PropertyUtil property=new PropertyUtil();
	WaitUtils waitutil=new WaitUtils();
	
	@BeforeMethod
	public void preRun() throws IOException
	{
		
        driver=getDriver();
		
		Properties allProp=property.getAllProperties("config.properties");
		String site=allProp.getProperty("url");
		brwsrUtil.launchUrl(driver,site);
		
		waitutil.implicitWait(driver,30);
		
		loginpg=new LoginPage(driver);
		homepg=new HomePage(driver);
		storepg=homepg.navigateToStorePage();
		
		
		
		
	}
	
	@Test(priority=1,enabled=true)
	public void validateAddDatasToStore()
	{
		storepg.clickOnAddStoreButton();
		storepg.clickOnStoreName();
		storepg.enterValueToStoreName("SNStores");
		//storepg.clickOnStoreMail();
		//waitutil.waitForAnElement(driver,By.xpath=("//input[@id='email']"), timeOut)
		storepg.enterValueToStoreEmailID("shibisa@gmail.com");
		storepg.enterValueToStorePhoneNumber("345487643");
		storepg.enterValueToStoreCountryr("India");
		storepg.enterValueToStoreCity("TVM");
		storepg.enterValueToStoreAddress("Sn manzil");
		storepg.enterValueToStoreCustom("ashkjhsdfkjhj");
		storepg.submitStoreValues();
		
		storepg.searchStoreLink("345487643");
		soft.assertEquals(storepg.getStoreNameFromSearchResults(),"SNStores","Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(),"shibisa@gmail.com","Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(),"345487643","Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(),"India","Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(),"TVM","Failure Message: Store City is not matched");
		soft.assertAll();
		
	}
	
    @Test(priority=3,enabled=true)
	public void validateDeleteStoreDatas() {
		
		storepg.searchStoreLink("SNStores");
		storepg.deleteStoreDetails();
		
		storepg.searchStoreLink("SNStores");
		Assert.assertEquals(storepg.getStoreNameFromSearchResults(),"No matching records found","Failure Message: Store Name is not matched");
		
		
	}
	
	@Test(priority=2,enabled=true)
	public void validateEditStoreDetails() {
		
		storepg.searchStoreLink("345487643");
		storepg.editStoreDetails();
		storepg.enterValueToStoreName("AKNSStores");
		storepg.enterValueToStoreEmailID("wowshibis@gmail.com");
		storepg.enterValueToStorePhoneNumber("9876542314");
		storepg.enterValueToStoreCountryr("INDIA");
		storepg.enterValueToStoreCity("TVM");
		storepg.enterValueToStoreAddress("SN manzil");
		storepg.enterValueToStoreCustom("HiaAll");
		storepg.submitEditDetails();
		
		storepg.searchStoreLink("9876542314");
		soft.assertEquals(storepg.getStoreNameFromSearchResults(),"AKNSStores","Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(),"wowshibis@gmail.com","Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(),"9876542314","Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(),"INDIA","Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(),"TVM","Failure Message: Store City is not matched");
		soft.assertAll();
	}
	

}
