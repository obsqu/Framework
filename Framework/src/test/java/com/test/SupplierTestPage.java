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
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.SupplierPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class SupplierTestPage extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	SupplierPage splrpg;
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
		splrpg=homepg.navigateToSupplierPage();
		
	}
	
	@Test(priority=1,enabled=true)
	public void validateAddSupplierDetails() throws Exception {
		
		//comon.ClickOnAddButton();
		
		splrpg.ClickOnAddButton();
		splrpg.clickOnSupplierName();
		//waitutil.waitForAnElement(driver,By.id("//input[@id='SupplierName']"), 10);
		splrpg.enterSupplierName("Miraj");
		splrpg.enterSupplierPhone("12324");
		splrpg.enterSupplierMail("ad@gmail.com");
		splrpg.enterSupplierNote("JHDYDGC");
		splrpg.ClickOnSubmitDatas();
		
		//comon.ClickOnSubmitDetails();
		//comon.ClickOnSearchDetails("HAI");
		
		splrpg.ClickOnSearchDetails("Miraj");
		soft.assertEquals(splrpg.getSuplierNameFromSearchResult(),"Miraj","Failure message : suplier name not matched");
		soft.assertEquals(splrpg.getSuplierPhoneNumberFromSearchResult(),"12324","Failure message : suplier phone not matched");
		soft.assertEquals(splrpg.getSuplierEmailidFromSearchResult(),"ad@gmail.com","Failure message : suplier mail not matched");
		soft.assertAll();
	}
	
	@Test(priority=3,enabled=true)
	public void validateDeleteWaiterData() {
		
		//comon.ClickOnSearchDetails("Miraj");
		
		splrpg.ClickOnSearchDetails("gdf");
		splrpg.clickDeleteSuplirDataButton();
		splrpg.ClickOnSearchDetails("gdf");
		//comon.ClickOnSearchDetails("Miraj");
		Assert.assertEquals(splrpg.getSuplierNameFromSearchResult(),"No matching records found","Failure message : Supplier name not matched");
		
	}
	
	@Test(priority=2,enabled=true)
	public void validateEditButoonForWaiter() {
		
		//comon.ClickOnSearchDetails("HAI");
		
		splrpg.ClickOnSearchDetails("HAI");
		splrpg.clickEditSuplirDataButton();
		splrpg.enterSupplierName("Shibina");
		splrpg.enterSupplierPhone("9857463523");
		splrpg.enterSupplierMail("shibi@gmail.com");
		splrpg.enterSupplierNote("WEHDYDGCI");
		
		splrpg.clickEditSubmitBtn();
		splrpg.ClickOnSearchDetails("Shibina");
		//comon.ClickOnSearchDetails("Miraj");
		
		soft.assertEquals(splrpg.getSuplierNameFromSearchResult(),"Shibina","Failure message : suplier name not matched");
		soft.assertEquals(splrpg.getSuplierPhoneNumberFromSearchResult(),"9857463523","Failure message : suplier phone not matched");
		soft.assertEquals(splrpg.getSuplierEmailidFromSearchResult(),"shibi@gmail.com","Failure message : suplier mail not matched");
		soft.assertAll();
	}


}
