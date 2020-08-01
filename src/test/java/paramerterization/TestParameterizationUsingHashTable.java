package paramerterization;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterizationUsingHashTable {
	ExcelReader excel = null;
	
	@Test(dataProvider = "getData")
	public void login(Hashtable<String,String> data) {

		//System.out.println(data);
		System.out.println(data.get("username")+"--"+data.get("password"));        //select the data to be used using data.get(key) 
		System.out.println("-----------------------");
  	}

	@DataProvider
	public Object[][] getData()
	{
		
		
		excel = new ExcelReader("N:\\Java-selenium\\workspace\\TESTNG01\\src\\test\\resources\\LoginData.xlsx");
		String sheetName = "logindata";
		int colnum=excel.getColumnCount(sheetName);		 
		int rownum=excel.getRowCount(sheetName);		
		Object[][] data = new Object[rownum-1][1];       // Object[row][col] //number of col must always match no. of parameters in @test method
		Hashtable<String,String> table ;
		
		String key,value;
		for (int row=2;row<=rownum;row++) 
		{
			table = new Hashtable<String,String>();
			for(int col=0;col<colnum;col++) {
				
				 key = excel.getCellData(sheetName, col, 1);
				 value = excel.getCellData(sheetName, col, row);
								
				table.put(key,value);
			
			}
			data[row-2][0] = table; 
		  }
		 
		return data;
	
	}
}
	
	
	
