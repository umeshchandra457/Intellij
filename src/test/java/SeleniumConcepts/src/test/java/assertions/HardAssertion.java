package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
    
    @Test
    public void asserts(){
        
//        Assert.assertEquals(false,true, "Both the values are match ");
//        Assert.assertTrue(1==1," Equal so true");
//        Assert.assertFalse(1==2," Not equal so false");
//        Assert.assertNotEquals(1,2, "not same so it is True");//
//        Assert.fail(" Should fail the test case");
        Assert.assertNull("nulllll","Should be null");
        System.out.println();
    }
}
