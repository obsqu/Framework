package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;

public class WaiterPageTest {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	WaiterPage watrpg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	SoftAssert soft=new SoftAssert();
	
	@BeforeMethod
	public void preRun()
	{
		
		//driver=getDriver();
		brwsrUtil.launchUrl(driver,"https://qalegend.com/restaurant/");
		loginpg=new LoginPage(driver);
		
		homepg=loginpg.login("admin","password");
		//watrpg=homepg.navigateToWaiterPage();
	}
	
	@Test(priority=1,enabled=true)
	public void validateAddWaiterDatas() {
		
		watrpg.addWaiterButton();
		watrpg.addWaiterName("Miraj");
		watrpg.addwaiterPhoneNum("345487643");
		watrpg.addwaiterEmailid("mir@gmail.com");
		watrpg.selectStore("MNC");
		
		watrpg.submitWaiterValue();
		
		watrpg.searchWaiterLink("Miraj");
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"Miraj","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"345487643","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"mir@gmail.com","Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(),"MNC","Failure message : Waiter name not matched");
	}

		
}
