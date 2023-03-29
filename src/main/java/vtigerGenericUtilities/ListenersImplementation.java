package vtigerGenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import zmq.ZError.IOException;
/**
 * 
 * This is for TestListeners
 * @author teja
 *
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--- Started");
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--- Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		JavaUtilities jUtil = new JavaUtilities();
		WebDriverUtilities wUtil = new WebDriverUtilities();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+"--- Test Failed");
		test.log(Status.INFO, result.getThrowable());
		
		String ScreenshotName = methodName+"---"+jUtil.getSystemDateInFormat();
		try {
			String path = wUtil.takeScreenshoot(BaseClass.sDriver, ScreenshotName);
			test.addScreenCaptureFromPath(path);
		}catch(IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--- Test Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\Extent Reports\\Report-"+new JavaUtilities().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Reporter Name", "Teja");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		report.flush();
	}

	
}
