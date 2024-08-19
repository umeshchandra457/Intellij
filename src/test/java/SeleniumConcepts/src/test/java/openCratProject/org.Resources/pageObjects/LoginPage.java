package openCratProject.org.Resources.pageObjects;

import openCratProject.org.Resources.baseClass.SetUpClass;
import openCratProject.org.Resources.utilities.JavScriptClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends SetUpClass {

    static By myaccounttab = By.xpath("//div//a//span[contains(text(),'My Account')]");
    static By loginTab= By.xpath("//ul//li//a[contains(text(),'Login')]");
    static By email = By.xpath("//input[@id='input-email']");
    static By password = By.xpath("//input[@id='input-password']");
    static By submitBtn = By.xpath("//div//input[@type='submit']"); 
    static By logOutBtn =By.xpath("//a[contains(text(),'Logout')]");
    
    public static void setMyAccountTab(){
        driver.findElement(myaccounttab).click();
    }
    public static void setLoginTab(){
        driver.findElement(loginTab).click();
    }
    public static void setEmailDDT(String emailData){
        driver.findElement(email).sendKeys(emailData);
    }
    public static void setPasswordDDT(String passwordData){
        
        driver.findElement(password).sendKeys(passwordData);
    }
    public static void setEmail(){
        driver.findElement(email).sendKeys(loadConfig("emailId"));
        
    }
    public static void setPassword(){
        driver.findElement(password).sendKeys(loadConfig("password"));
        
    }
    public static MyAccountPage setSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new MyAccountPage();
    }
    public static LogoutPage setLogOutBtn(){
        WebElement element =driver.findElement(logOutBtn);
        JavScriptClass.click(element);
        return new LogoutPage();
    }
    
}
