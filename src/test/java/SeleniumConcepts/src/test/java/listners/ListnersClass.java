package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersClass implements ITestListener {

    public  void onStart(ITestContext context) {
        System.out.println("on Test execution start ");
    }
    public void onTestStart(ITestResult result) {
        System.out.println("Testing is starting ");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully passed ");
    }
    public  void onTestFailure(ITestResult result) {
        System.out.println("Test execution Failure");
    }
    public  void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped ");
    }
   
    public  void onFinish(ITestContext context) {
        System.out.println("Testing Finished ");

    }
}
