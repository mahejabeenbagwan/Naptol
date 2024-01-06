package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage 
{
	@FindBy (xpath="//a[@id='login-panel-link']") private WebElement loginorRegister;
	@FindBy (xpath="//a[text()='Track Order']") private WebElement TrackOrder;
	@FindBy (xpath="//span[text()='Shopping Categories']") private WebElement shoppingCategories;
	@FindBy (xpath="//ul[@id='mainMenu_UL']//li") private List<WebElement> Allcategories;
	@FindBy (xpath="//a[text()='Soft Toys']") private WebElement softToys ;

	@FindBy (xpath="//li[@class='head']//h1") private WebElement categoryHeading;
	@FindBy (xpath="//input[@id='header_search_text']") private WebElement searchbox;
	@FindBy (xpath = "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement search;
	@FindBy (xpath="//div[@id='productItem1']")private WebElement product1;
	@FindBy (xpath="//span[@id='header_search_shopping_cart_count']") private WebElement addTocart;
	@FindBy (xpath="//[@class=a'red_button2']") private WebElement continueshopping;



public NaptolHomePage (WebDriver driver) 
{
	PageFactory.initElements(driver,this );
}
public void clickOnLogin()
{
	loginorRegister.click();
}
public void clickOnTrackorder()
{
	TrackOrder.click();
}
public void clickOnShoppingcategories()
{ 
	shoppingCategories.click();
}
  public String GetCategoryHeading()
{
	return categoryHeading.getText();
}
public void SelectShoppingCategories(WebDriver driver,int index)
{
	Actions actions=new Actions(driver);
			actions.moveToElement(Allcategories.get(index));
			actions.perform();
			softToys.click();
		
}
public void EnterInSearchbox(String productName)
{
	 searchbox.sendKeys(productName);
	 search.click();
	 
	
	
}
  public void clickOnSearch() {
	search.click();
}
public void clickOnAddtocart()
{
	addTocart.click();
}
public void clickOnContinueShopping()
{
	continueshopping.click();
	
}


}