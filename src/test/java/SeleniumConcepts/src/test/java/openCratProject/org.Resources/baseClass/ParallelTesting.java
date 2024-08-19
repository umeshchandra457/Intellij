package openCratProject.org.Resources.baseClass;

import java.net.MalformedURLException;

import static openCratProject.org.Resources.baseClass.SetUpClass.browserSetup;

public class ParallelTesting{
    public static void parallelTesting(String br, String os) throws MalformedURLException {
    
    switch (br.toLowerCase()) {
        case "chrome":
            browserSetup("chrome", "macbook");
            break;
        case "safari":
            browserSetup("safari", "macbook");
            break;
        case "edge":
            browserSetup("edge", "macbook");
            break;
        case "firefox":
            browserSetup("firefox", "macbook");
            break;
        default:
            System.out.println("Browser not found");
            return;
    }}

}