package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.Assert;

import pojo.LaunchBrowser;
import pom.NaptolHomePage;
import pom.ProductResultPage;
import utility.Reports;

public class ProductSearchPage 
{
	public class ProductSearchTest extends BaseTest{
		ExtentReports extentReports;
		ExtentTest test;
		@BeforeTest
		public void configureReports() {
			extentReports=Reports.generateReports();
		}

		@BeforeMethod
		public void OpenBrowser() {
			driver = LaunchBrowser.Openchrome();
		}
		
		@Test
		public void verifyIfProdutsAreDisplayedOnValidSearch() 
		{  test =extentReports.createTest("verifyIfProdutsAreDisplayedOnValidSearch");
			NaptolHomePage naptolhomepage = new NaptolHomePage(driver);
			naptolhomepage.EnterInSearchbox("toys");;
			naptolhomepage.clickOnSearch();
			
			ProductResultPage productresultpage = new ProductResultPage(driver);
			Assert.assertTrue(productresultpage.getNumberOfProducts()>0);
	
			
		}
		@Test
		
		public void verifyIfProdutsAreDisplayedOnInValidSearch() 
		{  test =extentReports.createTest("verifyIfProdutsAreDisplayedOnInValidSearch");

			NaptolHomePage naptolhomepage = new NaptolHomePage(driver);
			naptolhomepage.EnterInSearchbox("iphone");
			naptolhomepage.clickOnSearch();
			
			ProductResultPage productresultpage = new ProductResultPage(driver);
			Assert.assertTrue(productresultpage.getNumberOfProducts()==0);
	
			
		}
		@AfterTest
		public void publishReports() {
			extentReports.flush();
		}	

		}
		

}
