package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;
import com.utilities.WebPageDropdwnUtils;

public class ProductPage {
    
	WebDriver driver;
	WebElementUtils elementutil=new WebElementUtils();
	WebPageDropdwnUtils droputil=new WebPageDropdwnUtils();
	
	@FindBy(xpath="//select[@name='Table_length']")
	WebElement show;
	@FindBy(xpath="//input[@id='Supplier']")
	WebElement suplierlist;
	@FindBy(xpath="//input[@id='Producttype']")
	WebElement pdttype;
	@FindBy(xpath="//button[@iclass='btn btn-default']")
	WebElement aplyfilter;
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addpdt;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search;
	
	@FindBy(xpath="//select[@name='type']")
	WebElement type;
	@FindBy(xpath="//input[@name='code']")
	WebElement pdtcode;
	@FindBy(xpath="//input[@id='ProductName']")
	WebElement pdtname;
	@FindBy(xpath="//select[@id='Category']")
	WebElement category;
	@FindBy(xpath="//select[@name='supplier']")
	WebElement supplier;
	@FindBy(xpath="//input[@name='cost']")
	WebElement purchprice;
	@FindBy(xpath="//input[@name='tax']")
	WebElement tax;
	@FindBy(xpath="//select[@name='taxmethod']")
	WebElement taxmethod;
	@FindBy(xpath="//input[@id='Price']")
	WebElement price;
	@FindBy(xpath="//input[@name='unit']")
	WebElement pdtunit;
	@FindBy(xpath="//input[@name='alertqt']")
	WebElement alertqty;
	@FindBy(xpath="//textarea[@id='ProductOptions']")
	WebElement pdtoptin;
	@FindBy(xpath="//input[@name='userfile']")
	WebElement usrFile;
	@FindBy(xpath="//textarea[@id='summernote']")
	WebElement pdtDescription;
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement submit;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement close;
	
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
	
	public void tableEntryisShown(int entryValue)
	{
		droputil.elememtSelectbyIndex(driver,show, entryValue);
	}
	
	public void supplierListShown(String suplierValue) {
		droputil.elememtSelectbyValue(driver,suplierlist,suplierValue);
	}
	
	public void productTypeList(String pdtTypeValue)
	{
		droputil.elememtSelectbyValue(driver, pdttype, pdtTypeValue);
	}
	
	public void isApplyFilterClick()
	{
		elementutil.submittheElement(driver,aplyfilter);
	}
	
	public void isAddProductClick() {
		elementutil.clickonTheElement(driver,addpdt);
	}
	
	public void addProductType(String pdtypeVal)
	{
		
		droputil.elememtSelectbyValue(driver, type,pdtypeVal);
	}
	
	public void addProductCode(String pdtcodeVal)
	{
		elementutil.enteringValuetoElements(driver,pdtcode,pdtcodeVal);
	}
	
	public void addProductName(String pdtnameVal)
	{
		elementutil.enteringValuetoElements(driver,pdtname,pdtnameVal);
	}
	
	public void addProductCategory(String pdCategoryVal)
	{
		droputil.elememtSelectbyValue(driver,category,pdCategoryVal);
	}
	
	public void addProductSupplier(String pdSupplierVal)
	{
		droputil.elememtSelectbyValue(driver,supplier, pdSupplierVal);
	}
	
	public void addPurchasePrice(String purchPriceVal)
	{
		elementutil.cleartheFieldd(driver,purchprice);
		elementutil.enteringValuetoElements(driver,purchprice,purchPriceVal);
	}
	
	public void addProductTax(String pdTaxVal)
	{
		elementutil.enteringValuetoElements(driver,price,pdTaxVal);
	}
	
	public void addPrdtTaxmethod(String taxMethodVal)
	{
		droputil.elememtSelectbyValue(driver,taxmethod,taxMethodVal);
	}
	
	public void addProductPrice(String pdPriceVal)
	{
		
		elementutil.enteringValuetoElements(driver,price,pdPriceVal);
	}
	
	public void addProductUnit(String pdUnitVal)
	{
		elementutil.enteringValuetoElements(driver,pdtunit,pdUnitVal);
	}
	
	public void addAlertQuantity(String AlertQtyVal)
	{
		
		elementutil.enteringValuetoElements(driver, alertqty, AlertQtyVal);
	}
	
	public void addProductOption(String pdOptionVal)
	{
		elementutil.enteringValuetoElements(driver,pdtoptin,pdOptionVal);
	}
	
	public void addProductDescription(String pdtDecrip)
	{
		elementutil.enteringValuetoElements(driver,pdtDescription,pdtDecrip);
	}
	
	public void submitProductDetails()
	{
		elementutil.submittheElement(driver,submit);
	}
	
	public void closeProductDetails()
	{
		elementutil.submittheElement(driver,close);
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
