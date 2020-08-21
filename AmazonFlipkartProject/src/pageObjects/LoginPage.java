package pageObjects;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage
{
    
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}

	@FindBy(how = How.ID, using = "j_userName")
	private WebElement userNameEditBox;
	
	@FindBy(how = How.ID, using = "j_password")
	private WebElement passwordEditBox;

	@FindBy(how = How.XPATH, using = "//button[text()='Sign In']")
	private WebElement signInButton;
	
	
	// -------------------signIn Button----------------------------
	
	private boolean isSignInButtonVisible()
	{
		if (signInButton.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	private boolean isSignInButtonEnabled()
	{
		if (signInButton.isEnabled())
		{
			return true;
		}
		return false;
	}
	
	public void clickSignIn()
	{
		if (isSignInButtonVisible() && isSignInButtonEnabled())
		{
			signInButton.click();
		}
	}
	
}
