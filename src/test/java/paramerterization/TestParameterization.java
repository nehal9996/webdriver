package paramerterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	ExcelReader excel = null;
	
	@Test(dataProvider = "getData")
	public void login(String username, String password,String enabled) {

		System.out.println(username + " " + password+"  "+enabled);
		System.out.println("-----------------------");
	}

	// harcoded data Provider
/*	@DataProvider
	public Object[][] getData() {
		// data provider method will always return object[][]
		Object[][] data = new Object[3][2];   // Object[row][col] //number of col must always match no. of parameters in @test method

		data[0][0] = "nehal";
		data[0][1] = "aspdf";

		data[1][0] = "chinn";
		data[1][1] = "n123";

		data[2][0] = "adit";
		data[2][1] = "asd223";
		return data;
}   */


		//Data provider using ExcelReader
	
	@DataProvider
	public Object[][] getData()
	{
		
		
		excel = new ExcelReader("N:\\Java-selenium\\workspace\\TESTNG01\\src\\test\\resources\\LoginData.xlsx");
		String sheetName = "logindata";
		int colnum=excel.getColumnCount(sheetName);  //2
		int rownum=excel.getRowCount(sheetName);	//4
		Object[][] data = new Object[rownum-1][colnum];       // Object[row][col] //number of col must always match no. of parameters in @test method
	
		
		
		for (int row=2;row<=rownum;row++) 
		  { 	for(int col=0;col<colnum;col++) {
			  	data[row-2][col] = excel.getCellData(sheetName, col, row); 
		  		} 
		  		  		 
		
		  }
		return data;
	}	
}


