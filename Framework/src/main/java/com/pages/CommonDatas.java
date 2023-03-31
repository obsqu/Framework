package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class CommonDatas {
	
	WebDriver driver;
	WebElementUtils elementUtils=new WebElementUtils();
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addButon;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitButon;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchBtn;
	
	
	public void ClickOnAddButton() {
		
		elementUtils.clickonTheElement(driver,addButon);
	}

	public void ClickOnSubmitDetails() {
		elementUtils.clickonTheElement(driver,submitButon);
	}
	
	public void ClickOnSearchDetails(String value)
	{
		elementUtils.enteringValuetoElements(driver,SearchBtn, value);
		
	}
}
