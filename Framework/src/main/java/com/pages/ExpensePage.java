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
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement expensedate_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement expensereferense_searchresult;	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement expensestore_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement expensecategry_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	WebElement expenseamount_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[6]")
	WebElement expenscreated_searchresult;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement expenseDeleteBtn;
	@FindBy(xpath="//button[text()='Yes, delete it!']")
	WebElement yesDltBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement expenseEditBtn;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement expenseSubmitEditBtn;
	
	public ExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean isExpensedateDisplayed()
	{
		boolean flag= elementutil.isElementDisplayed(driver,expenseDate);
		return flag;
	}
	
	public boolean isExpenseRefernseDisplayed()
	{
		
		boolean flag=elementutil.isElementDisplayed(driver,expenseReference);
		return flag;
	}
	
	public boolean isExpenseCategoryDisplayed()
	{
		
		boolean flag= elementutil.isElementDisplayed(driver,expenseCatgry);
		return flag;
	}
	
	public boolean isExpenseStoreDisplayed()
	{
		
		boolean flag= elementutil.isElementDisplayed(driver,expenseStr);
		return flag;
	}
	
	public boolean isExpenseAmountDisplayed()
	{
			
		boolean flag=elementutil.isElementDisplayed(driver,expenseAmount);
		return flag;
	}
	public boolean isExpenseNoteDisplayed()
	{
		
		boolean flag= elementutil.isElementDisplayed(driver,expenseNote);
		return flag;
	}
	
	public void ClickOnCloseButton()
	{
		elementutil.clickonTheElement(driver,expenseClosBtn);
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
			
		}
	 public void selectValueForExpenseStore(String storeValue)
		{
			elementutil.cleartheFieldd(driver,expenseStr);
			droputil.elememtSelectbyVisibleText(driver,expenseStr,storeValue);
			
		}
	 public void enterValueForExpenseAmount(String amntVal) {
		 elementutil.cleartheFieldd(driver,expenseAmount);
		 elementutil.enteringValuetoElements(driver,expenseAmount, amntVal);
	 }
	 public void enterValueForExpenseNote(String noteVal) {
		 elementutil.cleartheFieldd(driver,expenseNote);
		 elementutil.enteringValuetoElements(driver,expenseNote, noteVal);
	 }
	 
	 public void ClickOnSubmitExpenseValues() {
		 elementutil.clickonTheElement(driver,expenseSubmitBtn);
	 }
	 
	 public void ClickOnSearchExpenseLink(String searchVal)
		{
		 elementutil.cleartheFieldd(driver,SearchBtn);
			elementutil.enteringValuetoElements(driver,SearchBtn,searchVal);
		}
		
	 public String getExpenseDateFromSearchResult() {
		 return elementutil.getingtheText(driver,expensedate_searchresult);
	 }
	 public String getExpenseReferenseFromSearchResult() {
		 return elementutil.getingtheText(driver,expensereferense_searchresult);
	 }
	 public String getExpenseAmountFromSearchResult() {
		 return elementutil.getingtheText(driver,expenseamount_searchresult);
	 }
	 public String getExpenseCategoryFromSearchResult() {
		 return elementutil.getingtheText(driver,expensecategry_searchresult);
	 }
	 public String getExpenseStoreFromSearchResult() {
		 return elementutil.getingtheText(driver,expensestore_searchresult);
	 }
	 public String getExpenseCretatorFromSearchResult() {
		 return elementutil.getingtheText(driver,expenscreated_searchresult);
	 }
	 
	 public void ClickOnExpenseEditButton() {
		 elementutil.clickonTheElement(driver,expenseEditBtn);
	 }
	 
	 public void ClickOnSubmitEditButton() {
		 elementutil.clickonTheElement(driver,expenseSubmitEditBtn);
	 }
	 
	 public void ClickOnDeleteButton() {
		 elementutil.clickonTheElement(driver,expenseDeleteBtn);
		 elementutil.clickonTheElement(driver,yesDltBtn);
	 }

}
