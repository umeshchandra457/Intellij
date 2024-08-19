package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllTests {
	 @BeforeMethod(groups = "Functional")
	    public void beforeMethod(){
	        System.out.println("BeforeMethod----Functional");
	    }
	 @BeforeClass(groups = {"Functional","Master"})
	    public void beforeClass(){System.out.println("BeforeClass");}
	 @AfterMethod(groups = {"Master","Sanity", "Regression"})
	    public void afterMethod(){
	        System.out.println("AfterMethod---Master,Sanity, Regression");
	    }
	 @AfterClass
	    public void afterClass(){
	        System.out.println("AfterClass");
	    }
	 @Test(groups = "Functional")
	    public void test2(){
	        System.out.println("Functional---TEST2");
	    }
	 @Test(groups = "Functional")
	    public void test1(){
	        System.out.println("Functional---TEST1");
	    }
	 @Test(groups = {"Master","Sanity", "Regression"})
	    public void test3(){
	        System.out.println("Master---Sanity---Regression");
	    }
	    

}
