package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage 
{	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// ---------------write inputs into edit boxes------------------------
	
	public void writeInput(WebElement object, String data, WebDriver driver)
	{
		try
		{
			if(object.isDisplayed() && object.isEnabled())
			{
				object.clear();
				object.click();
				object.sendKeys(Keys.BACK_SPACE);
				
				try
				{
					Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
					String browserName = cap.getBrowserName().toLowerCase();
					if(browserName.equals("Chrome"))
					{
						((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1];", object, data);
					}
					else
					{
						object.sendKeys(data);						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					Assert.fail("Inputbox is not enabled.");
				}
			}
			else{
				Assert.fail("Inputbox doesn't exist.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to write.");
		}
	}
	
	// -----------------Wait-----------------------
	
	protected void waitForSeconds(int t)
	{
		try {
			Thread.sleep(t*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ----------------Click with Action----------------
	
	protected void clickWithAction(WebElement element)
	{	
		Actions builder = new Actions(driver);
		builder.click(element).build().perform();
	}
	
	
	protected WebElement getWhenVisible(By locator, int timeout) {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    return element;
	}
	
	protected void clickWhenReady(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}

}
