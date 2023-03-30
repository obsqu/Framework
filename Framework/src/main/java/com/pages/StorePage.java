package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class StorePage {

	WebDriver driver;
	WebElementUtils elementutils=new WebElementUtils();
	
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addStoreButn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement storeName;
	@FindBy(xpath="//input[@id='email']")
	WebElement storeEmailid;
	@FindBy(xpath="//input[@id='StorePhone']")
	WebElement storePhoneNumbr;
	@FindBy(xpath="//input[@id='Country']")
	WebElement storeCountry;
	@FindBy(xpath="//input[@id='City']")
	WebElement storeCity;
	@FindBy(xpath="//input[@id='Adresse']")
	WebElement storeAddress;
	@FindBy(xpath="//input[@id='CustomeFooter']")
	WebElement storeCustomFootr;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement storeSubmitBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement storeDeleteBtn;
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement storeEditBtn;
	@FindBy(xpath="//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	WebElement submitEditBtn;
	@FindBy(xpath="(//a[@class='btn btn-default'])[3]")
	WebElement storeManageTblButn;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement storename_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement storeemailid_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement storephoneno_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement storecountry_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	WebElement storecity_searchresult;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement storeSearch;
	
	public  StorePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickOnAddStoreButton()
	{
		elementutils.clickonTheElement(driver,addStoreButn);
	}
	public void clickOnStoreName()
	{
		elementutils.clickonTheElement(driver,storeName);
	}
	public void clickOnStoreMail()
	{
		elementutils.clickonTheElement(driver,storeEmailid);
	}
	public void enterValueToStoreName(String storeNamevl)
	{
		elementutils.cleartheFieldd(driver,storeName);
		elementutils.enteringValuetoElements(driver,storeName,storeNamevl);
	}
	public void enterValueToStoreEmailID(String storeEmailvl)
	{
		elementutils.cleartheFieldd(driver,storeEmailid);
		elementutils.enteringValuetoElements(driver,storeEmailid,storeEmailvl);
	}
	public void enterValueToStorePhoneNumber(String storePhonevl)
	{
		elementutils.cleartheFieldd(driver,storePhoneNumbr);
		elementutils.enteringValuetoElements(driver,storePhoneNumbr,storePhonevl);
	}
	public void enterValueToStoreCountryr(String storeCountryvl)
	{
		elementutils.cleartheFieldd(driver,storeCountry);
		elementutils.enteringValuetoElements(driver,storeCountry,storeCountryvl);
	}
	public void enterValueToStoreCity(String storeCityvl)
	{
		elementutils.cleartheFieldd(driver,storeCity);
		elementutils.enteringValuetoElements(driver,storeCity,storeCityvl);
	}
	public void enterValueToStoreAddress(String storeAddresvl)
	{
		elementutils.cleartheFieldd(driver,storeAddress);
		elementutils.enteringValuetoElements(driver,storeAddress,storeAddresvl);
	}
	public void enterValueToStoreCustom(String storeCustmFutvl)
	{
		elementutils.cleartheFieldd(driver,storeCustomFootr);
		elementutils.enteringValuetoElements(driver,storeCustomFootr,storeCustmFutvl);
	}
	
	
	public void submitStoreValues()
	{
		elementutils.clickonTheElement(driver,storeSubmitBtn);
	}
	
	public void searchStoreLink(String searchVal)
	{
		elementutils.enteringValuetoElements(driver,storeSearch,searchVal);
	}
	
	public String getStoreNameFromSearchResults()
	{
		return elementutils.getingtheText(driver,storename_searchresult);
	}
	public String getStoreEmailidFromSearchResults()
	{
		return elementutils.getingtheText(driver,storeemailid_searchresult);
	}
	public String getStorePhoneNoFromSearchResults()
	{
		return elementutils.getingtheText(driver,storephoneno_searchresult);
	}
	public String getStoreCountryFromSearchResults()
	{
		return elementutils.getingtheText(driver,storecountry_searchresult);
	}
	public String getStoreCityFromSearchResults()
	{
		return elementutils.getingtheText(driver,storecity_searchresult);
	}
	
	public void deleteStoreDetails() {
		elementutils.clickonTheElement(driver,storeDeleteBtn);
	}
	
	public void editStoreDetails() {
		elementutils.clickonTheElement(driver,storeEditBtn);
	}
	
	
	public void submitEditDetails() {
		elementutils.clickonTheElement(driver,submitEditBtn);
	}
	
	public void ManageStoreTables() {
		elementutils.clickonTheElement(driver,storeManageTblButn);
	}
	
}
