package openCratProject.org.Tests;

import openCratProject.org.Resources.baseClass.ParallelTesting;
import openCratProject.org.Resources.baseClass.SetUpClass;
import openCratProject.org.Resources.pageObjects.LoginPage;
import openCratProject.org.Resources.pageObjects.MyAccountPage;
import openCratProject.org.Resources.pageObjects.LogoutPage;
import openCratProject.org.Resources.utilities.DataProviders;
import openCratProject.org.Resources.utilities.LoggerClass;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Arrays;
import static openCratProject.org.Resources.baseClass.SetUpClass.*;


public class LoginTest extends SetUpClass {
    
    //This is for Test Class Run
    //@BeforeTest(groups = {"Master","Login", "Register"})
    public static void setUp(){
        System.out.println("B E F O R E - M E T H O D -- L O G I N");
        browserSetupp("chrome");
    }
    @Test(groups = {"Master","Login"})
    public static void loginTest() {
        
            LoginPage.setMyAccountTab();
            LoginPage.setLoginTab();
            Assert.assertEquals(titleofthePage(), "Account Login", "Login Account Title");

            LoginPage.setEmail();
            LoginPage.setPassword();

            MyAccountPage maAccount = LoginPage.setSubmitBtn();
            boolean targetPage = maAccount.isMyAccountPageExists();
            Assert.assertEquals(titleofthePage(), "My Account", "My Account Title");

            MyAccountPage.MyAccountTabMPage();
            LogoutPage logout = MyAccountPage.clickLogout();
            Assert.assertEquals(titleofthePage(), "Account Logout", " Account Logout Title");

            LogoutPage.setContinueBtnLout();
            Assert.assertEquals(titleofthePage(), "Your Store", " Account Logout Title");

        
    }
    //@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public static void loginTestDDT(String email,String password, String result){
        
        try{
        LoginPage.setMyAccountTab();
        LoginPage.setLoginTab();
        Assert.assertEquals(titleofthePage(), "Account Login","Login Account Title");
        
        LoginPage.setEmailDDT(email);
        LoginPage.setPasswordDDT(password);
        
        MyAccountPage maAccount =LoginPage.setSubmitBtn();
        boolean targetPage = maAccount.isMyAccountPageExists();
        Assert.assertEquals(titleofthePage(), "My Account", "My Account Title");

        MyAccountPage.MyAccountTabMPage();
        LogoutPage logout =MyAccountPage.clickLogout();
        Assert.assertEquals(titleofthePage(), "Account Logout"," Account Logout Title");
        
        LogoutPage.setContinueBtnLout();
        Assert.assertEquals(titleofthePage(), "Your Store"," Account Logout Title");

        if(result.equalsIgnoreCase("Valid")) {
            
            if (targetPage) {
                 MyAccountPage.clickLogout();
                 Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
        if(result.equalsIgnoreCase("Invalid")) {
            if(targetPage)
            {
                MyAccountPage.clickLogout();
                Assert.fail();
            }
            else {
                Assert.assertTrue(true);
            }
        }
    }catch(Exception e)
    {
        StackTraceElement[] stackTrace = e.getStackTrace();
        System.out.println(Arrays.toString(stackTrace));
        //Assert.fail();
    }
    }
    
    /*@Parameters("browser")
    @BeforeTest(groups = {"Master","Login", "Register"})
    public static void startUp() {

        log= new LoggerClass();
        log.logInfo("Browser  Started");
        //browserSetup("chrome");
        //ParallelTesting.parallelTesting("firefox");
    }
    @AfterTest (groups = {"Master","Login", "Register"})
    public static void closeBrowser() {
        log= new LoggerClass();
        log.logInfo("Browser  Closed");
        tearDown();
    }*/
}
