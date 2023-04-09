package com.test;

import java.io.IOException;
import java.time.Duration;
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
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
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
	ExcelUtils excelutil;
	CommonDatas comn=new CommonDatas();
	
	@BeforeMethod
	public void preRun() throws IOException
	{
		//excelutil=new ExcelUtils("RestaurantDatas.xlsx");
        driver=getDriver();
		
		Properties allProp=property.getAllProperties("config.properties");
		String site=allProp.getProperty("url");
		brwsrUtil.launchUrl(driver,site);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
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
	
	public void validateElementsonAddProduct() throws Exception
	{
		//comn.ClickOnAddButton();
		pdtpage.clickOnAddProductButton();
		
		soft.assertTrue(pdtpage.isAddProductDisplayed(),"Failure Message: addProduct is not displayed");
		
		waitutil.waitForElementToBeClickable(driver,pdtpage.pdtype,20);
		
		soft.assertTrue(pdtpage.isProductTypeDisplayed(),"Failure Message: ProductType is not displayed");
		
		waitutil.waitForElementToBeClickable(driver,pdtpage.pdtcode,20);
		
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
	public void validateAddProductDetialsWithStockValue() throws InterruptedException, IOException
	{
		//comn.ClickOnAddButton();
		/*String pdtType=excelutil.readStringData("Products",2,1);
		String pdtCode=excelutil.readStringData("Products",2,2);
		String pdtName=excelutil.readStringData("Products",2,3);
		String pdtCategry=excelutil.readStringData("Products",2,4);
		String pdtSuplier=excelutil.readStringData("Products",2,5);
		
		String pdtPurchPrice=excelutil.readStringData("Products",2,6);
		String pdtTax=excelutil.readStringData("Products",2,7);
		String pdtTaxMethd=excelutil.readStringData("Products",2,8);
		String pdtPrice=excelutil.readStringData("Products",2,9);
		String pdtUnit=excelutil.readStringData("Products",2,10);
		
		String pdtAlrtQty=excelutil.readStringData("Products",2,11);
		String pdtOptn=excelutil.readStringData("Products",2,12);
		String pdtDescptn=excelutil.readStringData("Products",2,13);*/
		
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("Standard");
		pdtpage.addProductCode("1670");
		pdtpage.addProductName("BBBBQQ");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.selectProductSupplier("Anujith");
		pdtpage.enterProductPurchasePrice("20000");
		pdtpage.addProductTax("25");
		pdtpage.selectProductTaxMethod("exclusive");
		pdtpage.addProductPrice("30000");
		pdtpage.enterProductUnit("20");
		pdtpage.enterAlertQuantity("20");
		pdtpage.addProductOption("GoodTaste");
		pdtpage.addProductDescription("Good TAste,Super");
		waitutil.waitForElementToBeClickable(driver,pdtpage.addpdt,20);
		pdtpage.submitProductDetails();
		//	comn.ClickOnSubmitDetails();
		waitutil.waitForElementToBeClickable(driver,pdtpage.MNCstoreQuantity,20);
		pdtpage.enterMNCStoreQuantity("10");
		waitutil.waitForElementToBeClickable(driver,pdtpage.MNCstorePrice,20);
		pdtpage.enterMNCStorePrice("100");
		waitutil.waitForElementToBeClickable(driver,pdtpage.storeSubmitonProduct,20);
		pdtpage.StoreSubmit();
		
		
		//comn.SearchDetails("1670");
		brwsrUtil.refreshPage(driver);
		pdtpage.ProductSearch("1670");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1670","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBBBQQ","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good TAste,Super","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"25","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"30000.000 abc","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=3,enabled=true)
	public void validateAddProductDetialsWithOutStockValues()
	{
		pdtpage.clickOnAddProductButton();
		pdtpage.selectProductType("Service");
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
		
		waitutil.waitForElementToBeClickable(driver,pdtpage.addpdt,20);
		pdtpage.StoreSubmit();
		waitutil.waitForElementToBeClickable(driver,pdtpage.storeSubmitonProduct,20);
		brwsrUtil.refreshPage(driver);
		pdtpage.ProductSearch("1987");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1987","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"BBQQSSS","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good Quality","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"10","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"110.000 abc","Failure Message: Product Price is not matched");
		soft.assertAll();
		
	}
	
	@Test(priority=4,enabled=true)
	public void ValidateEditProductDetails()
	{
		pdtpage.ProductSearch("786");
		pdtpage.editButtonClick();
		pdtpage.selectProductType("Service");
		pdtpage.addProductCode("1675");
		pdtpage.addProductName("Broasted");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.addProductTax("30");
		pdtpage.selectProductTaxMethod("exclusive");
		pdtpage.addProductPrice("70");
		pdtpage.addProductOption("Supertaste");
		pdtpage.addProductDescription("Good,Quality");
		pdtpage.submitProdutEditDetails();
		
		
		pdtpage.ProductSearch("1675");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(),"1675","Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(),"Broasted","Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),"Pizza","Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(),"Good,Quality","Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),"30","Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(),"70.000 abc","Failure Message: Product Price is not matched");
				
		
		soft.assertAll();
		
	}
	
	@Test(priority=6,enabled=true)
	public void validateDeleteProductAction()
	{
		pdtpage.ProductSearch("1987");
		pdtpage.deleteProductDetails();
		pdtpage.ProductSearch("1987");
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
