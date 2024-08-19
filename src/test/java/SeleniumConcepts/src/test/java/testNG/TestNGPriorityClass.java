package testNG;

import org.testng.annotations.Test;

public class TestNGPriorityClass {

    @Test(priority = 1)
    public void openApplication(){
        System.out.println("Regression Application Opening");
    }
    @Test(priority = 2)
    public void login(){
        System.out.println("login Opening");
    }
    @Test(priority = 3)
    public void logout(){
        System.out.println("logout Opening");
    }
    @Test(priority = -1)
    public void minusONe(){
        System.out.println("MinusOne Opening");
    }
    @Test
    public void defaultt(){
        System.out.println("Sanity, Master,--- Opening");
    }

}
