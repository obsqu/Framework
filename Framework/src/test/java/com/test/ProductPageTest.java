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
	
	/*@Test(priority=1,enabled=true)
	
	public void validateElementsonAddProduct()
	{
		pdtpage.clickOnAddProductButton();
		soft.assertTrue(pdtpage.isAddProductDisplayed(),"Failure Message: addProduct is not displayed");
		soft.assertTrue(pdtpage.isProductTypeDisplayed(),"Failure Message: ProductType is not displayed");
		soft.assertTrue(pdtpage.isProductCodeDisplayed(),"Failure Message: ProductCode is not displayed");
		soft.assertTrue(pdtpage.isProductNameDisplayed(),"Failure Message: ProductName is not displayed");
		soft.assertTrue(pdtpage.isProductCategoryDisplayed(),"Failure Message: ProductCategory is not displayed");
		soft.assertTrue(pdtpage.isProductSupplierDisplayed(),"Failure Message: ProductSupplier is not displayed");
		soft.assertTrue(pdtpage.isProductPriceDisplayed(),"Failure Message: ProductPrice is not displayed");
		soft.assertTrue(pdtpage.isProductPurchasePriceDisplayed(),"Failure Message: ProductPurchasePrice is not displayed");
		soft.assertTrue(pdtpage.isProductTaxDisplayed(),"Failure Message: ProductTax is not displayed");
		soft.assertTrue(pdtpage.isProductTaxMethodDisplayed(),"Failure Message: ProductTaxMethod is not displayed");
		soft.assertTrue(pdtpage.isProductUnitDisplayed(),"Failure Message: ProductUnit is not displayed");
		soft.assertTrue(pdtpage.isProductOptionsDisplayed(),"Failure Message: ProductOption is not displayed");
		soft.assertTrue(pdtpage.isProductAlertqtyDisplayed(),"Failure Message: ProductAlertQuantity is not displayed");
		soft.assertTrue(pdtpage.isProductDescriptionDisplayed(),"Failure Message: ProductDescription is not displayed");
		pdtpage.closeProductDetails();
		soft.assertAll();
		
	}
	
	@Test(priority=2,enabled=true)
	public void validateAddProductDetialsWithStockValue() throws InterruptedException
	{
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("0");
		pdtpage.enterProductCode("11012");
		pdtpage.enterProductName("BBQQS");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.selectProductSupplier("Anujith");
		pdtpage.enterProductPurchasePrice("10000");
		pdtpage.enterProductTax("15");
		pdtpage.selectPrdtTaxmethod("0");
		pdtpage.enterProductPrice("10000");
		pdtpage.enterProductUnit("10");
		pdtpage.enterAlertQuantity("30");
		pdtpage.enterProductOption("Good,Taste");
		pdtpage.enterProductDescription("Good Quality,Super");
		pdtpage.submitProductDetails();
			
		pdtpage.selectMNCStoreQuantity("20");
		pdtpage.selectMNCStorePrice("200");
		pdtpage.StoreSubmit();
		
		Thread.sleep(2000);
		
		pdtpage.ProductSearch("11012");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"11012","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQQS","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality,Super","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"15","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"10000.000abc","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=3,enabled=true)
	public void validateAddProductDetialsWithOutStockValues()
	{
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("Service");
		pdtpage.enterProductCode("1110201");
		pdtpage.enterProductName("BBQSSS");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.selectProductSupplier("Anujith");
		pdtpage.enterProductPurchasePrice("1000");
		pdtpage.enterProductTax("10");
		pdtpage.selectPrdtTaxmethod("inclusive");
		pdtpage.enterProductPrice("110");
		pdtpage.enterProductUnit("10");
		pdtpage.enterAlertQuantity("30");
		pdtpage.enterProductOption("Good,Taste");
		pdtpage.enterProductDescription("Good Quality");
		pdtpage.submitProductDetails();
		
		pdtpage.StoreSubmit();
		
		pdtpage.ProductSearch("1110201");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1110201","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQSS","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"15","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"110.000abc","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=4,enabled=true)
	public void ValidateEditProductDetails()
	{
		pdtpage.ProductSearch("3023021");
		pdtpage.editButtonClick();
		pdtpage.editProductType("1");
		pdtpage.editProductCode("2345101");
		pdtpage.editProductName("Chicken");
		pdtpage.editProductCategory("Pizza");
		pdtpage.editProductTax("100");
		pdtpage.editProductTaxMethod("0");
		pdtpage.editProductPrice("25");
		pdtpage.editProductOption("Supertaste");
		pdtpage.editProductDescription("Taste Good,Quality");
		pdtpage.submitProdutEditDetails();
		
		pdtpage.ProductSearch("2345101");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"2345101","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"Chicken","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Taste Good,Quality","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"100","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"25.000 abc","Failure Message: Product Price is not matched");
				
		
		soft.assertAll();
		
	}
	
	
	
	
	@Test
	public void viewProduct()
	{
		pdtpage.ProductSearch("11012");
		pdtpage.viewProductDetails();
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"11012","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQQS","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality,Super","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"15","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"10000.000 abc","Failure Message: Product Price is not matched");
		
		pdtpage.closeProductViewPage();
		soft.assertAll();
	}
	
	
	@Test
	public void validateDeleteProductAction()
	{
		pdtpage.ProductSearch("100012");
		pdtpage.deleteProductDetails();
		pdtpage.ProductSearch("100012");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"No matching records found","Failure Message: Product Code is not matched");
		soft.assertAll();
	}
	
	
	
	@Test
	public void ValidateModifyProductAction()
	{
		pdtpage.ProductSearch("1212");
		pdtpage.ClickModifyButon();
		pdtpage.selectMNCStoreQuantity("20");
		pdtpage.selectMNCStorePrice("200");
		pdtpage.StoreSubmit();
	}*/
	
	@Test
	public void ValidateBarcodeReader() {
		pdtpage.ProductSearch("1212");
		pdtpage.ClickBarCodeReader();
		pdtpage.enterColumnNumberForBarcode("2");
		pdtpage.NumberForBarcode("10");
		pdtpage.submitButnOnBarcode();
		pdtpage.printButnOnBarcode();
	}
	
	
}
