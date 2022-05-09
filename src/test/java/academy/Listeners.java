package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentTest test;
	// Extent report instantiate static object and method
	ExtentReports extent = ExtentReporterNG.getReportObject();

	// this will make execution of test thread safe
	ThreadLocal<ExtentTest> extentTst = new ThreadLocal<ExtentTest>();

	// Overrides the TestNG methods
	@Override
	public void onTestStart(ITestResult result) {
		// Extent report creates test and get method name
		test = extent.createTest(result.getMethod().getMethodName());
		// ThreadLocal set test value to be thread safe
		extentTst.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Extent report logs passed test, uses ThreadLocal extentTst for thread safe
		extentTst.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Extent report logs failed test, uses ThreadLocal extentTst for thread safe
		extentTst.get().fail(result.getThrowable());

		// testNG get the method name of the error
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();

		// Get instance of the class specific field ex. driver
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// Extent report logs screenshot, uses ThreadLocal extentTst for thread safe
			extentTst.get().addScreenCaptureFromPath(getSreenshotPath(methodName, driver), methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// Extent report end
		extent.flush();
	}

}
