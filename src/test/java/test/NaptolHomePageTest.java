package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.NaptolHomePage;

import utility.Reports;



	@Listeners(test.Listeners.class)
	
	public class NaptolHomePageTest extends BaseTest {
		ExtentReports extentReports;
		ExtentTest test;
		
		@BeforeTest
		public void configureReports() {
			extentReports=Reports.generateReports();
		}
		
		@BeforeMethod
		public void OpenBrowser() 
		{
			driver =LaunchBrowser.Openchrome();
		}
		@Test
		
		public void VerifyUserIsAbleToAccessShoppingCategories()
		{   test =extentReports.createTest("VerifyUserIsAbleToAccessShoppingCategories");
		
			NaptolHomePage naptolhomepage = new NaptolHomePage(driver);
			//naptolhomepage.clickOnLogin();
			naptolhomepage.clickOnShoppingcategories();
			naptolhomepage.SelectShoppingCategories(driver,10);
			naptolhomepage.GetCategoryHeading();
			String currentTitle =driver.getTitle();
			Assert.assertTrue(currentTitle.contains("soft Toys"));
			Assert.assertEquals(naptolhomepage.GetCategoryHeading(), "Kids & Toys : Soft Toys");
			
			
					
		}
		@Test
		public void VerifyUserIsAbleToSearchElementInSearchBox()
		{
			 test =extentReports.createTest("VerifyUserIsAbleToAccessShoppingCategories");
				
				NaptolHomePage naptolhomepage = new NaptolHomePage(driver);
				naptolhomepage.EnterInSearchbox("mobile");
			
		}
		@AfterTest
		public void publishReports() {
			extentReports.flush();
		}	

		
}
