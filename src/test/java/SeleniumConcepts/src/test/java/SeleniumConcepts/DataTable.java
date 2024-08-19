package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DataTable extends SetUpClass{

    static WebDriver driver;


    //For-each or Enhanced for Loop.
    public static void dataTable() {
        List<WebElement> data = driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr/td"));
        for (WebElement ele : data) {
            System.out.println(ele.getText());
        }
    }

    public static void records() {
        boolean value= false;
        int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
        System.out.println("Number of Rows " + row);

        int col = driver.findElements(By.xpath("//table[@class='table table-striped']//tr/th")).size();
        System.out.println("Number of Column " + col);

        for (int i = 1; i <row; i++) {
            for (int j = 1; j<=col; j++) {
                String text = driver.findElement(By.xpath("//div[@class='table-responsive']//table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println(text);
                if(text.contains("System")){
                    value= true;
                    break;
                }
                value=false;
            }
        }
    }

    @Test
    public void testMethod() {

        dataTable();
        //records();
    }

    @AfterMethod
    public static void tearDown() {

        //driver.close();
        //driver.quit();
    }
}
