package automationUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.util.Properties;

/**
 * The BaseSteps class provides utility methods for setting up and interacting with web drivers.
 */
public class BaseSteps {
    //public static WebDriver driver;
    private Properties prop;
    private String applicationURL;
    private String browser;
    private Logger log;

    /**
     * Opens the application URL in the specified WebDriver instance.
     *
     * @param driver the WebDriver instance to use for opening the URL
     */
    public void openURL(WebDriver driver) {
        prop = new Properties();
        try {
            log = LogManager.getLogger(this.getClass().getName());
            prop.load(BaseSteps.class.getClassLoader().getResourceAsStream("configuration.properties"));
            applicationURL = prop.getProperty("appURL");
            driver.get(applicationURL);
            driver.manage().window().maximize();
            log.info("Navigated to application");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}