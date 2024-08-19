package openCratProject.org.Resources.utilities;

import openCratProject.org.Resources.baseClass.SetUpClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class JavScriptClass extends SetUpClass {

    static JavascriptExecutor js = (JavascriptExecutor)driver;

    public static void click(WebElement locator){
        js.executeScript("arguments[0].click()", locator);
    }

    public static void scrollIntoView(WebElement locator){
        js.executeScript("arguments[0].scrollIntoView(true).click;", locator);
    }

    public static void scrollEndOfPage(){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight();");
    }

    public static void scrollBackToTop(){
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight();");
    }
    public static void zoomPage(){
       
        js.executeScript("documents.body.style.zoom='50%'");
        js.executeScript("documents.body.style.zoom='0%'");
    }
}
