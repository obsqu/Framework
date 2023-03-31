package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtils;
import com.utilities.WebElementUtils;

public class ExpensePage {

	WebDriver driver;
	WebElementUtils elementutil=new WebElementUtils();
	GenericUtils droputil=new GenericUtils();
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addExpenseButn;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchBtn;
	
	@FindBy(xpath="//input[@id='Date']")
	WebElement expenseDate;
	@FindBy(xpath="//input[@id='Reference']")
	WebElement expenseReference;
	@FindBy(xpath="//select[@id='Category']")
	WebElement expenseCatgry;
	@FindBy(xpath="//select[@id='store_id']")
	WebElement expenseStr;
	@FindBy(xpath="//input[@id='Amount']")
	WebElement expenseAmount;
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement expenseNote;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement expenseSubmitBtn;
	@FindBy(xpath="//button[text()='Close']")
	WebElement expenseClosBtn;
	
	public ExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void ClickOnAddExpenseButton()
	{
		elementutil.clickonTheElement(driver,addExpenseButn);
	}
	
	
	public void enterValueForExpenseDate(String dateVal)
	{
		
		elementutil.cleartheFieldd(driver,expenseDate);
		elementutil.enteringValuetoElements(driver,expenseDate,dateVal);
	}
	public void enterValueForExpenseReference(String expnsRefrVal)
	{
		elementutil.cleartheFieldd(driver,expenseReference);
		elementutil.enteringValuetoElements(driver,expenseReference,expnsRefrVal);
	}
	 public void selectValueForExpenseCategory(String catgryValue)
		{
			elementutil.cleartheFieldd(driver,expenseCatgry);
			droputil.elememtSelectbyVisibleText(driver,expenseCatgry,catgryValue);
			//droputil.elememtSelectbyValue(driver,waiterStore,storeValue);
		}
	 public void selectValueForExpenseStore(String storeValue)
		{
			elementutil.cleartheFieldd(driver,expenseStr);
			droputil.elememtSelectbyVisibleText(driver,expenseStr,storeValue);
			
		}
	 public void submitWaiterValues() {
		 elementutil.clickonTheElement(driver,expenseSubmitBtn);
	 }
	 
	 public void searchWaiterLink(String searchVal)
		{
			elementutil.enteringValuetoElements(driver,SearchBtn,searchVal);
		}
		
	 /*public String getWaiterNameFromSearchResult() {
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
*/
}
