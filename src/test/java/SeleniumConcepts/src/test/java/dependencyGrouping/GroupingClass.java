package dependencyGrouping;

import org.testng.annotations.Test;

public class GroupingClass {

    @Test(priority = 1, groups= {"Sanity"})
    public void test2(){
        System.out.println("S  A  N   I   T   Y \n");
    }
    @Test(priority = 1, groups= {"Regrresion"})
    public void test1(){
        System.out.println("R   E   G   R  R  E  S  S  I  O  N\n");
    }
    @Test(priority = 1, groups= {"Sanity","Regression","Functional"})// functional will execute both sanity AND Regression
    public void test3(){
        System.out.println("S  A  N   I   T   Y---R   E   G   R  R  E  S  S  I  O  N");
    }
}
