package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;

public class SoftAssertions {
    SoftAssert sa= new SoftAssert();
    
    @Test
    public void hardAssert(){

        System.out.println("before the assert Printing the statemenet");
        Assert.assertEquals(false,true);
        System.out.println("After the assert Printing the statemenet");
    }
    @Test //This test will show as passed even its execution is failed
    public void softAssert(){
        
        System.out.println("before the assert Printing the statemenet");
        sa.assertEquals(false,true);
        System.out.println("After the assert Printing the statemenet");
        
    }
    @Test //This test execute all the test even if one of the test it won't skip the test
    public void softAssertAll(){
        
        System.out.println("before the assert Printing the statemenet");
        sa.assertEquals(false,true);
        System.out.println("Soft AssertAll.....Statment");
        System.out.println("After the assert Printing the statemenet");
        sa.assertAll();
    }
}
