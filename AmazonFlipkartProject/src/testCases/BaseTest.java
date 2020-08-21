package testCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import pageObjects.HomePageAmazon;

public class BaseTest 
{
	WebDriver driver = BrowserFactory.getBrowser();
	HomePageAmazon homePage;

	@BeforeClass (alwaysRun = true)
	public void setUp()
	{		
		driver.get(DataProviderFactory.getConfigurationDataProvider().getBaseURL("baseURL1"));

	}
		
	public void waitFor(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickWhenReady(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}
	
	protected void waitForSeconds(double d)
	{
		try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchToSecondWindow(WebDriver driver) 
	{
		Set<String> handles = driver.getWindowHandles();
		 
		String firstWinHandle = driver.getWindowHandle(); 
		
		String secondWinHandle;
		 
		handles.remove(firstWinHandle);
		 
		String winHandle=(String) handles.iterator().next();
		 
		if (winHandle!=firstWinHandle){
		 
			//To retrieve the handle of second window, extracting the handle which does not match to first window handle
			 
			secondWinHandle=winHandle; //Storing handle of second window handle
			 
			//Switch control to new window
			 
			driver.switchTo().window(secondWinHandle);
		}
	}
}
