package testNG;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class ParameterClass {
    @BeforeClass
    @Parameters({"browser"})
    public static void beforeclass(String br) {

        switch(br) {
        case "chrome": System.out.println("Chrome Browser Openig....");
        break;
        case "edge":System.out.println("Edge Browser Openig....");
        break;
        case "firefox": System.out.println("Firefox Browser Openig....");
        break;
        default: System.out.println("No Browser Is found"); return;
    }
}
@Test(priority=1)//,dependsOnMethods = "beforeclass")
public static void testClass() {
    
        System.out.println("T  e  s  t  i  n  g - C  l  a  s  s");
}
@Test(priority=2)//(dependsOnMethods = "beforeclass")
public static void testClass1() {
    System.out.println("T  e  s  t  i  n  g - C  l  a  s  s  11");
}
@AfterClass
public static void closingClass() {
    System.out.println("Closing  Class");
}

}
