package openCratProject.org.Resources.baseClass;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver>  drive= new ThreadLocal<>(); 
	
	public static WebDriver getDriver() {
		return drive.get();
	}
	public static void setDriver(WebDriver driver) {
		drive.set(driver);
	}
    public static void unload() {
    	drive.remove();
    	
    }
	
}
