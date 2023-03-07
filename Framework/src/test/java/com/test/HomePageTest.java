package com.test;

import java.util.Properties;

import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;

public class HomePageTest extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	
	
	@BeforeMethod
	public void preRun()
	{
		driver=getDriver();
		
		
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		homepg=loginpg.login("admin","password");
	}
	
	/*@Test
	public void checkingIsClickableMenus()
	{
		homepg.clickPosOnHomePage();
		homepg.clickProductOnHomePage();
		homepg.clickStoreOnHomePage();
		homepg.clickPeopleOnHomePage();
		homepg.clickSaleOnHomePage();
		homepg.clickExpenseOnHomePage();
		homepg.clickCategoryOnHomePage();
		homepg.clickSettingOnHomePage();
		homepg.clickreportOnHomePage();
		homepg.clickAdminOnHomePage();
	}*/
	
	@Test
	public void ValidatetheMenuItemsDisplayedonTheHomePage()
	{
		SoftAssert soft=new SoftAssert();
		boolean flagpos=homepg.isPosDisplayed();
		soft.assertTrue(flagpos,"Fail: POS is not displayed");
		
		boolean flagpdt=homepg.isProductDisplayed();
		soft.assertTrue(flagpdt,"Fail: Product link is not displayed");
		
		boolean flagstr=homepg.isStoreDisplayed();
		soft.assertTrue(flagstr,"Fail: Store link is not displayed");
		
		boolean flagpepl=homepg.isPeopleDisplayed();
		soft.assertTrue(flagpepl,"Fail: People link is not displayed");
	
		/*boolean flagwaiter=homepg.isWaiterDisplayed(0);
		soft.assertTrue(flagwaiter,"Fail: Waiter link under people is not displayed");
		
		boolean flagcustmr=homepg.isCustomerDisplayed(1);
		soft.assertTrue(flagcustmr,"Fail: Customer link under people is not displayed");
		
		boolean flagsuplr=homepg.isSupplierDisplayed(2);
		soft.assertTrue(flagsuplr,"Fail: Supplier link under people is not displayed");*/
		
		boolean flagsale=homepg.isSaleDisplayed();
		soft.assertTrue(flagsale,"Fail: Sale link is not displayed");
		
		boolean flagexpns=homepg.isExpenseDisplayed();
		soft.assertTrue(flagexpns,"Fail: Expense link is not displayed");
		
		boolean flagcatgry=homepg.isCategoryDisplayed();
		soft.assertTrue(flagcatgry,"Fail: Category link is not displayed");
		
		boolean flagseting=homepg.isSettingDisplayed();
		soft.assertTrue(flagseting,"Fail: Setting link is not displayed");
		
		boolean flagrept=homepg.isReportDisplayed();
		soft.assertTrue(flagrept,"Fail: Report link is not displayed");
		
		boolean flagadmindoe=homepg.isAdmindoeDisplayed();
		soft.assertTrue(flagadmindoe,"Fail: AdminDoe link is not displayed");
		
		boolean flaglogout=homepg.isLogoutDisplayed();
		soft.assertTrue(flaglogout,"Fail: Logout button is not displayed");
		
		soft.assertAll();
	
	}
	
	
	
	
	
		
	

}
