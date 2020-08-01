package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertAndDepencies {

	@Test(priority=1)
	public void usingAssertEquals() {
		String actualTitle = "actual";
		String expectedTitle = "expected";
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);       //if both match Test will pass
		System.out.println(" runningg ");
		
		
	}
	


	@Test(priority=0)
	public void usingAssert() {
		String actual = "actual";
		
		Boolean check = actual.equals("actual");
		
		Assert.assertTrue(check,"Reason for fail - This will be printed if assert fails");   
		System.out.println(" runningg ");
	}

	
	//dependencies  -- "dependsOnMethods"
	
	
	@Test(priority=3,dependsOnMethods="testOne")             //if testOne fails, this test will be skipped
	public static void testTwo() {
		System.out.println("test two ");
		//used to intentionally fail a test
	}
	
	@Test(priority=3,dependsOnMethods="testOne",alwaysRun = true)             //if testOne fails, this test will still run
	public static void testThree() {
		System.out.println("test three ");
		//used to intentionally fail a test
	}
		
	@Test(priority=2)
	public static void testOne() {
		System.out.println("test one");
		AssertJUnit.fail();
	}
	
	
	//using soft Assert
	
	SoftAssert sa = new SoftAssert();
	
	@Test(priority=5)
	public void checkSoftAssert()
	{
		System.out.println("starting check SOft Assert");
		AssertJUnit.assertEquals("actual","expected", "String match failed ");
		System.out.println("this is after soft assert ");            // on using soft assert this will still execute if assert fails
		
		sa.assertAll();
	}
	
	@Test(priority=6,groups="functional")
	public void checkHardAssert()
	{
		System.out.println("starting check hard Assert");
		AssertJUnit.assertEquals("actual","expected", "String match failed ");
		System.out.println("this is after hard assert ");            // on using hard assert this will NOT execute if assert fails
		
	
	}
	
	
}
