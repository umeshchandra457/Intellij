package openCratProject.org.Resources.pageObjects;

import openCratProject.org.Resources.baseClass.SetUpClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RegisterAccountPage extends SetUpClass {
    
       
        static By fname = By.xpath("//input[@id='input-firstname']");
        static By lname = By.xpath("//input[@id='input-lastname']");
        static By email = By.xpath("//input[@id='input-email']");
        static By phone =By.xpath("//input[@id='input-telephone']");
        static By pword = By.xpath("//input[@id='input-password']");
        static By cpword =By.xpath("//input[@name='confirm']");
        static By privacypolicy =By.xpath("//input[@type='checkbox']");
        static By submit = By.xpath("//input[@value='Continue']");
        static By confrimMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
        static By continueBtn= By.xpath("//a[contains(text(),'Continue')]");
        static By myAccountTab = By.xpath("//div//a//span[contains(text(),'My Account')]");
        static By logoutBtn= By.xpath("//a[contains(text(),'Logout')]");
        
        public static void fNameM() {
            driver.findElement(fname).sendKeys("laxmi");
        }
        public static void lNameM() {
            driver.findElement(lname).sendKeys("Devi");
        }
        public static void emailM() {
            driver.findElement(email).sendKeys(generateEmail());
        }
        public static void phoneM() {
            driver.findElement(phone).sendKeys(generateNumber());
        }
        public static void pWordM() {
            driver.findElement(pword).sendKeys("devi");
        }
        public static void cpWordM() {
            driver.findElement(cpword).sendKeys("devi");
        }
        public static void privacyPolicyM() {
            driver.findElement(privacypolicy).click();
        }
         public static void myAccountBtn() {driver.findElement(myAccountTab).click();}
        public static void setLogoutBtn() {
        driver.findElement(logoutBtn).click();
    }
        public static void submitBtnM() {
    
            //Different types of click
            WebElement click = driver.findElement(submit);
            //JavScriptClass.click(click);
            //fluentWait(click);
            //click.submit();            
            click.sendKeys(Keys.RETURN);
        }
        public static void confrimMessageM() {
                String text =driver.findElement(confrimMessage).getText();
                System.out.println(text);
        }
        public static MyAccountPage continueBtn(){
            driver.findElement(continueBtn).click();
            return new MyAccountPage();
        }
}
