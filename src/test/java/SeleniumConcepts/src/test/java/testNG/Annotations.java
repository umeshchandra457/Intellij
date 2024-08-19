package testNG;

import org.testng.annotations.*;

public class Annotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }
    @BeforeClass
    public void beforeClass(){

        System.out.println("BeforeClass");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("BeforeSuit");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("AfterSuit");
    }
    @Test
    public void test2(){
        System.out.println("TEST2---TEST2---TEST2");
    }
    @Test
    public void test1(){
        System.out.println("TEST1---TEST1---TEST1");
    }
}
