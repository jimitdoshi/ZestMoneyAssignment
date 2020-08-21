package testCases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import pageObjects.HomePageAmazon;
import pageObjects.HomePageFlipkart;
import pageObjects.LoginPage;


public class testCase1 extends BaseTest
{
	public String testCaseName = "testCase1";
	WebDriver driver = BrowserFactory.getBrowser("Chrome");
	LoginPage loginPage;
	HomePageAmazon homePageAmazon;
	HomePageFlipkart homePageFlipkart;
	
	@BeforeClass (alwaysRun = true)
	public void setUp()
	{
		homePage = PageFactory.initElements(driver, HomePageAmazon.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test()
	public void searchIphone()
	{
		
		// Test case to get the price of Iphone XR 64 GB - YELLOW from Amazon.in
		driver.get(DataProviderFactory.getConfigurationDataProvider().getBaseURL("baseURL1"));

		homePageAmazon.clickOnSearchBox();
		homePageAmazon.enterText("iPhone XR (64GB) - Yellow");
		Assert.assertTrue(new Boolean(homePage.isIphoneXRVisible()).toString().equals("true"), "Did not find the item!");
		homePageAmazon.selecteIphoneXR();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    int priceOnAmazon = Integer.parseInt(homePageAmazon.getPriceOfIphoneXR());
	    driver.switchTo().window(tabs2.get(0));
	    
	    
	    
	    
		// Test case to get the price of Iphone XR 64 GB - YELLOW from Flipkart.com
		driver.get(DataProviderFactory.getConfigurationDataProvider().getBaseURL("baseURL2"));
	
		homePageFlipkart.clickOnSearchBox();
		homePageFlipkart.enterText("iPhone XR (64GB) - Yellow");
		Assert.assertTrue(new Boolean(homePage.isIphoneXRVisible()).toString().equals("true"), "Did not find the item!");
		homePageFlipkart.selecteIphoneXR();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    int priceOnFlipkart = Integer.parseInt(homePageFlipkart.getPriceOfIphoneXR());
	    driver.switchTo().window(tabs.get(0));
	    
	    //Comparision of Price and printing on console
	    System.out.println(Math.min(priceOnAmazon, priceOnFlipkart));
			
	}
	
	@AfterClass
    public void tearDown(){
        driver.quit();
    }
}
