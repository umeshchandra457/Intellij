package SeleniumConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadSingleFiles {

    static WebDriver driver;
    @Test
    public static void singleFileUpload() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/FileUpload.html");
        driver.manage().window().maximize();

        WebElement donotConsent = driver.findElement(By.xpath("//button[@aria-label='Do not consent']"));
        Actions action = new Actions(driver);
        action.moveToElement(donotConsent).click().perform();

        //location of the file in the system
        driver.findElement(By.xpath("//input[@id='input-4']")).sendKeys("/Users/umeshburraa/Downloads/Lord Shiva Wallpapers/Shiva.jpeg");
        WebElement removeBtn =driver.findElement(By.xpath("//button[@title='Clear selected files']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",removeBtn);
        Thread.sleep(3000);
        driver.close();
    }

    //@Test
    public static void doubleFiles(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/FileUpload.html");
        driver.manage().window().maximize();

        WebElement donotConsent = driver.findElement(By.xpath("//button[@aria-label='Do not consent']"));
        Actions action = new Actions(driver);
        action.moveToElement(donotConsent).click().perform();

        //location of the two files in the system
        String file1="/Users/umeshburraa/Downloads/Lord Shiva Wallpapers/Shiva.jpeg";
        String file2="/Users/umeshburraa/Downloads/Lord Shiva Wallpapers/Shiva1.jpeg";
        driver.findElement(By.xpath("//input[@id='input-4']")).sendKeys(file1+"\n"+file2);

        driver.close();

    }

}
