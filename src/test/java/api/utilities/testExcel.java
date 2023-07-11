package api.utilities;

import java.io.IOException;

import org.testng.annotations.Test;

public class testExcel {
	@Test
	public void testEx() throws IOException {
		
		ExcelUtilities excel= new ExcelUtilities(System.getProperty("user.dir")+"/Testdata/Book2.xlsx");
		System.out.println(excel.getRowCount("Sheet1"));
		System.out.println(excel.getCellCount("Sheet1", 0));
		System.out.println(excel.getCellData("Sheet1", 0, 6));
		System.out.println(excel.getCellData("Sheet1", 4, 6));
		excel.setCellData("Sheet1", 3, 3, "Vishnu");
		
		excel.fillRedColor("Sheet1", 3, 3);
		excel.fillGreenColor("Sheet1", 3, 4);
		
	}

}
