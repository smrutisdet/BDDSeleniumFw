package automationUtilities;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.util.Properties;

/**
 * The BrowserFactory class provides methods to set up and manage WebDriver instances
 * for different browsers in a multithreaded environment.
 */
public class BrowserFactory {
    /**
     * ThreadLocal storage for WebDriver instances to ensure thread safety.
     * ThreadGuard ensures that a driver is used only by the thread that created it.
     */
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Logger log;
    private Properties prop;
    private String browserName;
    private String applicationURL;

    /**
     * Sets up the WebDriver instance based on the browser specified in the configuration properties.
     *
     * @return the WebDriver instance for the current thread
     */
    public WebDriver browserSetup() {
        try {
            log = LogManager.getLogger(this.getClass().getName());
            prop = new Properties();
            prop.load(BrowserFactory.class.getClassLoader().getResourceAsStream("configuration.properties"));
            browserName = prop.getProperty("browser");
            log.info("Browser is " + browserName);
            if (browserName.equalsIgnoreCase("chrome")) {
                driver.set(ThreadGuard.protect(new ChromeDriver()));
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver.set(ThreadGuard.protect(new EdgeDriver()));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver.set(ThreadGuard.protect(new FirefoxDriver()));
            } else {
                log.info("Unsupported browser is passed: " + browserName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDriverInstance();
    }

    /**
     * Retrieves the WebDriver instance for the current thread.
     *
     * @return the WebDriver instance for the current thread
     */
    public static synchronized WebDriver getDriverInstance() {
        return driver.get();
    }
}