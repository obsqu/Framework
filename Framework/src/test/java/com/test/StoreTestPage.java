package com.test;

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
import com.utilities.WebElementUtils;

public class StoreTestPage extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	StorePage storepg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	SoftAssert soft=new SoftAssert();
	
	@BeforeMethod
	public void preRun()
	{
		driver=getDriver();
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		homepg=loginpg.login("admin","password");
		storepg=homepg.navigateToStorePage();
	}
	
	@Test(priority=1,enabled=true)
	public void validateAddDatasToStore()
	{
		storepg.addStoreButton();
		storepg.addStoreName("SNStores");
		storepg.addStoreEmailid("shibisa@gmail.com");
		storepg.addStorePhoneNo("345487643");
		storepg.addStoreCountry("India");
		storepg.addStoreCity("TVM");
		storepg.addStoreAddress("Sn manzil");
		storepg.addStoreCustmFoot("ashkjhsdfkjhj");
		storepg.submitStoreValues();
		
		storepg.searchStoreLink("345487643");
		soft.assertEquals(storepg.getStoreNameFromSearchResults(),"SNStores","Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(),"shibisa@gmail.com","Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(),"345487643","Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(),"India","Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(),"TVM","Failure Message: Store City is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=2,enabled=true)
	public void validateDeleteStoreDatas() {
		
		storepg.searchStoreLink("ASJStores");
		storepg.deleteStoreDetails();
		
		storepg.searchStoreLink("ASJStores");
		Assert.assertEquals(storepg.getStoreNameFromSearchResults(),"No matching records found","Failure Message: Store Name is not matched");
		
		
	}
	
	@Test(priority=3,enabled=true)
	public void validateEditStoreDetails() {
		
		storepg.searchStoreLink("9123456722");
		storepg.editStoreDetails();
		storepg.addStoreName("AKNSStores");
		storepg.addStoreEmailid("wowshibis@gmail.com");
		storepg.addStorePhoneNo("9876542314");
		storepg.addStoreCountry("INDIA");
		storepg.addStoreCity("TVM");
		storepg.addStoreAddress("SN manzil");
		storepg.addStoreCustmFoot("HiaAll");
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
