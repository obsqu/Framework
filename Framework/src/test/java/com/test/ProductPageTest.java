package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	SoftAssert soft=new SoftAssert();
	
	@BeforeMethod
	public void preRun()
	{
		driver=getDriver();
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		homepg=loginpg.login("admin","password");
		pdtpage=homepg.navigateToPdtPage();
	}
	
	@Test(priority=1,enabled=true)
	
	public void validateElementsonProduct()
	{
		pdtpage.clickOnAddProductButton();
		soft.assertTrue(pdtpage.isAddProductDisplayed(),"Failure Message: addProduct is not displayed");
		soft.assertTrue(pdtpage.isProductTypeDisplayed(),"Failure Message: ProductType is not displayed");
		soft.assertTrue(pdtpage.isProductCodeDisplayed(),"Failure Message: ProductCode is not displayed");
		soft.assertTrue(pdtpage.isProductNameDisplayed(),"Failure Message: ProductName is not displayed");
		soft.assertTrue(pdtpage.isProductCategoryDisplayed(),"Failure Message: ProductCategory is not displayed");
		soft.assertTrue(pdtpage.isProductSupplierDisplayed(),"Failure Message: ProductSupplier is not displayed");
		soft.assertAll();
		
	}
	
	@Test(priority=2,enabled=true)
	public void addProductDetials()
	{
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("Service");
		pdtpage.enterProductCode("303032");
		pdtpage.enterProductName("BBQ");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.selectProductSupplier("Anujith");
		pdtpage.enterProductPurchasePrice("10000");
		pdtpage.enterProductTax("15");
		pdtpage.selectPrdtTaxmethod("exclusive");
		pdtpage.enterProductPrice("15000");
		pdtpage.enterProductUnit("10");
		pdtpage.enterAlertQuantity("30");
		pdtpage.enterProductOption("Good,Taste");
		pdtpage.enterProductDescription("Good Quality,Super");
		pdtpage.submitProductDetails();
		//pdtpage.closeProductDetails();
		
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"303032","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQ","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality,Super","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"15","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"15000","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	/*@Test
	public void deleteProduct()
	{
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"303032","Failure Message: Product Code is not matched");
		pdtpage.deleteProductDetails();
	}
	
	@Test
	public void viewProduct()
	{
		pdtpage.viewProductDetails();
	}*/
	
	
	
}
