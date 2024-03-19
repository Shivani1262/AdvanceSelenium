package commonUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports report ;
	ExtentTest test ;
	public WebDriver driver ;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is started",true);
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		Reporter.log("Testscript execution is passed",true);
//		ExtentTest test = new ExtentTest("");
		test.log(Status.PASS, "Testscript execution is passed");
//		test.log(Status.PASS, methodName);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
//		Reporter.log("Testscript execution is failed" +message,true);
		test.log(Status.FAIL, "Testscript execution is failed");
		WebDriverUtil wdutil = new WebDriverUtil();
		try {
			wdutil.screenShot(BaseClass.sdriver, "Contact");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		Reporter.log("To skip the testscript",true);
		test.log(Status.SKIP, "Testscript execution is skipped");
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		Reporter.log("",true);
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		Reporter.log("",true);
//	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("To start execution",true);
		//use ExtentSparkReporter class just to configure extentreport
		JavaUtils jutil = new JavaUtils();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Pune");
		
		//use ExtentReports to generate extentReport
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("ChromeVersion", "122");
		report.setSystemInfo("Author", "Shivani");
	}

	@Override
	public void onFinish(ITestContext context) {
//		Reporter.log("To Finish execution",true);
		report.flush();
		
	}
		
}
