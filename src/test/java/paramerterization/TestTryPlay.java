package paramerterization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestTryPlay {
	public  String path;
	public  static FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private static XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	public TestTryPlay(String path) throws IOException
	{
		this.path=path;
		try {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		fis.close();
		} catch (Exception e) {
		
		e.printStackTrace();
	} 
	}	
	
	// returns the row count in a sheet
		public int getRowCount(String sheetName){
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return 0;
			else{
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
			}
			
		}
		
		
		public int getColumnCount(String sheetName){
			// check if sheet exists
		
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			
			if(row==null)
				return -1;
			
			return row.getLastCellNum();
			
		}
		
		

		// returns the data from a cell
			public String getCellData(String sheetName,int colNum,int rowNum){
			try{
				if(rowNum <=0)
					return "";
			
			int index = workbook.getSheetIndex(sheetName);

			if(index==-1)
				return "";
			
		
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";
			
		  if(cell.getCellType()==CellType.STRING)
			  return cell.getStringCellValue();
		  else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell)) {
		           // format in form of M/D/YY
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		            cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.MONTH)+1 + "/" +
		                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cellText;
		      }

			  
			  
			  return cellText;
		  }else if(cell.getCellType()==CellType.BLANK)
		      return "";
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
			}
			catch(Exception e){
				
				e.printStackTrace();
				return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
			}
		}
		
		
		
	
	public static void main(String[] args) throws IOException {
		TestTryPlay ttp = new TestTryPlay("N:\\Java-selenium\\workspace\\TESTNG01\\src\\test\\resources\\LoginData.xlsx");
		System.out.println(ttp.getRowCount("logindata"));
		System.out.println(ttp.getColumnCount("logindata"));
		
		int rownum =ttp.getRowCount("logindata");
		 int colnum =ttp.getColumnCount("logindata");
		
		Object[][] data = new Object[rownum-1][colnum];       // Object[row][col] //number of col must always match no. of parameters in @test method
		
		
		
		
		  for (int row=2;row<=rownum;row++) 
		  { 	for(int col=0;col<colnum;col++) {
			  	data[row-2][col] = ttp.getCellData("logindata", col, row); 
			  	System.out.println(data[row-2][col]);
			  	
		  } 
	      }
	
		  
		  
		  //just trying hashtable
		  Hashtable<Integer,String> table =new Hashtable<Integer,String>();
		  table.put(101, "Nehal");
		  table.put(104, "Nehal");
		  table.put(103, "Nel");
		  System.out.println(table);
		  System.out.println("       -- >>"+table.get(103));
	}
	
	
	
}
