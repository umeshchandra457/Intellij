package openCratProject.org.Tests;


import openCratProject.org.Resources.baseClass.ParallelTesting;
import openCratProject.org.Resources.baseClass.SetUpClass;
import openCratProject.org.Resources.pageObjects.HomePage;
import openCratProject.org.Resources.pageObjects.MyAccountPage;
import openCratProject.org.Resources.pageObjects.RegisterAccountPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static openCratProject.org.Resources.baseClass.SetUpClass.*;

public class RegisterTest extends SetUpClass {

    
    @BeforeTest(groups = {"Master","Login", "Register"})
    public static void setUp(){
        System.out.println("B E F O R E - M E T H O D -- R E G I S T E R");
         browserSetupp("chrome");
    }
    @Test(groups = {"Master","Register"})
    public void registerTest() {
        
        try {
            //logger.info("Home page starting.....");
            HomePage.myAccountBtn();
            RegisterAccountPage registerPage = HomePage.registerBtn();

            //logger.info("Registration Page started.....");
            //Registration PAge
            RegisterAccountPage.fNameM();
            RegisterAccountPage.lNameM();
            RegisterAccountPage.emailM();
            RegisterAccountPage.pWordM();
            RegisterAccountPage.cpWordM();
            RegisterAccountPage.phoneM();
            RegisterAccountPage.privacyPolicyM();
            RegisterAccountPage.submitBtnM();
            RegisterAccountPage.confrimMessageM();
            Assert.assertEquals(titleofthePage().trim(), "Your Account Has Been Created!");
            
            //MyAccount Page
            MyAccountPage maAccount = RegisterAccountPage.continueBtn();
            Assert.assertEquals(titleofthePage(), "My Account");
            RegisterAccountPage.myAccountBtn();
            RegisterAccountPage.setLogoutBtn();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    /*@Parameters("browser")
    @BeforeTest//(groups = {"Master","Sanity", "Regression"})
    public static void startUp() {

        //logger.info("Browser Started.....");
        //browserSetup("chrome");
        //ParallelTesting.parallelTesting("chrome");

    }
    @AfterTest//(groups = {"Master","Sanity", "Regression"})
    public static void closeBrowser() {tearDown();
    }*/
    
}
