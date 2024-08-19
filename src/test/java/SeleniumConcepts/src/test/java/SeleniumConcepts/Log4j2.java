package SeleniumConcepts;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;

public class Log4j2 {

    public static Logger logger  = LogManager.getLogger(Log4j2.class);;
    
    @Test
    public void test(){
        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Information");
        logger.error("Error");
        logger.fatal("Fatal");
    
    
    
       
    }
}
