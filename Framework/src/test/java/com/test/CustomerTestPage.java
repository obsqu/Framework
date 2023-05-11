package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
import com.utilities.ExcelUtils;
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
	ExcelUtils excelutil;
	CommonDatas common=new CommonDatas();
	
	@BeforeMethod
	public void preRun() throws IOException
	{
		excelutil= new ExcelUtils();
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
	
	public void validateElementsonAddProduct()
	{
		custmpg.ClickOnAddButton();
		waitutil.waitForElementToBeClickable(driver,custmpg.customerName,20);
		
		soft.assertTrue(custmpg.isCustomerNameDisplayed(),"Failure Message: CustomerName is not displayed");
		soft.assertTrue(custmpg.isCustomerEmailDisplayed(),"Failure Message: CustomerEmail is not displayed");
		soft.assertTrue(custmpg.isCustomerPhoneDisplayed(),"Failure Message: Customerphone is not displayed");
		soft.assertTrue(custmpg.isCustomerDiscountDisplayed(),"Failure Message: CustomerDiscount is not displayed");
		
		custmpg.clickOnCloseCustomerButton();
		soft.assertAll();
		
	}	
	
	//@Test(priority=2,enabled=true)
	public void validateAddCustomerDetails() throws Exception {
		
		//common.ClickOnAddButton();
		String custmrenm=excelutil.readStringData("Customer",2,1);
		String custmrphone=excelutil.readStringData("Customer",2,2);
		String custmremail=excelutil.readStringData("Customer",2,3);
		String custmrdiscnt=excelutil.readStringData("Customer",2,4);
		
		custmpg.ClickOnAddButton();
		
		custmpg.clickOnCustomername();
		waitutil.waitForAnElement(driver,custmpg.customerName, 10);
		custmpg.clickOnPhoneNumber();
		custmpg.enterValueForCustomerName(custmrenm);
		waitutil.waitForAnElement(driver,custmpg.customerPhoneNumber, 10);
		custmpg.enterValueForCustomerPhoneNumber(custmrphone);
		custmpg.enterValueForCustomerMail(custmremail);
		custmpg.enterValueForCustomerDiscount(custmrdiscnt);
		//common.ClickOnSubmitDetails();
		
		custmpg.ClickSubmitCustomerDetails();
		custmpg.SearchDetails("Shahina");
		
		//common.ClickOnSearchDetails("Miraj");
		soft.assertEquals(custmpg.getCustomerNameFromSearchResult(),"Shahina","Failure message : Customer name not matched");
		soft.assertEquals(custmpg.getCustomerPhoneNumberFromSearchResult(),"982363876","Failure message : Customer phone not matched");
		soft.assertEquals(custmpg.getCustomerEmailidFromSearchResult(),"shahina@gmail.com","Failure message : Customer mail not matched");
		soft.assertEquals(custmpg.getCustomerDiscountFromSearchResult(),"20%","Failure message : Customer discount not matched");
		soft.assertAll();
	}
	
	//@Test(priority=4,enabled=true)
	public void validateDeleteCustomerData() {
		
		custmpg.SearchDetails("Gifty");
		//common.ClickOnSearchDetails("Arya");
		custmpg.clickDeleteCustomerDataButton();
		
		custmpg.SearchDetails("Gifty");
		//common.ClickOnSearchDetails("Arya");
		Assert.assertEquals(custmpg.getCustomerNameFromSearchResult(),"No matching records found","Failure message : custmer name not matched");
		
	}
	
	//@Test(priority=3,enabled=true)
	public void validateEditButtonForCustomer() {
		
		custmpg.SearchDetails("Shibina");
		//common.ClickOnSearchDetails("Jasmin");
		custmpg.clickEditCustomerDataButton();
		custmpg.enterValueForCustomerName("Naseera");
		custmpg.enterValueForCustomerPhoneNumber("9857463565");
		custmpg.enterValueForCustomerMail("mir@gmail.com");
		custmpg.enterValueForCustomerDiscount("20%");
		
		custmpg.clickSubmitEditCustmrDetails();
		custmpg.SearchDetails("Naseera");
		//common.ClickOnSearchDetails("Shibina");
		soft.assertEquals(custmpg.getCustomerNameFromSearchResult(),"Naseera","Failure message : Customer name not matched");
		soft.assertEquals(custmpg.getCustomerPhoneNumberFromSearchResult(),"9857463565","Failure message : Customer phone not matched");
		soft.assertEquals(custmpg.getCustomerEmailidFromSearchResult(),"mir@gmail.com","Failure message : Customer mail not matched");
		soft.assertEquals(custmpg.getCustomerDiscountFromSearchResult(),"20%","Failure message : Customer discount not matched");
		soft.assertAll();
	}


}
