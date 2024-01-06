package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.NaptolHomePage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)


public class VerifyShoppingCategoriesTest extends BaseTest{
	ExtentReports extentReports;
	ExtentTest test;
	@BeforeTest
	public void configureReports() {
		extentReports=Reports.generateReports();
	}
	@BeforeMethod
	public void  OpenBrowser() {
		driver = LaunchBrowser.Openchrome();
	}
	
	@Test
	public void verifyIfUserIsAbleToAccessShoppingCategories() {
		
	 test =extentReports.createTest("VerifyUserIsAbleToAccessShoppingCategories");
		NaptolHomePage  naptolhomePage = new NaptolHomePage(driver);
		naptolhomePage.clickOnShoppingcategories();
		naptolhomePage.SelectShoppingCategories(driver, 3);
		
		String currentTitle =driver.getTitle();
		Assert.assertTrue(currentTitle.contains("Mobile Handsets"));
		Assert.assertEquals(naptolhomePage.GetCategoryHeading(), "Mobiles : Mobile Handsets");	
	}
	@AfterTest
	public void publishReports() {
		extentReports.flush();
	}	



}
