package SeleniumConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    static WebDriver driver;
    @Test
    public static void links(){


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com");
        System.out.println(driver.getTitle());


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        int noOfBrokenLinks=0;

        for(WebElement ele: links){
            String hrefLinks = ele.getAttribute("href");
            if(hrefLinks ==null || hrefLinks.isEmpty()){
                System.out.println("href attribute value is null or empty,Link not found ");
                continue;
            }
            try{
                URL url = new URL(hrefLinks);
                HttpURLConnection httpsCon = (HttpURLConnection) url.openConnection();
                httpsCon.connect();

                if(httpsCon.getResponseCode()>= 400) {
                    System.out.println(hrefLinks + "  .....Broken Link Found");
                    noOfBrokenLinks++;
                }
                else {
                    System.out.println(hrefLinks+" ...No Broken link found");
                }
            }catch(Exception e ){
                e.getStackTrace();
            }
        }
        System.out.println(noOfBrokenLinks+" Number of Links");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
