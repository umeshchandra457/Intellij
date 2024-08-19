package openCratProject.org.Resources.pageObjects;

import openCratProject.org.Resources.baseClass.SetUpClass;
import openCratProject.org.Resources.utilities.JavScriptClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage extends SetUpClass {

    static By myaccounttab = By.xpath("//div//a//span[contains(text(),'My Account')]");
    static By logOutBtn = By.xpath("//a[contains(text(),'Logout')]");
    static By msgHeading = By.xpath("//h2[contains(text(),'My Account')]");

    public static void MyAccountTabMPage() {
        driver.findElement(myaccounttab).click();
    }

    public static LogoutPage clickLogout() {
        WebElement element = driver.findElement(logOutBtn);
        JavScriptClass.click(element);
        return new LogoutPage();
    }

    public static void title() {
        titleofthePage();
    }

    public boolean isMyAccountPageExists() {
        try {
            return (driver.findElement(msgHeading).isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }
}
