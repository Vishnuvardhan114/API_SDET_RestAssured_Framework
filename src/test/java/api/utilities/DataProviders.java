package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="GetAllDataProvider")
	public String[][] getAllDataProvider() throws IOException {
		
		String path = System.getProperty("user.dir")+"//Testdata//Book2.xlsx";
		ExcelUtilities xlUtility= new ExcelUtilities(path);
		int rowNum= xlUtility.getRowCount("Sheet1");
		int colNum= xlUtility.getCellCount("Sheet1", rowNum);
		String[][]allData=new String[rowNum][colNum];
		
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				
				allData[i-1][j]=xlUtility.getCellData("Sheet1", i, j);
			}
			
		}
		
		return allData;
		
	}
	
	@DataProvider(name="UserNamesDataProvider")
	public String[] getUserName() throws IOException {
		String path = System.getProperty("user.dir")+"//Testdata//Book2.xlsx";
		ExcelUtilities xlUtility= new ExcelUtilities(path);
		int rowNum= xlUtility.getRowCount("Sheet1");
		
		String[]userNames=new String[rowNum];
		
		for (int i = 1; i <= rowNum; i++) {
			
				
			userNames[i-1]=xlUtility.getCellData("Sheet1", i,1);
			
			
		}
		
		return userNames;
	
		
	}

}
