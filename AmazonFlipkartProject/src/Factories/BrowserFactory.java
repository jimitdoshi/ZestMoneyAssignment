package Factories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * This class can do the following"
 * - To create required Webdriver
 * - To maintain an instance of a Webdriver
 */
public class BrowserFactory 
{
	
	private static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
		if (driver == null)
		{	
			if (browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdoshi\\Downloads\\Selenium work\\chromedriver_win32\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				driver = new ChromeDriver(options);
			}
			
			long pageLoadTimeOut = DataProviderFactory.getConfigurationDataProvider().getPageLoadTimeOut();
			long implicitWait = DataProviderFactory.getConfigurationDataProvider().getImplicitWait();
		    
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);   
		    driver.manage().window().maximize();
		}		
	    
		return driver;
	}
	
	public static WebDriver getBrowser()
	{
		return driver;
	}
	
	public static void closeWebDriver()
	{
		driver.close();
		driver.quit();
		driver = null;
	}

}
