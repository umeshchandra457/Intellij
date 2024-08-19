package SeleniumConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ChromeOptionsClass {

    static WebDriver driver;

    //Headless Browser
    public static void hlessBrwsr(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=true");   // To run in HeadLess mode

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());
    }
    // For SSL Websites
    public static void badSSLNotFound(){

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);        // For SSL Websites to get the Details of the webSITE

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());
    }

    //Remove the Automated Messages on the Browser
    public static void deleteAutomMessgeOnScreen() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//Remove the Automated Messages on the Browser

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }

    //Incognito Mode
    public static void incogniteMode() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");            //To run in Incognito Mode
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//Remove the Automated Messages on the Browser

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

    }

    //Get ChromeExtensions on the browser
    public static void chromeExtensions() throws InterruptedException {

        String chromePath= "/Users/umeshburraa/Downloads/Testing Docs/CRXSlectorHub ExtensionFile/SelectorsHub-XPath-Helper-Chrome-Web-Store.crx";
       //String Adblocker="/Users/umeshburraa/Downloads/Testing Docs/CRXSlectorHub ExtensionFile/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx";
        File file = new File(chromePath);
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(file);                    //Get ChromeExtensions on the browser
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//remove the extension CONTROLLED BY CHROME
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }

    //Ublock Origin
    public static void uBlockOrigin() throws InterruptedException {
        String Ublocker="/Users/umeshburraa/Downloads/Testing Docs/CRXSlectorHub ExtensionFile/uBlock-Origin-Chrome-Web-Store.crx";
        File file = new File(Ublocker);
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(file);                    //Get ChromeExtensions on the browser
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//remove the extension CONTROLLED BY CHROME
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

    }

    @Test
    public void testClass() throws InterruptedException {
        //hlessBrwsr();                 //Headless Browser ...test runs without UI
        //deleteAutomMessgeOnScreen();  //remove the extension CONTROLLED BY CHROME
        //incogniteMode();              // Open in INCOGNITO Mode
        //chromeExtensions();           //Enable all the extensions on the Page
        uBlockOrigin();                 //Remove all the ads on the Page
        badSSLNotFound();               //Get The details of the unsafe WebSite `details
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
