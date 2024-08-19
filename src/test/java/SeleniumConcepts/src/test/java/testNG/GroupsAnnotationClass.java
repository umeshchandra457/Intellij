package testNG;

import org.testng.annotations.Test;

public class GroupsAnnotationClass {

    @Test(groups = {"Sanity", "Master"})
    public void sanity(){
        System.out.println("Sanity -----");
    }
    @Test(groups = {"Regression","Master"})
    public void Regression(){
        System.out.println("Regression-----");
    }
    @Test(groups = "Master")
    public void allGroup(){
        System.out.println("Master, Sanity, Regression");
    }
    @Test
    public void minusONe(){
        System.out.println("MinusOne Opening");
    }
}
