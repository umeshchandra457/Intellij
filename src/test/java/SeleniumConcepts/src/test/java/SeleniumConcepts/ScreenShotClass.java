package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.io.File;


public class ScreenShotClass extends SetUpClass{

    //"/Users/umeshburraa/eclipse-workspace-2024/ConceptsSelenium/screenshot/image.png");
    
    public static void takeScreenShot(){

        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);

        String path= System.getProperty("user.dir")+"/target/Screenshots/";
        File file= new File(path+"image.png");
        String name= file.getName();
        System.out.println(name);
        source.renameTo(file);

        //Get screenshot for specific section of the page
        WebElement pageSection=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div"));
        File sectionPage =pageSection.getScreenshotAs(OutputType.FILE);
        String nameSec= sectionPage.getName();
        System.out.println(nameSec);
        file =new File("/Users/umeshburraa/eclipse-workspace-2024/ConceptsSelenium/screenshot/sectionPage2.png");
        sectionPage.renameTo(file);

    }
    
    public static void screenShotmethod(String fileLocation){

        String path= System.getProperty("user.dir")+fileLocation;
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);

        File file= new File(path+"image.png");
        source.renameTo(file);
    }
    
    public static String base64ScreenShot(){
        //String path= System.getProperty("user.dir")+fileLocation;
        TakesScreenshot ts= (TakesScreenshot)driver;
        String source= ts.getScreenshotAs(OutputType.BASE64);
        return source;
        
    }



}
