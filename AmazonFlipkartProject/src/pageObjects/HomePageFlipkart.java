package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageFlipkart extends BasePage
{	
	public HomePageFlipkart(WebDriver driver) {

		super(driver);

	}

	  
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Apple iPhone 11 (64GB) - Yellow')]")
	private WebElement iPhoneXR;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'52,500')]")
	private WebElement priceOfiPhone;
    
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	private WebElement searchBoxElement;
    
	
	// -------------------Order Inquiry Link----------------------------
	
	
	private boolean isSearchBoxVisible()
	{
		if (searchBoxElement.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	
	public void clickOnSearchBox() {
		// TODO Auto-generated method stub
		if (searchBoxElement.isEnabled())
		{
			searchBoxElement.click();
		}
	}

	public void enterText(String text) {
		// TODO Auto-generated method stub
		if (searchBoxElement.isEnabled())
		{
			writeInput(searchBoxElement, text, driver);
		}
	}

	public boolean isIphoneXRVisible() {
		// TODO Auto-generated method stub
		if (iPhoneXR.isDisplayed())
		{
			return true;
		}
		return false;
	}


	public void selecteIphoneXR() {
		// TODO Auto-generated method stub
		if (iPhoneXR.isDisplayed())
		{
			iPhoneXR.click();
		}
	}


	public String getPriceOfIphoneXR() {
		// TODO Auto-generated method stub
		return priceOfiPhone.getText();
	}
			
}

