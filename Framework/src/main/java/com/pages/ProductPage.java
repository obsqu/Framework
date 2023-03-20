package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;
import com.utilities.GenericUtils;

public class ProductPage {
    
	WebDriver driver;
	WebElementUtils elementutil=new WebElementUtils();
	GenericUtils droputil=new GenericUtils();
	
	@FindBy(xpath="//span[text()='Product']")
	WebElement productlink;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addpdt;
		
	@FindBy(xpath="//select[@id='Type']")
	WebElement pdtype;
	@FindBy(xpath="//input[@name='code']")
	WebElement pdtcode;
	@FindBy(xpath="//input[@id='ProductName']")
	WebElement pdtname;
	@FindBy(xpath="//select[@id='Category']")
	WebElement pdtcategory;
	@FindBy(xpath="//select[@name='supplier']")
	WebElement pdtsupplier;
	@FindBy(xpath="//input[@id='PurchasePrice']")
	WebElement pdtpurchsprice;
	@FindBy(xpath="//input[@id='Tax']")
	WebElement pdttax;
	@FindBy(xpath="//select[@id='taxType']")
	WebElement pdttaxmethod;
	@FindBy(xpath="//input[@id='Price']")
	WebElement pdtprice;
	@FindBy(xpath="//input[@id='Unit']")
	WebElement pdtunit;
	@FindBy(xpath="//input[@id='AlertQt']")
	WebElement pdtalertqty;
	@FindBy(xpath="//textarea[@id='ProductOptions']")
	WebElement pdtoptin;
	@FindBy(xpath="//input[@name='userfile']")
	WebElement pdtimage;
	@FindBy(xpath="//textarea[@name='description']")
	WebElement pdtDescription;
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement pdtsubmit;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement pdtclose;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement prdtsearch;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement productcode_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement productname_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement productcategory_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement productdescription_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	WebElement producttax_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[6]")
	WebElement productprice_searchresult;
	@FindBy(xpath="(//input[@id='quantity'])[1]")
	WebElement MNCstoreQuantity;
	@FindBy(xpath="(//input[@id='pricestr'])[1]")
	WebElement MNCstorePrice;
	@FindBy(xpath="(//button[text()='submit'])[2]")
	WebElement storeClose;
	
	
	@FindBy(xpath="//a[@class='btn btn-default'][1]")
	WebElement crossButn;
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement deleteButn;
	@FindBy(xpath="//a[@class='btn btn-default'][2]")
	WebElement viewButn;
	@FindBy(xpath="//button[@class='btn btn-default hiddenpr']")
	WebElement closeOnView;
	@FindBy(xpath="//a[@class='btn btn-default'][3]")
	WebElement editButn;
	@FindBy(xpath="//button[@class='btn btn-default float-right']")
	WebElement backOnEdit;
	@FindBy(xpath="//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	WebElement submitOnEdit;
	
	
	
	public  ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean isProductLinkisDisplayed() {
		
		 boolean flag=elementutil.isElementDisplayed(driver,productlink);
		 return flag;
	}
    public boolean isAddProductDisplayed() {
		
		boolean flag=elementutil.isElementDisplayed(driver,addpdt);
		return flag;
	}
	
	public void clickOnAddProductButton() {
		elementutil.clickonTheElement(driver,addpdt);
	}
	
	 public boolean isProductTypeDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtype);
			return flag;
	}
	 public boolean isProductCodeDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtcode);
			return flag;
	}
	 public boolean isProductNameDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtname);
			return flag;
	}
	 public boolean isProductCategoryDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtcategory);
			return flag;
	}
	 public boolean isProductSupplierDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtsupplier);
			return flag;
	}
	 public boolean isProductPurchasePriceDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtpurchsprice);
			return flag;
	}
	 public boolean isProductTaxDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdttax);
			return flag;
	}
	 public boolean isProductTaxMethodDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdttaxmethod);
			return flag;
	}
	 public boolean isProductPriceDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtprice);
			return flag;
	}
	 public boolean isProductUnitDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtunit);
			return flag;
	}
	 public boolean isProductAlertqtyDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtalertqty);
			return flag;
	}
	 public boolean isProductOptionsDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtoptin);
			return flag;
	}
	 public boolean isProductImageinputDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtimage);
			return flag;
	}
	 public boolean isProductDescriptionDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtDescription);
			return flag;
	}
	 public boolean isProductSubmitDisplayed() {
			
			boolean flag=elementutil.isElementDisplayed(driver,pdtsubmit);
			return flag;
	}
	 
	public void selectProductType(String pdtypeVal)
	{
		
		droputil.elememtSelectbyValue(driver, pdtype,pdtypeVal);
	}
	
	public void enterProductCode(String pdtcodeVal)
	{
		elementutil.enteringValuetoElements(driver,pdtcode,pdtcodeVal);
		
	}
	
	public void enterProductName(String pdtnameVal)
	{
		elementutil.enteringValuetoElements(driver,pdtname,pdtnameVal);
	}
	
	public void selectProductCategory(String pdCategoryVal)
	{
		droputil.elememtSelectbyValue(driver,pdtcategory,pdCategoryVal);
	}
	
	public void selectProductSupplier(String pdSupplierVal)
	{
		droputil.elememtSelectbyValue(driver,pdtsupplier, pdSupplierVal);
	}
	
	public void enterProductPurchasePrice(String purchPriceVal)
	{
		
		elementutil.enteringValuetoElements(driver,pdtpurchsprice,purchPriceVal);
	}
	
	public void enterProductTax(String pdTaxVal)
	{
		elementutil.enteringValuetoElements(driver,pdttax,pdTaxVal);
	}
	
	public void selectPrdtTaxmethod(String taxMethodVal)
	{
		droputil.elememtSelectbyValue(driver,pdttaxmethod,taxMethodVal);
	}
	
	public void enterProductPrice(String pdPriceVal)
	{
		
		elementutil.enteringValuetoElements(driver,pdtprice,pdPriceVal);
	}
	
	public void enterProductUnit(String pdUnitVal)
	{
		elementutil.enteringValuetoElements(driver,pdtunit,pdUnitVal);
	}
	
	public void enterAlertQuantity(String AlertQtyVal)
	{
		
		elementutil.enteringValuetoElements(driver, pdtalertqty, AlertQtyVal);
	}
	
	public void enterProductOption(String pdOptionVal)
	{
		elementutil.enteringValuetoElements(driver,pdtoptin,pdOptionVal);
	}
	public void inputProductImage(String imgUrl)
	{
		elementutil.enteringValuetoElements(driver,pdtimage,imgUrl);
	}
	public void enterProductDescription(String pdtDecrip)
	{
		elementutil.enteringValuetoElements(driver,pdtDescription,pdtDecrip);
	}
	
	public void submitProductDetails()
	{
		elementutil.clickonTheElement(driver,pdtsubmit);
	}
	
	public void closeProductDetails()
	{
		elementutil.clickonTheElement(driver,pdtclose);
	}
	
	public String ProductSearch(String name)
	{
		elementutil.enteringValuetoElements(driver,prdtsearch, name);
		return name;
	}
	public String getProductCodeFromSearchResults()
	{
		return elementutil.getingtheText(driver,productcode_searchresult);
	}
	public String getProductNameFromSearchResults()
	{
		return elementutil.getingtheText(driver,productname_searchresult);
	}
	public String getProductCategoryFromSearchResults()
	{
		return elementutil.getingtheText(driver,productcategory_searchresult);
	}
	public String getProductDescriptionFromSearchResults()
	{
		return elementutil.getingtheText(driver,productdescription_searchresult);
	}
	public String getProductTaxFromSearchResults()
	{
		return elementutil.getingtheText(driver,producttax_searchresult);
	}
	public String getProductPriceFromSearchResults()
	{
		return elementutil.getingtheText(driver,productprice_searchresult);
	}
	public void selectMNCStoreQuantity(String mncstrqty)
	{
		droputil.elememtSelectbyValue(driver,MNCstoreQuantity, mncstrqty);
	}
	public void selectMNCStorePrice(String mncstrprice)
	{
		droputil.elememtSelectbyValue(driver,MNCstorePrice, mncstrprice);
	}
	public void StoreSubmit()
	{
		elementutil.clickonTheElement(driver,storeClose);
	}

	public void deleteProductDetails()
	{
		elementutil.clickonTheElement(driver,crossButn);
		elementutil.clickonTheElement(driver,deleteButn);
	}
	
	public void viewProductDetails()
	{
		elementutil.clickonTheElement(driver,viewButn);
		elementutil.clickonTheElement(driver,closeOnView);
	}

	
}
