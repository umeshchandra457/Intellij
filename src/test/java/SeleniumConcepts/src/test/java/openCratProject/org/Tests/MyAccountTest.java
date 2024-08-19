package openCratProject.org.Tests;

import openCratProject.org.Resources.baseClass.SetUpClass;

import static openCratProject.org.Resources.baseClass.SetUpClass.browserSetupp;

public class MyAccountTest extends SetUpClass {

    //@BeforeTest(groups = {"Master","Login", "Register"})
    public static void setUp(){
        System.out.println("B E F O R E - M E T H O D -- L O G I N");
        browserSetupp("chrome");
    }
}
