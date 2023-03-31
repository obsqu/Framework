package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtils;
import com.utilities.WebElementUtils;

public class SupplierPage {
	
	WebDriver driver;
	WebElementUtils elementutil=new WebElementUtils();
	GenericUtils droputil=new GenericUtils();
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addCustomerBtn;
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement submitCustomerDetail;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchBtn;
	
		
	@FindBy(xpath="//input[@name='name']")
	WebElement suplierName;
	@FindBy(xpath="//input[@id='SupplierPhone']")
	WebElement suplierPhone;
	@FindBy(xpath="//input[@id='SupplierEmail']")
	WebElement suplierEmail;
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement suplierNote;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement suplrname_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement suplrphonenum_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement suplremail_searchresult;
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement suplircreateddate_searchresult;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement suplirDeleteBtn;
	@FindBy(xpath="//a[text()='Yes, delete it!']")
	WebElement yesDeleteSuplr;
	
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement suplirEditBtn;
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement submitEditBtn;
	
	
	public  SupplierPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnSupplierName() {
		elementutil.clickonTheElement(driver,suplierName);
	}
	public void enterSupplierName(String supliernmValue)
	{
		elementutil.cleartheFieldd(driver,suplierName);
		elementutil.enteringValuetoElements(driver,suplierName, supliernmValue);
	}
	public void enterSupplierPhone(String suplirPhonValue)
	{
		elementutil.cleartheFieldd(driver,suplierPhone);
		elementutil.enteringValuetoElements(driver,suplierPhone, suplirPhonValue);
	}
	public void enterSupplierMail(String suplierMailValue)
	{
		elementutil.cleartheFieldd(driver,suplierEmail);
		elementutil.enteringValuetoElements(driver,suplierEmail, suplierMailValue);
	}
	public void enterSupplierNote(String suplirNotValue)
	{
		elementutil.cleartheFieldd(driver,suplierNote);
		elementutil.enteringValuetoElements(driver,suplierNote, suplirNotValue);
	}
	
	
	
	public String getSuplierNameFromSearchResult() {
		 return elementutil.getingtheText(driver,suplrname_searchresult);
	 }
	 public String getSuplierPhoneNumberFromSearchResult() {
		 return elementutil.getingtheText(driver,suplrphonenum_searchresult);
	 }
	 public String getSuplierEmailidFromSearchResult() {
		 return elementutil.getingtheText(driver,suplremail_searchresult);
	 }
	 
	 public void clickDeleteSuplirDataButton() {
		 elementutil.clickonTheElement(driver,suplirDeleteBtn);
		 elementutil.clickonTheElement(driver,yesDeleteSuplr);
	 }
	 
	 public void clickEditSuplirDataButton() {
		 
		 elementutil.clickonTheElement(driver,suplirEditBtn);
	 }
	 
	 public void clickEditSubmitBtn() {
		 elementutil.clickonTheElement(driver,submitEditBtn);
	 }
	 public void ClickOnAddButton() {
	 		
	 		elementutil.clickonTheElement(driver,addCustomerBtn);
	 	}

	 	public void ClickOnSubmitDatas() {
	 		elementutil.clickonTheElement(driver,submitCustomerDetail);
	 	}
	 	public void ClickOnSearchDetails(String value)
		{
			elementutil.enteringValuetoElements(driver,SearchBtn, value);
			
		}
	

}
