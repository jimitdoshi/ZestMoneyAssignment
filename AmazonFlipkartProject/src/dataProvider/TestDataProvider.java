package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * The purpose of this class is to provide test data from an Excel file
 */
public class TestDataProvider 
{
	
	private String testDataFilePath;
	private FileInputStream fileStream;
	private XSSFWorkbook testDataWorkbook;
	private XSSFSheet testDataSheet;
	DataFormatter formatter;
	
	public TestDataProvider(String testDataFilePath) throws IOException
	{
		this.testDataFilePath = testDataFilePath;
		fileStream = new FileInputStream(new File(this.testDataFilePath));
		testDataWorkbook = new XSSFWorkbook(fileStream);
		testDataSheet = testDataWorkbook.getSheet("TestData");
		formatter = new DataFormatter();
	}
	
	// This method takes a testCaseName and a columnName, then find and return the value in the cell
	private String getData(String testCaseName, String keyName)
	{
		int rowEnd = testDataSheet.getLastRowNum();
		String value = "";
		
		for (int i = 0; i <= rowEnd; i++)
		{
			String testName = testDataSheet.getRow(i).getCell(0).getStringCellValue();
			
			if (testName.equals(testCaseName))
			{
				int j = 0;
				String colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
				
				while (!colName.isEmpty()) 
				{
					colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
					if (colName.equals(keyName)) 
					{
						// Use DataFormatter class to solve reading numeric value issue
						value = formatter.formatCellValue(testDataSheet.getRow(i).getCell(j));
						break;						
					}
					j++;
				}
				break;		
			}
		}
		return value;
	}
		
	public String getUsername(String testCaseName)
	{
		return getData(testCaseName, "Username");
	}
	
	public String getPassword(String testCaseName)
	{
		return getData(testCaseName, "Password");
	}
	
	// This method takes a testCaseName and a columnName, then find and return the value in the cell
	public String getTestData(String testCaseName, String columnName)
	{
		return getData(testCaseName, columnName);
	}
	
	public void closeTestDataSheet()
	{		
		try {
			testDataWorkbook.close();
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
