package dependencyGrouping;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Application {
    
    @BeforeMethod
    public static void login(){
        System.out.println("Login method");
        
    }
    @AfterMethod
    public static void logout(){
        System.out.println("Logout Method");
    }
    @Test(dependsOnMethods = "search")
    public static void adsearch(){
        System.out.println("Actual Test");//Depends on the search method
    }
    @Test
    public static void search(){
        System.out.println("Actual Test");
        Assert.fail();
    }
}
