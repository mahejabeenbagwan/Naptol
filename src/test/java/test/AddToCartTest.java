package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductResultPage;
import pom.prductQuickview;


public class AddToCartTest extends BaseTest {
	ExtentReports extentReports;
	ExtentTest test;
	@BeforeMethod
	public void OpenBrowser() {
		driver = LaunchBrowser.Openchrome();
	}
	
	@Test
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption()
	{test =extentReports.createTest("verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption");
	
	NaptolHomePage naptolhomepage = new NaptolHomePage(driver);
	naptolhomepage.EnterInSearchbox("toys");;
	naptolhomepage.clickOnSearch();
	
	ProductResultPage productresultpage = new ProductResultPage(driver);
	Assert.assertTrue(productresultpage.getNumberOfProducts()>0);

	
	   /*ProductResultPage productResultPage =new ProductResultPage(driver);
		productResultPage.Quickview(driver, 1);
		
		prductQuickview productQuickViewPage =new prductQuickview(driver);
		productQuickViewPage.clickOnClickHereToBuy();
		
		CartPage cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver), 1);*/
		
	}
	@AfterTest
	public void publishReports() {
		extentReports.flush();
	}

}
