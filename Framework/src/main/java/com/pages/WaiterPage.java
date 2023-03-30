package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtils;
import com.utilities.WebElementUtils;

public class WaiterPage {
	
	
	WebDriver driver;
	WebElementUtils elementutil=new WebElementUtils();
	GenericUtils droputil=new GenericUtils();
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addWaiterButn;
	
	@FindBy(xpath="//input[@id='WaiterName']")
	WebElement waiterName;
	@FindBy(xpath="//input[@id='WaiterPhone']")
	WebElement waiterPhoneNo;
	@FindBy(xpath="//input[@id='WaiterEmail']")
	WebElement waiterEmail;
	@FindBy(xpath="//select[@name='store_id']")
	WebElement waiterStore;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement waiterSubmitBtn;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement waiterCloseBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement waiterDeleteBtn;
	@FindBy(xpath="//a[text()='Yes, delete it!']")
	WebElement yesDeleteWaiter;
	
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement waiterEditBtn;
	@FindBy(xpath="//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	WebElement submitEditBtn;
	
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement waitername_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement waiterphonenum_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement waiteremail_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement waiterstore_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	WebElement waitercreateddate_searchresult;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement waiterSearch;
	
	
	public WaiterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void ClickOnAddWaiterButton()
	{
		elementutil.clickonTheElement(driver,addWaiterButn);
	}
	
	public void clickOnWaitername() {
		elementutil.clickonTheElement(driver,waiterName);
	}
	public void enterValueForWaiterName(String waiterNamevl)
	{
		
		elementutil.cleartheFieldd(driver,waiterName);
		elementutil.enteringValuetoElements(driver,waiterName,waiterNamevl);
	}
	public void enterValueForWaiterPhone(String waiterPhonevl)
	{
		elementutil.cleartheFieldd(driver,waiterPhoneNo);
		elementutil.enteringValuetoElements(driver,waiterPhoneNo,waiterPhonevl);
	}
	public void enterValueForWaiterEmailId(String waiteremailvl)
	{
		elementutil.cleartheFieldd(driver,waiterEmail);
		elementutil.enteringValuetoElements(driver,waiterEmail,waiteremailvl);
	}
	 public void selectValueForWaiterStore(String storeValue)
		{
			elementutil.cleartheFieldd(driver,waiterStore);
			droputil.elememtSelectbyVisibleText(driver,waiterStore,storeValue);
			//droputil.elememtSelectbyValue(driver,waiterStore,storeValue);
		}
	 public void submitWaiterValues() {
		 elementutil.clickonTheElement(driver,waiterSubmitBtn);
	 }
	 
	 public void searchWaiterLink(String searchVal)
		{
			elementutil.enteringValuetoElements(driver,waiterSearch,searchVal);
		}
		
	 public String getWaiterNameFromSearchResult() {
		 return elementutil.getingtheText(driver,waitername_searchresult);
	 }
	 public String getWaiterPhoneNumberFromSearchResult() {
		 return elementutil.getingtheText(driver,waiterphonenum_searchresult);
	 }
	 public String getWaiterEmailidFromSearchResult() {
		 return elementutil.getingtheText(driver,waiteremail_searchresult);
	 }
	 public String getWaiterStoreFromSearchResult() {
		 return elementutil.getingtheText(driver,waiterstore_searchresult);
	 }
	 public String getWaiterCreatedDateandTimeFromSearchResult() {
		 return elementutil.getingtheText(driver,waitercreateddate_searchresult);
	 }
	 
	 public void clickDeleteWaiterDataButton() {
		 elementutil.clickonTheElement(driver,waiterDeleteBtn);
		 elementutil.clickonTheElement(driver,yesDeleteWaiter);
	 }
	 
	 public void clickEditWaiterDataButton() {
		 
		 elementutil.clickonTheElement(driver,waiterEditBtn);
	 }

}
