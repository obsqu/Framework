package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class ProductCategoryPage {
	
	WebDriver driver;
	WebElementUtils elementutil=new WebElementUtils();
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addCategoryButn;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchBtn;
	
	@FindBy(xpath="//input[@id='CategoryName']")
	WebElement categryName;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement catgrySubmitBtn;
	@FindBy(xpath="//button[text()='Close']")
	WebElement catgryClosBtn;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement catgryname_searchresult;
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement catgryDeleteBtn;
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement yesDltBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement catgryEditBtn;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement catgrySubmitEditBtn;
	
	public ProductCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean isCategoryNameDisplayed()
	{
		boolean flag= elementutil.isElementDisplayed(driver,categryName);
		return flag;
	}

	public void ClickOnAddCategoryButton()
	{
		elementutil.clickonTheElement(driver,addCategoryButn);
	}
	public void ClickOnCloseButton()
	{
		elementutil.clickonTheElement(driver,catgryClosBtn);
	}
	 public void ClickOnSubmitCategoryValues() {
		 elementutil.clickonTheElement(driver,catgrySubmitBtn);
	 }
	public void ClickOnCategoryName() {
		elementutil.clickonTheElement(driver,categryName);
	}
	
	public void enterValueForCategryName(String ctgrynmVal)
	{
		
		elementutil.cleartheFieldd(driver,categryName);
		elementutil.enteringValuetoElements(driver,categryName,ctgrynmVal);
	}
	
	 public String getCategryNameFromSearchResult() {
		 return elementutil.getingtheText(driver,catgryname_searchresult);
	 }
	 
	 public void ClickOnSearchCategoryLink(String searchVal)
		{
		 elementutil.cleartheFieldd(driver,SearchBtn);
			elementutil.enteringValuetoElements(driver,SearchBtn,searchVal);
		}
	 
	 public void ClickOnCategoryEditButton() {
		 elementutil.clickonTheElement(driver,catgryEditBtn);
	 }
	 
	 public void ClickOnSubmitEditButton() {
		 elementutil.clickonTheElement(driver,catgrySubmitEditBtn);
	 }
	 
	 public void ClickOnDeleteButton() {
		 elementutil.clickonTheElement(driver,catgryDeleteBtn);
		 elementutil.clickonTheElement(driver,yesDltBtn);
	 }
	
}
