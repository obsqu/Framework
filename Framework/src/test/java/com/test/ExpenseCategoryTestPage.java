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
import com.pages.ExpenseCategoryPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpenseCategoryTestPage extends AutomationBase{

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ExpenseCategoryPage expnsctgry;
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
		expnsctgry=homepg.navigateToExpenseCategoryPage();
		
			
	}
	
	@Test(priority=1,enabled=true)
	public void ValidateTheMenuItemsDisplayedAddExpensePage()
	{
		
		
		expnsctgry.ClickOnAddCategoryButton();
		
		boolean flagdt=expnsctgry.isCategoryNameDisplayed();
		Assert.assertTrue(flagdt,"Fail: CategoryName field is not displayed");
		expnsctgry.ClickOnCloseButton();
	}
	
	@Test(priority=2,enabled=true)
	public void validateAddExpenseCategoryDetails() throws Exception {
		
		//comon.ClickOnAddButton();
		
		expnsctgry.ClickOnAddCategoryButton();
		expnsctgry.ClickOnCategoryName();
		String expctgry=excelutil.readStringData("ExpenseCategory",2,1);
		expnsctgry.enterValueForCategryName(expctgry);
		
        expnsctgry.ClickOnSubmitCategoryValues();
		
		//comon.ClickOnSubmitDetails();
		//comon.ClickOnSearchDetails("HAI");
		brwsrUtil.refreshPage(driver);
		expnsctgry.ClickOnSearchCategoryLink("Expt_Catg");
		
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(),"Expt_Catg","Failure message : category name not matched");
}
	
	@Test(priority=3,enabled=true)
	public void validateEditButtonForCategoryDetails() {
	
		expnsctgry.ClickOnSearchCategoryLink("cutlet");
		expnsctgry.ClickOnCategoryEditButton();
		expnsctgry.enterValueForCategryName("Broasted");
		expnsctgry.ClickOnSubmitEditButton();
		brwsrUtil.refreshPage(driver);
		expnsctgry.ClickOnSearchCategoryLink("Broasted");
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(),"Broasted","Failure message : category name not matched");
	}	
	
	@Test(priority=4,enabled=true)
	public void validateDeleteWaiterData() {
		
		expnsctgry.ClickOnSearchCategoryLink("Broasted");
		expnsctgry.ClickOnDeleteButton();
		//brwsrUtil.refreshPage(driver);
		expnsctgry.ClickOnSearchCategoryLink("Broasted");
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(),"No matching records found","Failure message : category name not matched");
		
	}
	
}
