package openCratProject.org.Resources.utilities;

import java.text.DateFormat;
import java.util.Date;

public class DateTimeStamp {
    
    public static String getDateTimeStamp() {
        DateFormat DF = DateFormat.getDateTimeInstance();
        String dateVal = DF.format(new Date());
        dateVal = dateVal.replaceAll("/", "-");
        dateVal = dateVal.replaceAll(",", "-");
        // dateVal = dateVal.replaceAll(":", "_");
        dateVal = dateVal.replaceAll(" ", "-");

        return dateVal;
    }
}
