package SeleniumConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframess {

    static WebDriver driver;

    @Test
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        frames();
    }

    public static void frames() {
        WebElement frame1 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
        String title = driver.switchTo().frame(frame1).getTitle();
        System.out.println(title);
        driver.findElement(By.name("mytext1")).sendKeys("Hello world");
        driver.switchTo().defaultContent();

        //Switching to Next frame
        WebElement frame3 = driver.findElement(By.xpath("/html/frameset/frameset/frame[2]"));
        String title3 = driver.switchTo().frame(frame3).getTitle();
        System.out.println(title3);
        driver.findElement(By.xpath("//*[@id=\"id3\"]/div/input")).sendKeys("Happy Selenium");

        //Switching to inner iframe
        WebElement frameI = driver.findElement(By.xpath("/html/body/center/iframe"));
        String titleIframe = driver.switchTo().frame(0).getTitle();
        System.out.println(titleIframe);
        driver.findElement(By.xpath("//*[@id='i5']")).click();
        driver.findElement(By.xpath("//*[@id='i11']/div[3]/div")).click();
        WebElement webTesting = driver.findElement(By.xpath("//*[@id='i19']"));
        webTesting.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webTesting));

        driver.quit();
    }
}
