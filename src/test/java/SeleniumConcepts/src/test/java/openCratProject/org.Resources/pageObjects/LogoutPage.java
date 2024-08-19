package openCratProject.org.Resources.pageObjects;

import openCratProject.org.Resources.baseClass.SetUpClass;
import org.openqa.selenium.By;

import static openCratProject.org.Resources.baseClass.SetUpClass.titleofthePage;

public class LogoutPage extends SetUpClass {
    
    static By continueBtn= By.xpath("//a[contains(text(),'Continue')]");

    public static void setContinueBtnLout(){
        driver.findElement(continueBtn).click();
    }
    public static void title(){
        titleofthePage();
    }
}
