package openCratProject.org.Resources.pageObjects;

import openCratProject.org.Resources.baseClass.SetUpClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.awt.SystemColor.text;

public class HomePage extends SetUpClass {

    static By myaccounttab = By.xpath("//div//a//span[contains(text(),'My Account')]");
    static By register = By.xpath("//a[normalize-space()='Register']");
    static By adBrands = By.xpath("//*[@id='carousel0']/div/div/img");
    static By search= By.xpath("//input[@name='search']");
    static By searchBtn = By.xpath("//*[@id='search']/span/button");

    public static void myAccountBtn() {
        driver.findElement(myaccounttab).click();
    }
    public static RegisterAccountPage registerBtn(){driver.findElement(register).click();
        return new RegisterAccountPage();
    }
    public static void getBrands(){
        List<WebElement> ele= driver.findElements(adBrands);
        for(int i=0; i<ele.size(); i++) {// System.out.println(ele.get(i).getAttribute("alt")+"\t");
        }
        for(WebElement text: ele){System.out.print(text.getAttribute("alt")+"\t");}
    }
    public static void btnSearch(String product){driver.findElement(search).sendKeys(product);
    }
    public static void searchBtn(){driver.findElement(searchBtn).click();
    }
}
           
