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
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpenseTestPage extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ExpensePage expnspg;
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
		expnspg=homepg.navigateToExpensesPage();
		
			
	}
	
	@Test(priority=1,enabled=false)
	public void ValidateTheMenuItemsDisplayedAddExpensePage()
	{
		
		
		expnspg.ClickOnAddExpenseButton();
		
		boolean flagdt=expnspg.isExpensedateDisplayed();
		soft.assertTrue(flagdt,"Fail: ExpenseDate field is not displayed");
		
		boolean flagref=expnspg.isExpenseRefernseDisplayed();
		soft.assertTrue(flagref,"Fail: ExpenseReference field is not displayed");
		
		boolean flagct=expnspg.isExpenseCategoryDisplayed();
		soft.assertTrue(flagct,"Fail: ExpenseCategory field is not displayed");
		
		boolean flagst=expnspg.isExpenseStoreDisplayed();
		soft.assertTrue(flagst,"Fail: ExpenseStore field is not displayed");
	
		boolean flagamt=expnspg.isExpenseAmountDisplayed();
		soft.assertTrue(flagamt,"Fail: ExpenseAmount field is not displayed");
		
		boolean flagnot=expnspg.isExpenseNoteDisplayed();
		soft.assertTrue(flagnot,"Fail: ExpenseNote field is not displayed");
		soft.assertAll();
		
		expnspg.ClickOnCloseButton();
		
		
	}	
		
	
	@Test(priority=2,enabled=false)
	public void validateAddExpenseDetails() throws Exception {
		
		//comon.ClickOnAddButton();
		
		expnspg.ClickOnAddExpenseButton();
		//waitutil.waitForAnElement(driver,By.id("//input[@id='SupplierName']"), 10);
		expnspg.enterValueForExpenseDate("03/23/2023");
		expnspg.enterValueForExpenseReference("Miraj");
		expnspg.selectValueForExpenseCategory("Pasta");
		expnspg.selectValueForExpenseStore("MNC");
		expnspg.enterValueForExpenseAmount("5600");
		expnspg.enterValueForExpenseNote("Hai All");
		expnspg.ClickOnSubmitExpenseValues();
		
		//comon.ClickOnSubmitDetails();
		//comon.ClickOnSearchDetails("HAI");
		
		expnspg.ClickOnSearchExpenseLink("Miraj");
		
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(),"03/23/2023","Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(),"Miraj","Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(),"5600","Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(),"Pasta","Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(),"MNC","Failure message : expense store not matched");

		soft.assertAll();
	}
	
	@Test(priority=3,enabled=false)
	public void validateEditButtonForExpenseDetails() {
		
		expnspg.ClickOnSearchExpenseLink("Shibi");
		expnspg.ClickOnExpenseEditButton();
		expnspg.enterValueForExpenseDate("05/04/2023");
		expnspg.enterValueForExpenseReference("Mirus");
		expnspg.selectValueForExpenseCategory("cutlet");
		expnspg.selectValueForExpenseStore("MCDS");
		expnspg.enterValueForExpenseAmount("500");
		expnspg.enterValueForExpenseNote("Taste");
		
		expnspg.ClickOnSubmitEditButton();
		expnspg.ClickOnSearchExpenseLink("Shibna");
		
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(),"05/04/2023","Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(),"Mirus","Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(),"500","Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(),"cutlet","Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(),"MCDS","Failure message : expense store not matched");

		soft.assertAll();
	}
	
	@Test(priority=4,enabled=true)
	public void validateDeleteWaiterData() {
		
		expnspg.ClickOnSearchExpenseLink("Arun");
		expnspg.ClickOnDeleteButton();
		expnspg.ClickOnSearchExpenseLink("Arun");
		Assert.assertEquals(expnspg.getExpenseReferenseFromSearchResult(),"No matching records found","Failure message : Refernse value not matched");
		
	}

}
