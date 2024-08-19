package openCratProject.org.Resources.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {
    
    static Logger logger;
    public void logInfo(String msg){
        
        logger= LogManager.getLogger(this.getClass());
         logger.info(msg);
    }
    
}
