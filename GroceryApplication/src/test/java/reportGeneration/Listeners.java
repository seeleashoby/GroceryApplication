package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testScript.ExtentReportUtility;

//ITestListener interface are used

//ExtentTest is configured in Liseners class

public class Listeners implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	//Executed testcase method fetching
	public void onTestStart(ITestResult result) {

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	//If a test case passed this method automatically invoke Test case Passed message 
	public void onTestSuccess(ITestResult result) {

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}

	//If a test case fail this method automatically invoke and status will be failed 
	public void onTestFailure(ITestResult result) {

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();

	try {

	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (IllegalArgumentException e) {
//	e.printStackTrace(); this is used to print the errors and exception in the test case

	e.printStackTrace();
	} catch (IllegalAccessException e) {

	e.printStackTrace();
	} catch (NoSuchFieldException e) {

	e.printStackTrace();
	} catch (SecurityException e) {

	e.printStackTrace();
	}

	try {
	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (Exception e) {
	}
	}
// To skip the test case
	public void onTestSkipped(ITestResult result) {

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	ITestListener.super.onTestFailedWithTimeout(result);
	}
//before executing all other method onStart will execute
	public void onStart(ITestContext context) {

	ITestListener.super.onStart(context);
	}
//onFinish will execute after all the other method executed
	//flush() is used to fetch the details get form the all method executed, to load the in the report
	public void onFinish(ITestContext context) {

	ITestListener.super.onFinish(context);
	extent.flush();
	}
}
