package com.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class HomePageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	BrowserUtils brwsrUtil = new BrowserUtils();
	WebElementUtils elementutil = new WebElementUtils();
	PropertyUtil property = new PropertyUtil();
	WaitUtils waitutil = new WaitUtils();

	@BeforeMethod
	public void preRun() throws IOException {

		driver = getDriver();

		homepg = new HomePage(driver);

		brwsrUtil.launchUrl(driver, "https://qalegend.com/restaurant/");
		// waitutil.implicitWait(driver,30);
		loginpg = new LoginPage(driver);
		homepg = loginpg.login("admin", "password");
	}

	@Test(priority = 1, enabled = true)
	public void ValidatetheMenuItemsDisplayedonTheHomePage() {
		SoftAssert soft = new SoftAssert();
		boolean flagpos = homepg.isPosDisplayed();
		soft.assertTrue(flagpos, "Fail: POS Link is not displayed");

		boolean flagpdt = homepg.isProductDisplayed();
		soft.assertTrue(flagpdt, "Fail: Product link is not displayed");

		boolean flagstr = homepg.isStoreDisplayed();
		soft.assertTrue(flagstr, "Fail: Store link is not displayed");

		boolean flagpepl = homepg.isPeopleDisplayed();
		soft.assertTrue(flagpepl, "Fail: People link is not displayed");

		boolean flagsale = homepg.isSaleDisplayed();
		soft.assertTrue(flagsale, "Fail: Sale link is not displayed");

		boolean flagexpns = homepg.isExpenseDisplayed();
		soft.assertTrue(flagexpns, "Fail: Expense link is not displayed");

		boolean flagcatgry = homepg.isCategoryDisplayed();
		soft.assertTrue(flagcatgry, "Fail: Category link is not displayed");

		boolean flagseting = homepg.isSettingDisplayed();
		soft.assertTrue(flagseting, "Fail: Setting link is not displayed");

		boolean flagrept = homepg.isReportDisplayed();
		soft.assertTrue(flagrept, "Fail: Report link is not displayed");

		boolean flaglang = homepg.isReportDisplayed();
		soft.assertTrue(flaglang, "Fail: Language link is not displayed");

		boolean flaglogout = homepg.isLogoutDisplayed();
		soft.assertTrue(flaglogout, "Fail: Logout button is not displayed");

		soft.assertAll();

	}

}
