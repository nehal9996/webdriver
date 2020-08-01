package customListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{

	
	public void onTestFailure(ITestResult result) {
		System.out.println("taking screenshot --failed "+result.getName());
		
		Reporter.log("<a href=\"N:\\Java-selenium\\workspace\\TESTNG01\\src\\test\\resources\\Screenshots\\pic1.png\">Screnshot Link</a>");
		Reporter.log("<br>");
		
		//adding image instead of text for image link
		Reporter.log("<a href=\"N:\\Java-selenium\\workspace\\TESTNG01\\src\\test\\resources\\Screenshots\\pic1.png\"> <img height=100 width=100 src= \"N:\\Java-selenium\\workspace\\TESTNG01\\src\\test\\resources\\Screenshots\\pic1.png\" >   </a>");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test has passed !!"+result.getName());
		
		
	}
}
