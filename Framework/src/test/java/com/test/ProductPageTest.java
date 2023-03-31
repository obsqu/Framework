package com.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ProductPageTest extends AutomationBase{


	
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ProductPage pdtpage;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	SoftAssert soft=new SoftAssert();
	PropertyUtil property=new PropertyUtil();
	WaitUtils waitutil=new WaitUtils();
	
	CommonDatas comn=new CommonDatas();
	
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
		pdtpage=homepg.navigateToPdtPage();
		
		
		
		/*driver=getDriver();
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		homepg=loginpg.login("admin","password");*/
		
	}
	
	@Test(priority=1,enabled=true)
	
	public void validateElementsonAddProduct()
	{
		comn.ClickOnAddButton();
		//pdtpage.clickOnAddProductButton();
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
		//comn.ClickOnAddButton();
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("0");
		pdtpage.addProductCode("1670");
		pdtpage.addProductName("BBBBQQ");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.selectProductSupplier("Anujith");
		pdtpage.enterProductPurchasePrice("20000");
		pdtpage.addProductTax("25");
		pdtpage.selectProductTaxMethod("1");
		pdtpage.addProductPrice("30000");
		pdtpage.enterProductUnit("20");
		pdtpage.enterAlertQuantity("20");
		pdtpage.addProductOption("GoodTaste");
		pdtpage.addProductDescription("Good TAste,Super");
		pdtpage.submitProductDetails();
		//	comn.ClickOnSubmitDetails();
		pdtpage.enterMNCStoreQuantity("10");
		pdtpage.enterMNCStorePrice("100");
		pdtpage.StoreSubmit();
		
		//Thread.sleep(2000);
		//comn.SearchDetails("1670");
		pdtpage.ProductSearch("1670");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1670","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBBBQQ","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good TAste,Super","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"25","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"30000.000 abc","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=3,enabled=false)
	public void validateAddProductDetialsWithOutStockValues()
	{
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("1");
		pdtpage.addProductCode("1987");
		pdtpage.addProductName("BBQQSSS");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.selectProductSupplier("Anujith");
		pdtpage.enterProductPurchasePrice("1000");
		pdtpage.addProductTax("10");
		pdtpage.selectProductTaxMethod("inclusive");
		pdtpage.addProductPrice("110");
		pdtpage.enterProductUnit("10");
		pdtpage.enterAlertQuantity("30");
		pdtpage.addProductOption("Good,Taste");
		pdtpage.addProductDescription("Good Quality");
		pdtpage.submitProductDetails();
		
		pdtpage.StoreSubmit();
		
		pdtpage.ProductSearch("1987");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1987","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQQSSS","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"10","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"110.000 abc","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=4,enabled=false)
	public void ValidateEditProductDetails()
	{
		pdtpage.ProductSearch("1987");
		pdtpage.editButtonClick();
		pdtpage.selectProductType("1");
		pdtpage.addProductCode("2921");
		pdtpage.addProductName("Chicken");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.addProductTax("100");
		pdtpage.selectProductTaxMethod("0");
		pdtpage.addProductPrice("35");
		pdtpage.addProductOption("Supertaste");
		pdtpage.addProductDescription("Taste Good,Quality");
		pdtpage.submitProdutEditDetails();
		
		pdtpage.ProductSearch("2921");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"2921","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"Chicken","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Taste Good,Quality","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"100","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"35.000 abc","Failure Message: Product Price is not matched");
				
		
		soft.assertAll();
		
	}
	
	@Test(priority=6,enabled=false)
	public void validateDeleteProductAction()
	{
		pdtpage.ProductSearch("987");
		pdtpage.deleteProductDetails();
		pdtpage.ProductSearch("987");
		Assert.assertEquals(pdtpage.getProductCodeFromSearchResults(),"No matching records found","Failure Message: Product Code is not matched");
		
	}
	
	
	/*@Test(priority=5,enabled=true)
	public void ValidateViewProductAction()
	{
		pdtpage.ProductSearch("1212");
		pdtpage.viewProductDetails();
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1212","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQQS","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality,Super","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"15","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"10000.000 abc","Failure Message: Product Price is not matched");
		
		pdtpage.closeProductViewPage();
		soft.assertAll();
	}
	
		
	@Test(priority=7,enabled=true)
	public void ValidateModifyProductStockAction()
	{
		pdtpage.ProductSearch("987");
		pdtpage.ClickModifyButon();
		pdtpage.enterMNCStoreQuantity("20");
		pdtpage.enterMNCStorePrice("200");
		pdtpage.StoreSubmit();
	}
	
	@Test(priority=8,enabled=true)
	public void ValidateBarcodeReader() {
		pdtpage.ProductSearch("1212");
		pdtpage.ClickBarCodeReader();
		pdtpage.enterColumnNumberForBarcode("2");
		pdtpage.NumberForBarcode("10");
		pdtpage.submitButnOnBarcode();
		pdtpage.printButnOnBarcode();
	}*/
	
	
}
