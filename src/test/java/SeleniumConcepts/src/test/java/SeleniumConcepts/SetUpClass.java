package SeleniumConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;


public class SetUpClass {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
    @Test
    public void testClass() throws InterruptedException {
        //productTable();
        //fillForm();
        //webSearch();
        //newWindow();
        //alertWindow();
        //copyAndPaste();
        //doubleClick();
        //dragDrop();
        //slider();
        Thread.sleep(5000);
    }

    //ScreenShot method
    public static void screenShotmethod(String fileLocation){

        String path= System.getProperty("user.dir")+fileLocation;
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);

        File file= new File(path+"image.png");
        source.renameTo(file);
    }
}
