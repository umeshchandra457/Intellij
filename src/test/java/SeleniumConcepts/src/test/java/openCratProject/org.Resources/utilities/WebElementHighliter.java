package openCratProject.org.Resources.utilities;

import openCratProject.org.Resources.baseClass.SetUpClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebElementHighliter extends SetUpClass {
    public WebElement findElement(By by) throws Exception
    {
        WebElement elem = driver.findElement(by);
        if (driver instanceof JavascriptExecutor)
        {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
        }
        return elem;
    }

}
