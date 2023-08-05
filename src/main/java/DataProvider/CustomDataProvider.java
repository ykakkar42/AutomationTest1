package DataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name = "login")
	public static Object[][] getdata()
	{
		Object [][]arr= ExcelReader.getDataFromSheet("./TestData/testdata.xlsx", "login");
		return arr;
	}
}
