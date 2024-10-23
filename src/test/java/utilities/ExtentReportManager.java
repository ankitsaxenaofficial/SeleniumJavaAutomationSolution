package utilities;

import java.awt.Desktop;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext context) {
	
	LocalDateTime now = LocalDateTime.now();
        
        // Define the format of the timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        
		repName ="Test-Report_"+formattedDateTime+".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\" + repName);
		sparkReporter.config().setDocumentTitle("Orange HRM App");
		sparkReporter.config().setReportName("Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, result.getName() + " Executed Successfully");
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, result.getName() + " Got Failed");
		try {
			
			String imgPath = BaseClass.captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, result.getName() + " Got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
