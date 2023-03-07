package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;
import com.utilities.WebPageDropdwnUtils;

public class HomePage {
	
	WebDriver driver;
	WebElementUtils elementutils=new WebElementUtils();
	WebPageDropdwnUtils dropdwn=new WebPageDropdwnUtils();
	BrowserUtils brwsrUtil=new BrowserUtils();
	
	@FindBy(xpath="//span[text()='POS']")
	WebElement pos;
	@FindBy(xpath="//span[text()='Product']")
	WebElement product;
	@FindBy(xpath="//span[text()='Stores']")
	WebElement store;
	@FindBy(xpath="//span[text()='People']")
	WebElement people;
	@FindBy(xpath="//a[@class='dropdown-toggle flat-box waves-effect waves-block']")
	WebElement peopleLink;
	@FindBy(xpath="//span[text()='Waiters']")
	WebElement waiter;
	@FindBy(xpath="//span[text()='Customers']")
	WebElement customer;
	@FindBy(xpath="//span[text()='Suppliers']")
	WebElement supplier;
	@FindBy(xpath="//span[text()='Sales']")
	WebElement sale;
	@FindBy(xpath="//span[text()='Expense']")
	WebElement expense;
	@FindBy(xpath="//span[text()='Categories']")
	WebElement category;
	@FindBy(xpath="//a[@class='dropdown-toggle flat-box waves-effect waves-block']")
	WebElement categorylink;
	@FindBy(xpath="//span[text()='Setting']")
	WebElement setting;
	@FindBy(xpath="//span[text()='Reports']")
	WebElement report;
	@FindBy(xpath="//span[text()='  admin Doe']")
	WebElement admindoe;
	@FindBy(xpath="//i[@class='fa fa-sign-out fa-lg']")
	WebElement logout;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean isPosDisplayed()
	{
		elementutils.clickonTheElement(driver, pos);
		return elementutils.isElementDisplayed(driver,pos);
	}
	
	public boolean isProductDisplayed()
	{
		elementutils.clickonTheElement(driver, product);
		return elementutils.isElementDisplayed(driver,product);
	}
	
	public boolean isStoreDisplayed()
	{
		elementutils.clickonTheElement(driver, store);
		return elementutils.isElementDisplayed(driver,store);
	}
	
	public boolean isPeopleDisplayed()
	{
		elementutils.clickonTheElement(driver, peopleLink);
		return elementutils.isElementDisplayed(driver,people);
	}
	
	public boolean isWaiterDisplayed(int indxVal)
	{
		elementutils.clickonTheElement(driver,peopleLink);
		dropdwn.elememtSelectbyIndex(driver,peopleLink,indxVal);
		return elementutils.isElementDisplayed(driver,waiter);
		
	}
	
	public boolean isCustomerDisplayed(int indxVal)
	{
		elementutils.clickonTheElement(driver,peopleLink);
		dropdwn.elememtSelectbyIndex(driver, peopleLink, indxVal);
		return elementutils.isElementDisplayed(driver,customer);
		
	}
	public boolean isSupplierDisplayed(int indxVal)
	{
		elementutils.clickonTheElement(driver,peopleLink);
		dropdwn.elememtSelectbyIndex(driver, peopleLink, indxVal);
		return elementutils.isElementDisplayed(driver,supplier);
		
	}
	
	public boolean isSaleDisplayed()
	{
		elementutils.clickonTheElement(driver, sale);	
		return elementutils.isElementDisplayed(driver,sale);
	}
	public boolean isExpenseDisplayed()
	{
		elementutils.clickonTheElement(driver, expense);
		return elementutils.isElementDisplayed(driver,expense);
	}
	
	public boolean isCategoryDisplayed()
	{
		elementutils.clickonTheElement(driver, categorylink);
		return elementutils.isElementDisplayed(driver,category);
	}
	
	public boolean isProductCatagoryDisplayed()
	{
		elementutils.clickonTheElement(driver,categorylink);
		
		return elementutils.isElementDisplayed(driver,product);
		
	}
	public boolean isExpenseCatagoryDisplayed()
	{
		elementutils.clickonTheElement(driver,categorylink);
		return elementutils.isElementDisplayed(driver,expense);
		
	}
	
	public boolean isSettingDisplayed()
	{
		elementutils.clickonTheElement(driver, setting);
		return elementutils.isElementDisplayed(driver,setting);
	}
	
	public boolean isReportDisplayed()
	{
		elementutils.clickonTheElement(driver, report);
		return elementutils.isElementDisplayed(driver,report);
	}
	
	public boolean isAdmindoeDisplayed()
	{
		elementutils.clickonTheElement(driver, admindoe);
		return elementutils.isElementDisplayed(driver,admindoe);
	}
	
	public boolean isLogoutDisplayed()
	{
		elementutils.clickonTheElement(driver, logout);
		return elementutils.isElementDisplayed(driver,logout);
	}
	
	/*public void clickPosOnHomePage()
	{
		elementutils.clickonTheElement(driver, pos);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickProductOnHomePage()
	{
		elementutils.clickonTheElement(driver, product);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickStoreOnHomePage()
	{
		elementutils.clickonTheElement(driver, store);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickPeopleOnHomePage()
	{
		elementutils.clickonTheElement(driver, people);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickSaleOnHomePage()
	{
		elementutils.clickonTheElement(driver, sale);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickExpenseOnHomePage()
	{
		elementutils.clickonTheElement(driver, expense);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickCategoryOnHomePage()
	{
		elementutils.clickonTheElement(driver, category);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickSettingOnHomePage()
	{
		elementutils.clickonTheElement(driver, setting);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickreportOnHomePage()
	{
		elementutils.clickonTheElement(driver, report);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}
	public void clickAdminOnHomePage()
	{
		elementutils.clickonTheElement(driver, admindoe);
		brwsrUtil.navigateBacktoPreviousPage(driver);
	}*/
	
	
	public HomePage navigateToPosPage() {
		elementutils.clickonTheElement(driver, pos);
		return new HomePage(driver);
	}
	
   public ProductPage navigateToPdtPage() {
	     elementutils.clickonTheElement(driver, product);
	    return new ProductPage(driver);
	}

   /*public StorePage navigateToStorePage() {
	elementutils.clickonTheElement(driver, pos);
	return new StorePage(driver);
	}
   
   public ProductPage navigateToPdtPage() {
	     elementutils.clickonTheElement(driver, product);
	    return new ProductPage(driver);
	}
   
   public ProductPage navigateToPdtPage() {
	     elementutils.clickonTheElement(driver, product);
	    return new ProductPage(driver);
	}
   
   public ProductPage navigateToPdtPage() {
	     elementutils.clickonTheElement(driver, product);
	    return new ProductPage(driver);
	}*/

}
