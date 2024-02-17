package automationUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;

public class BaseSteps {
    public static WebDriver driver;
    private Properties prop;
    private String applicationURL;
    private String browser;
    public void openURL(){
        prop=new Properties();
        try {
            prop.load(BaseSteps.class.getClassLoader().getResourceAsStream("configuration.properties"));
            applicationURL=prop.getProperty("appURL");
            browser=prop.getProperty("browser");
            if(browser.equalsIgnoreCase("chrome")){
                driver=new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("edge")){
                driver= new EdgeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox")){
                driver= new FirefoxDriver();
            }
            else{
                driver=null;
                System.out.println("Invalid browser type");
            }
            driver.get(applicationURL);
            driver.manage().window().maximize();
            System.out.println("Navigated to application");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("driver is closed");
    }
}
