package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;

public class ProductPageTest extends AutomationBase{


	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ProductPage pdtpage;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	
	
	@BeforeMethod
	public void preRun()
	{
		driver=getDriver();
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		homepg=loginpg.login("admin","password");
		pdtpage=homepg.navigateToPdtPage();
	}
	
	/*@Test
	public void selectEntries()
	{
		SoftAssert soft=new SoftAssert();
		pdtpage.tableEntryisShown(0);
		pdtpage.supplierListShown("Supplier1");
		pdtpage.productTypeList("Standard");
		pdtpage.isApplyFilterClick();
		
	}*/
	
	/*@Test
	public void addProductDetials()
	{
		pdtpage.isAddProductClick();
		pdtpage.addProductType("0");
		pdtpage.addProductCode("123490");
		pdtpage.addProductName("Grapes");
		pdtpage.addProductCategory("fruits");
		pdtpage.addProductSupplier("Anujith");
		pdtpage.addPurchasePrice("340");
		pdtpage.addProductTax("6%");
		pdtpage.addPrdtTaxmethod("0");
		pdtpage.addProductPrice("380");
		pdtpage.addPurchasePrice("Kg");
		pdtpage.addAlertQuantity("30");
		pdtpage.addProductOption("Good,Taste");
		pdtpage.addProductDescription("Good,Taste,Super");
		//pdtpage.submitProductDetails();
		
	}
	
	@Test
	public void deleteProduct()
	{
		pdtpage.deleteProductDetails();
	}*/
	@Test
	public void viewProduct()
	{
		pdtpage.viewProductDetails();
	}
	
	
	
}
