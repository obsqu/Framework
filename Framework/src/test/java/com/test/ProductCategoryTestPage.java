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
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductCategoryPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ProductCategoryTestPage extends AutomationBase{

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ProductCategoryPage pdtctgry;
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
		pdtctgry=homepg.navigateToProductCategoryPage();
		
			
	}
	
	@Test(priority=1,enabled=false)
	public void ValidateTheMenuItemsDisplayedAddExpensePage()
	{
		
		
		pdtctgry.ClickOnAddCategoryButton();
		
		boolean flagdt=pdtctgry.isCategoryNameDisplayed();
		Assert.assertTrue(flagdt,"Fail: CategoryName field is not displayed");
		pdtctgry.ClickOnCloseButton();
	}
	
	@Test(priority=2,enabled=true)
	public void validateAddProductCategoryDetails() throws Exception {
		
		//comon.ClickOnAddButton();
		
		pdtctgry.ClickOnAddCategoryButton();
		pdtctgry.ClickOnCategoryName();
		//waitutil.waitForAnElement(driver,By.id("//input[@id='CategoryName']"), 10);
		
		pdtctgry.enterValueForCategryName("Broasted");
		
        pdtctgry.ClickOnSubmitCategoryValues();
		
		//comon.ClickOnSubmitDetails();
		//comon.ClickOnSearchDetails("HAI");
		brwsrUtil.refreshPage(driver);
		pdtctgry.ClickOnSearchCategoryLink("Broasted");
		
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(),"Broasted","Failure message : category name not matched");
}
	
	@Test(priority=3,enabled=false)
	public void validateEditButtonForCategoryDetails() {
	
		pdtctgry.ClickOnSearchCategoryLink("Munch");
		pdtctgry.ClickOnCategoryEditButton();
		pdtctgry.enterValueForCategryName("Pizza");
		pdtctgry.ClickOnSubmitEditButton();
		brwsrUtil.refreshPage(driver);
		pdtctgry.ClickOnSearchCategoryLink("Pizza");
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(),"Pizza","Failure message : category name not matched");
	}	
	
	@Test(priority=4,enabled=false)
	public void validateDeleteWaiterData() {
		
		pdtctgry.ClickOnSearchCategoryLink("burger");
		pdtctgry.ClickOnDeleteButton();
		//brwsrUtil.refreshPage(driver);
		pdtctgry.ClickOnSearchCategoryLink("burger");
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(),"No matching records found","Failure message : category name not matched");
		
	}
	

	
	
}