package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * This class reads the data from config.properties
 */
public class ConfigurationDataProvider 
{
	Properties propertyFile;
	String fileName;
	
	public ConfigurationDataProvider(String propertyFilePath) throws IOException
	{
		this.fileName = propertyFilePath;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		propertyFile = new Properties();
		propertyFile.load(reader);
		reader.close();
	}
	
	public List<String> getBrowsers()
	{
		String browserName = propertyFile.getProperty("browserType");
		String[] browserArray = browserName.split(",");
		List<String> browserList = new ArrayList<String>();
		
		for (int i=0; i<browserArray.length; i++)
		{
			browserList.add(browserArray[i].trim());
		}
		
		return browserList;
	}
	
	public String getBaseURL(String baseURL)
	{
		return propertyFile.getProperty(baseURL);
	}
	
	public long getPageLoadTimeOut()
	{
		return Long.parseLong(propertyFile.getProperty("pageLoadTimeOut"));
	}
	
	public long getImplicitWait()
	{
		return Long.parseLong(propertyFile.getProperty("implicitWait"));
	}
	
	public String getIEServerPath()
	{
		return propertyFile.getProperty("IEServerPath");
	}
	
	public String getChromeServerPath()
	{
		return propertyFile.getProperty("ChromeServerPath");
	}
	
	public String getScreenShotFolder()
	{
		return propertyFile.getProperty("screenShotFolder");
	}
	
	public List<String> getRunXmls()
	{
		String runXMLs = propertyFile.getProperty("runXMLs");
		List<String> listOfRunXmls = new ArrayList<String>();
		
		for(String runXML : runXMLs.split(","))
		{
			listOfRunXmls.add(runXML.trim());
		}
		
		return listOfRunXmls;
	}

}
