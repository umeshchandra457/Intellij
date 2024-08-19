package SeleniumConcepts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class GridClass {
	
	 WebDriver driver;
	
	@Test
	
	public  void gridTest() throws MalformedURLException{
	
	DesiredCapabilities cap= new DesiredCapabilities();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.MAC);
	
	
	WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.123:4444"), cap);
	
	driver.get("https://tutorialsninja.com/demo/");
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.get("https://tutorialsninja.com/demo/");
    driver.close();
    driver.quit();
	}

	
}
