package openCratProject.org.Resources.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import openCratProject.org.Resources.baseClass.SetUpClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ExtentReport implements ITestListener{
	
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports extent;
	public static ExtentTest testReport;
	static File file;

    //OnStart  Of the test
	public  void onStart(ITestContext context) {

		//System.getProperty("user.dir")+
		file = new File("./target/extentReports/report :" + DateTimeStamp.getDateTimeStamp() + ".html");
		sparkReport = new ExtentSparkReporter(file);
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("Functional Testing");
		//sparkReport.config().setTheme(Theme.DARK);

		//This step is for the Document styling
		try {
			sparkReport.loadJSONConfig(new File("./config/extentReport.json"));
			//sparkReport.loadXMLConfig("config/extentReport.xml");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Computer", "Local host");
		extent.setSystemInfo("Tester", "Umesh");
		extent.setSystemInfo("Environment ", "QA");
		extent.setSystemInfo("OS", "Mac OS");
		extent.setSystemInfo("Browser Name", "Chrome");

		String os= context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser= context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser ", browser);
		 List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		 if(!includeGroups.isEmpty()){
			 extent.setSystemInfo("Groups", includeGroups.toString());
		 }

	}
		//OnSuccess Of the test
	    public void onTestSuccess(ITestResult result) {
		 
		 	String path =SetUpClass.screenShot();//Normal ScreenShot File
			String base64 = SetUpClass.base64ScreenShot();//Base64 ScreenShot
			
	    	System.out.println("Test---------->>Passed");
			testReport=extent.createTest(result.getTestClass().getName())
					.assignCategory(result.getMethod().getGroups())
					.info(MarkupHelper.createLabel("Test Passed",ExtentColor.GREEN))
					
					.addScreenCaptureFromPath(path,"Registration Test")//Normal ScreenShot File
					.addScreenCaptureFromBase64String(base64,"Registration Test")//Base64 ScreenShot
					.pass("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(base64).build())
					.pass("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(path, "Registration Test Case Passed").build())
					
					.assignCategory("Regression")
					.assignAuthor("Umesh")
					.assignDevice("Macbook")
					.log(Status.PASS, "Test Is passed :"+result.getName());
	        
	    }
		//OnFailure Of the test
	    public  void onTestFailure(ITestResult result) {
	    	
			Throwable thr= new Throwable();
			String path =SetUpClass.screenShot();//Normal ScreenShot File
			String base64 = SetUpClass.base64ScreenShot();
			
			testReport=extent.createTest(result.getTestClass().getName())
					.assignCategory(result.getMethod().getGroups())
					.info(MarkupHelper.createLabel("Test Failed",ExtentColor.RED))
					
					.addScreenCaptureFromPath(path,"Registration Test")//Normal ScreenShot File
					.addScreenCaptureFromBase64String(base64,"Registration Test")//Base64 ScreenShot
					.fail(thr,MediaEntityBuilder.createScreenCaptureFromPath(base64, "Registration Test Case base64 Failed").build())
					.fail(thr,MediaEntityBuilder.createScreenCaptureFromPath(path,"Registration Test Case File Failed").build())
					
	        		.assignCategory("Regression")
					.assignAuthor("Umesh")
					.assignDevice("Macbook")
					.log(Status.FAIL, "Test Is Failed :"+result.getName())
	        		.log(Status.FAIL, "Test Is failed :"+result.getThrowable());
			

	    }
		//OnSkipped  test
	    public  void onTestSkipped(ITestResult result) {
	    	System.out.println("Test---------->Skipped");
			
			String path =SetUpClass.screenShot();//Normal ScreenShot File
			String base64 = SetUpClass.base64ScreenShot();//Base64 ScreenShot
			
			testReport=extent.createTest(result.getName())
						.info(MarkupHelper.createLabel("Tha Label color",ExtentColor.YELLOW))
					
						.addScreenCaptureFromPath(path,"Registration Test")//Normal ScreenShot File
						.addScreenCaptureFromBase64String(base64,"Registration Test")//Base64 ScreenShot
						.skip("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(base64).build())
						.skip("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(path,"Registration Test Case Skipped").build())
					
						.log(Status.SKIP, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
						.assignCategory("Regression")
						.assignAuthor("Umesh")
						.assignDevice("Macbook")
						.log(Status.SKIP, "Test Is Skipped :"+result.getName());
	    }
	   
		//OnFinish Of the test
        public  void onFinish(ITestContext context) {
	    		extent.flush();
            try {
                Desktop.getDesktop().browse(file.toURI());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
			
			
        }

}

