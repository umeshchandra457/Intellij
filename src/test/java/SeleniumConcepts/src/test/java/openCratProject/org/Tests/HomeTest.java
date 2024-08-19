package openCratProject.org.Tests;

import openCratProject.org.Resources.baseClass.SetUpClass;
import org.testng.annotations.*;

import static openCratProject.org.Resources.pageObjects.HomePage.btnSearch;
import static openCratProject.org.Resources.pageObjects.HomePage.getBrands;

public class HomeTest extends SetUpClass {

    @BeforeTest//(groups = {"Master","Login", "Register"})
    public static void setUp(){
        System.out.println("B E F O R E - M E T H O D -- L O G I N");
        browserSetupp("chrome");
    }
    @Test
    public  void homeTest(){
        getBrands();
        btnSearch("Mac");
    }
    
}
