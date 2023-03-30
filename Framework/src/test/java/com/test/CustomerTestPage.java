package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CommonDatas;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class CustomerTestPage extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	CustomerPage custmpg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	SoftAssert soft=new SoftAssert();
	PropertyUtil property=new PropertyUtil();
	WaitUtils waitutil=new WaitUtils();
	
	CommonDatas common=new CommonDatas();
	
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
		custmpg=homepg.navigateToCustomerPage();
		
			
	}
	
	@Test(priority=1,enabled=true)
	public void validateAddCustomerDetails() {
		
		common.ClickOnAddButton();
		
		custmpg.enterValueForCustomerName("Miraj");
		custmpg.enterValueForCustomerPhoneNumber("7654356789");
		custmpg.enterValueForCustomerMail("miraj@gmail.com");
		custmpg.enterValueForCustomerDiscount("10");
		common.ClickOnSubmitDetails();
		
		common.SearchDetails("Miraj");
		soft.assertEquals(custmpg.getCustomerNameFromSearchResult(),"Miraj","Failure message : Customer name not matched");
		soft.assertEquals(custmpg.getCustomerPhoneNumberFromSearchResult(),"7654356789","Failure message : Customer phone not matched");
		soft.assertEquals(custmpg.getCustomerEmailidFromSearchResult(),"miraj@gmail.com","Failure message : Customer mail not matched");
		soft.assertEquals(custmpg.getCustomerDiscountFromSearchResult(),"10","Failure message : Customer discount not matched");
		soft.assertAll();
	}
	
	@Test(priority=3,enabled=false)
	public void validateDeleteCustomerData() {
		
		common.SearchDetails("Miraj");
		custmpg.clickDeleteCustomerDataButton();
		common.SearchDetails("Miraj");
		Assert.assertEquals(custmpg.getCustomerNameFromSearchResult(),"No matching records found","Failure message : custmer name not matched");
		
	}
	
	@Test(priority=2,enabled=false)
	public void validateEditButtonForcustomer() {
		
		common.SearchDetails("Miraj");
		custmpg.clickEditCustomerDataButton();
		custmpg.enterValueForCustomerName("Shibina");
		custmpg.enterValueForCustomerPhoneNumber("9857463565");
		custmpg.enterValueForCustomerMail("mir@gmail.com");
		custmpg.enterValueForCustomerDiscount("20");
		
		custmpg.clickSubmitEditCustmrDetails();
		common.SearchDetails("Miraj");
		soft.assertEquals(custmpg.getCustomerNameFromSearchResult(),"Shibina","Failure message : Customer name not matched");
		soft.assertEquals(custmpg.getCustomerPhoneNumberFromSearchResult(),"9857463565","Failure message : Customer phone not matched");
		soft.assertEquals(custmpg.getCustomerEmailidFromSearchResult(),"mir@gmail.com","Failure message : Customer mail not matched");
		soft.assertEquals(custmpg.getCustomerDiscountFromSearchResult(),"20","Failure message : Customer discount not matched");
		soft.assertAll();
	}


}
