package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageAmazon extends BasePage
{	
	public HomePageAmazon(WebDriver driver) {

		super(driver);

	}

	  
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]")
	private WebElement iPhoneXR;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'68,300')]")
	private WebElement priceOfiPhone;
    
	@FindBy(how = How.XPATH, using = "//input[@aria-label='Search']")
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

