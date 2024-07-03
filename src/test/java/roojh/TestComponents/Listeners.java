package roojh.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import roojh.TestResource.ExtentReport;

public class Listeners extends BaseTestUtils implements ITestListener {

	ExtentReports test = ExtentReport.extentReportObject();
	ExtentTest extentTest;
	private WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = test.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			System.out.println("I am try block");
		} catch (Exception e) {

			System.out.println("I am in catch");
			e.printStackTrace();

		}
		String failureScreenshotPath = null;
		try {
			failureScreenshotPath = takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

		extentTest.addScreenCaptureFromPath(failureScreenshotPath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		test.flush();
	}

}
