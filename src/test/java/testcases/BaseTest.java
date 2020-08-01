package testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	@BeforeSuite
	public void setUp()
	{
		System.out.println("initializing setup");
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		System.out.println("closing  setup");
		
	}
	
	
}
