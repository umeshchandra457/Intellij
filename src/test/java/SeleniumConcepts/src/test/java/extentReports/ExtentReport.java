package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener{
	
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports extent;
	public static ExtentTest testReport;
	
	 public  void onStart(ITestContext context) {
		 
		 sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/extentReports/report.html");
		 sparkReport.config().setDocumentTitle("Automation Report");
		 sparkReport.config().setReportName("Functional Testing");
		 sparkReport.config().setTheme(Theme.DARK);
		 sparkReport.config().setReportName("Test Report");
		 sparkReport.config().setDocumentTitle("Test Document NAme");
		 sparkReport.config().setTheme(Theme.DARK);
		 sparkReport.config().setJs("");
		 
		 extent= new ExtentReports();
		 extent.attachReporter(sparkReport);
		 extent.setSystemInfo("Computer", "Local host");
		 extent.setSystemInfo("Tester", "Pavan");
		 extent.setSystemInfo("Environment ", "QA");
		 extent.setSystemInfo("OS", "Mac OS");
		 extent.setSystemInfo("Browser Name", "Chrome"); 
		 
	    }
	    public void onTestStart(ITestResult result) {
	    	
	        System.out.println("Testing is starting ");
	    }
	    public void onTestSuccess(ITestResult result) {
	    	System.out.println("Test............>Passed");
	        extent.createTest(result.getName());
	        testReport.log(Status.PASS, "Test Is passed "+result.getName() );
	    }
	    public  void onTestFailure(ITestResult result) {
	    	System.out.println("Test............>Failed");
	    	extent.createTest(result.getName());
	        testReport.log(Status.FAIL, "Test Is Failed "+result.getName());
	        testReport.log(Status.FAIL, "Test Is failed "+result.getThrowable());

	    }
	    public  void onTestSkipped(ITestResult result) {
	    	System.out.println("Test............>Skipped");
	    	extent.createTest(result.getName());
	        testReport.log(Status.SKIP, "Test Is Skipped "+result.getName() );
	    }
	   
	    public  void onFinish(ITestContext context) {
	    	
	    	extent.flush();

	    }
	
}
