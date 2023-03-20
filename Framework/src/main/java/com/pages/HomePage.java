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
	WebElement poslink;
	@FindBy(xpath="//span[text()='Product']")
	WebElement productlink;
	@FindBy(xpath="//span[text()='Stores']")
	WebElement storelink;
	@FindBy(xpath="//span[text()='People']")
	WebElement peoplelink;
	@FindBy(xpath="//span[text()='Sales']")
	WebElement saleslink;
	@FindBy(xpath="//span[text()='Expense']")
	WebElement expenselink;
	@FindBy(xpath="//span[text()='Categories ']")
	WebElement categorylink;
	@FindBy(xpath="//span[text()='Setting']")
	WebElement settinglink;
	@FindBy(xpath="//span[text()='Reports']")
	WebElement reportlink;
	
	@FindBy(xpath="//li[@class='dropdown language']")
	WebElement language;
	@FindBy(xpath="//i[@class='fa fa-sign-out fa-lg']")
	WebElement logout;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean isPosDisplayed()
	{
		boolean flag= elementutils.isElementDisplayed(driver,poslink);
		return flag;
	}
	
	public boolean isProductDisplayed()
	{
		
		boolean flag=elementutils.isElementDisplayed(driver,productlink);
		return flag;
	}
	
	public boolean isStoreDisplayed()
	{
		
		boolean flag= elementutils.isElementDisplayed(driver,storelink);
		return flag;
	}
	
	public boolean isPeopleDisplayed()
	{
		
		boolean flag= elementutils.isElementDisplayed(driver,peoplelink);
		return flag;
	}
	
	public boolean isSaleDisplayed()
	{
			
		boolean flag=elementutils.isElementDisplayed(driver,saleslink);
		return flag;
	}
	public boolean isExpenseDisplayed()
	{
		
		boolean flag= elementutils.isElementDisplayed(driver,expenselink);
		return flag;
	}
	
	public boolean isCategoryDisplayed()
	{
		
		boolean flag= elementutils.isElementDisplayed(driver,categorylink);
		return flag;
	}
	
	public boolean isSettingDisplayed()
	{
		
		boolean flag=elementutils.isElementDisplayed(driver,settinglink);
		return flag;
	}
	
	public boolean isReportDisplayed()
	{
		
		boolean flag=elementutils.isElementDisplayed(driver,reportlink);
		return flag;
	}
	public boolean isLanguageDisplayed()
	{
		
		boolean flag=elementutils.isElementDisplayed(driver,language);
		return flag;
	}
	public boolean isLogoutDisplayed()
	{
		
		boolean flag= elementutils.isElementDisplayed(driver,logout);
		return flag;
	}
	
	
	
	/*public HomePage navigateToPosPage() {
		elementutils.clickonTheElement(driver, poslink);
		return new HomePage(driver);
	}*/
	
   public ProductPage navigateToPdtPage() {
	     elementutils.clickonTheElement(driver, productlink);
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
