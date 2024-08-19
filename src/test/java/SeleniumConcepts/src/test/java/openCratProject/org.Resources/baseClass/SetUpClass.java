package openCratProject.org.Resources.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import openCratProject.org.Resources.utilities.DateTimeStamp;
import openCratProject.org.Resources.utilities.LoggerClass;
import openCratProject.org.Resources.utilities.PropertiesClass;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class SetUpClass {
   
    protected static  WebDriver driver;
    static LoggerClass log;
    
    //@BeforeTest(groups = {"Master","Login", "Register"})@Parameters({"browser","os"})
    public static void  browserSetup(String browserName, String os) throws MalformedURLException {

        log = new LoggerClass();
        log.logInfo("Browser Started");

        //Remote Web driver
        if (loadConfig("execute_envy").equalsIgnoreCase("remote")) {

            System.out.println("Remote Driver started *****************");
            DesiredCapabilities cap = new DesiredCapabilities();

            if (os.equalsIgnoreCase("windows")) {
                cap.setPlatform(Platform.WINDOWS);
            } else if (os.equalsIgnoreCase("linux")) {
                cap.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("macbook")) {
                cap.setPlatform(Platform.MAC);
            } else {
                System.out.println("Environment not Found");
            }
            if (os.equalsIgnoreCase("windows")) {
                cap.setPlatform(Platform.WINDOWS);
            } else if (os.equalsIgnoreCase("linux")) {
                cap.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("macbook")) {
                cap.setPlatform(Platform.MAC);
            } else {
                System.out.println("Environment not Found");
                return;
            }

            switch (browserName.toLowerCase()) {
                case "chrome":
                    cap.setBrowserName("chrome");
                    break;
                case "safari":
                    cap.setBrowserName("safari");
                    break;
                case "edge":
                    cap.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    cap.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Browser not found");
                    return;
            }
            driver = new RemoteWebDriver(new URL("http://192.168.1.123:4444"), cap);
        }
        //Local WebDriver
        if(loadConfig("execute_envy").equalsIgnoreCase("local")) {
            System.out.println("Local Driver started *****************");
            switch (browserName.toLowerCase()) {

                case "chrome":loadConfig("browser");
                    ChromeOptions options= new ChromeOptions();
                    options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver(options);
                    break;
                case "safari":loadConfig("browser"); WebDriverManager.safaridriver().setup(); driver= new SafariDriver();
                    break;
                case "edge":loadConfig("browser");WebDriverManager.edgedriver().setup(); driver= new EdgeDriver();
                    break;
                case "firefox":loadConfig("browser");WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver();
                    break;
                default:
                    System.out.println("Browser not found");
                    return ;
            }
        }

        driver.get(loadConfig("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    //Different type of browser Method calling
    //@BeforeTest//(groups = {"Master","Login", "Register"})
    public static String browserSetupp(String browserName){
        
        if(loadConfig("execute_envy").equalsIgnoreCase("local")) {
            System.out.println("Local Driver started *****************");
            
            if (DriverManager.getDriver() == null && browserName.equalsIgnoreCase(loadConfig("opera"))) {
                WebDriverManager.operadriver().setup();
            } else if (DriverManager.getDriver() == null && browserName.equalsIgnoreCase("edge")) {
                EdgeDriver options = new EdgeDriver();
                //options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (DriverManager.getDriver() == null && browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            } else if (DriverManager.getDriver() == null && browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();

            }
        }
        driver.get(loadConfig("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
 
        return browserName;
    }

    public static String getURL(String url) {
       
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return url;
    }
    
    //Title of the page
    public static  String titleofthePage() {

       
        String title= driver.getTitle();
        System.out.println("Title of the page :"+title);
        return title;
    }
    
    //Randomly generate email
    public static String  generateEmail() {
        return RandomStringUtils.randomAlphabetic(4)+"@gmail.com";
    }
    //Randomly Generate number
    public static String generateNumber(){
        int number=9;
        return number+ RandomStringUtils.randomNumeric(9);
    }
    //Fluent wait
    public static void fluentWait(WebElement element) {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.locator));
        //wait.until(ExpectedConditions.titleContains("Your Store"));
    }
    
    //ScreenShot Using BAse64 
    public static String base64ScreenShot(){
        String path =System.getProperty("user.dir");
        TakesScreenshot ts= (TakesScreenshot)driver;
        String base64= ts.getScreenshotAs(OutputType.BASE64);
        return base64;
    }
    //ScreenShot Using Normal File
    public static String screenShot(){
        
        String destination = System.getProperty("user.dir") + "/screenshots/" + DateTimeStamp.getDateTimeStamp()+".png";
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(destination);
        try {
            FileUtils.copyFile(source,targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return targetFile.getAbsolutePath();
    }
    //ScreenShot Using Normal File
    public static void screenShotMethod(String fileLocation){

        String path= System.getProperty("user.dir")+fileLocation;
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);

        File file= new File(path+"image.png");
        source.renameTo(file);
    }
    //Parallel Testing
    public static void parallelTesting(String br) throws MalformedURLException {
        switch (br.toLowerCase()) {
            case "chrome":
                browserSetup("chrome","macbook");
                break;
            case "safari":
                browserSetup("safari","macbook");
                break;
            case "edge":
                browserSetup("edge","macbook");
                break;
            case "firefox":
                browserSetup("firefox","macbook");
                break;
            default:
                System.out.println("Browser not found");
                return;

        }

    }
    public static String loadConfig(String key)  {

        String value= null;
        try {
            Properties prop = new Properties();
            String path= System.getProperty("user.dir")+
                    "/src/test/java/openCratProject/org.Resources/utilities/config.properties";
            File file = new File(path);
            FileInputStream inputFile = new FileInputStream(file);
            prop.load(inputFile);
            value = prop.getProperty(key);

        } catch (IOException e) {
            System.out.println(" No configuration file is found");
            e.printStackTrace();
        }
        return value;
    }
    //Closing the Browser
    @AfterTest(groups = {"Master","Login", "Register"})
    public static void tearDown() {
       
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        
    }
    
    
}
