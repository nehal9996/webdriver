package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TESTNGTry  extends BaseTest{

	@BeforeMethod
	public void openBrowser()
	{
		System.out.println("opening browser");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("closing browser");
	}
	
	@Test(priority=1)
	public void doLogin()
	{
		System.out.println("logging in");
	}
	
	@Test(priority=0) 
	public void signup()
	{
		System.out.println("sign up in");
	}
	
	
	@BeforeTest
	public void connectingDB()
	{
		System.out.println("connecting DB");
	}
	
	@AfterTest
		public void disconnectingDB()
	{
		System.out.println("connecting DB");
	}
}
