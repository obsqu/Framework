package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class CustomerPage {
	
	WebDriver driver;
	WebElementUtils elementUtils=new WebElementUtils();
	
	
	//@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	//WebElement addCustomerBtn;
	
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement customerName;
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement customerPhoneNumber;
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement customerEmailId;
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement customerDiscount;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement submitCustomerDetail;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement cutomername_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement customerphonenum_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement customeremail_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement customerdiscount_searchresult;
	
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement customerDeleteBtn;
	@FindBy(xpath="//a[text()='Yes, delete it!']")
	WebElement yesDeleteWaiter;
	
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement customrEditBtn;
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement submitEditBtn;
	
	public  CustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterValueForCustomerName(String custmNameVal) {
		
		elementUtils.enteringValuetoElements(driver,customerName,custmNameVal);
	}
   public void enterValueForCustomerPhoneNumber(String custmPhoneVal) {
		
		elementUtils.enteringValuetoElements(driver,customerPhoneNumber,custmPhoneVal);
	}
    public void enterValueForCustomerMail(String custmMailVal) {
	
	elementUtils.enteringValuetoElements(driver,customerEmailId,custmMailVal);
    }
    public void enterValueForCustomerDiscount(String custmDisctVal) {
		
		elementUtils.enteringValuetoElements(driver,customerDiscount,custmDisctVal);
	}
    
    public void ClickSubmitCustomerDetails() {
    	elementUtils.clickonTheElement(driver,submitCustomerDetail);
    }
    
    public String getCustomerNameFromSearchResult() {
		 return elementUtils.getingtheText(driver,cutomername_searchresult);
	 }
	 public String getCustomerPhoneNumberFromSearchResult() {
		 return elementUtils.getingtheText(driver,customerphonenum_searchresult);
	 }
	 public String getCustomerEmailidFromSearchResult() {
		 return elementUtils.getingtheText(driver,customeremail_searchresult);
	 }
	 public String getCustomerDiscountFromSearchResult() {
		 return elementUtils.getingtheText(driver,customerdiscount_searchresult);
	 }
	 
	 
	 public void clickDeleteCustomerDataButton() {
		 elementUtils.clickonTheElement(driver,customerDeleteBtn);
		 elementUtils.clickonTheElement(driver,yesDeleteWaiter);
	 }
	 
	 public void clickEditCustomerDataButton() {
		 
		 elementUtils.clickonTheElement(driver,customrEditBtn);
	 }
	 
public void clickSubmitEditCustmrDetails() {
		 
		 elementUtils.clickonTheElement(driver,submitEditBtn);
	 }
	
	
}
