package dataProvider;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    
    @BeforeClass
    public void setUp(){
        System.out.println("-----Pre Requistes");
    }
    @Test(dataProvider ="dp")
    public void test(String value, String key){
        System.out.println(value+"------"+key);
    }
    @AfterClass
    public void tearDown(){

        System.out.println("-----Closing the class");
    }
    @DataProvider(name="dp", indices = {0,2,3})
    public Object[][] dataMethod() {

        Object[][] data = {
                {"Lock", "Key"},
                {"Tv", "Remote"},
                {"Vehicle", "Engine"},
                {"Table", "Chair"}
        };

        return data;
    }
}
