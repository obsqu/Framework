package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class StorePage {

	WebDriver driver;
	WebElementUtils elementutils=new WebElementUtils();
	
	public  StorePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='StoreName']")
	WebElement storename;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailid;
	@FindBy(xpath="//input[@id='StorePhone']")
	WebElement storephone;
	@FindBy(xpath="//input[@id='Country']")
	WebElement country;
	@FindBy(xpath="//input[@id='City']")
	WebElement city;
	@FindBy(xpath="//input[@id='Adresse']")
	WebElement addres;
	@FindBy(xpath="//input[@id='CustomeFooter']")
	WebElement customFootr;
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement submitBtn;
	
	public void addStoreName(String storenmValue)
	{
		elementutils.enteringValuetoElements(driver,storename,storenmValue);
	}
	public void addEmailId(String emailid)
	{
		elementutils.enteringValuetoElements(driver,storename,emailid);
	}
	public void addStorePhone(String storPhn)
	{
		elementutils.enteringValuetoElements(driver,storename,storPhn);
	}
	public void addCountry(String countryVal)
	{
		elementutils.enteringValuetoElements(driver,storename,countryVal);
	}
	public void addCity(String cityValu)
	{
		elementutils.enteringValuetoElements(driver,storename,cityValu);
	}
	public void addAddress(String adresVal)
	{
		elementutils.enteringValuetoElements(driver,storename,adresVal);
	}
	public void addCustomFooter(String custmfutVal)
	{
		elementutils.enteringValuetoElements(driver,storename,custmfutVal);
	}
}
