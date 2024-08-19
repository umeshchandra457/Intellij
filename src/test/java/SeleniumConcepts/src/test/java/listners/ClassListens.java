package listners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

@Listeners(listners.ListnersClass.class)
public class ClassListens {
	
	 	@Test(priority = 1)
	    public void test2(){
	        System.out.println("TEST2---TEST2---TEST2");
	        AssertJUnit.assertTrue(false);
	    }
	    @Test(priority = 2)
	    public void test1(){
	        System.out.println("TEST1---TEST1---TEST1");
	    }
	    @Test(dependsOnMethods = "test2")
	    public void test3(){
	        System.out.println("TEST3---TEST3---TEST3");
	    }

}
