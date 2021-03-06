package com.metronet.mis.utilities.ui;

import com.metronet.mis.utilities.common.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * A driver focused class to manipulate random processes
 */
public class Driver
{
    private static final Logger logger = Logger.getLogger(Driver.class);
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    //with private Constructor no one can create object of Driver class
    //everyone should call static getter method instead
    private Driver()
    {

    }

    /**
     * synchronized makes method safe. It ensures that only 1 thread can use it at the time.
     * <p>
     * thread safety reduces performance but it makes everything safe
     *
     * @return
     */
    public synchronized static WebDriver getDriver()
    {
        //if webdriver object doesn't exist
        //create it
        if (driverPool.get() == null)
        {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            if (System.getProperty("browser") != null)
            {
                browser = System.getProperty("browser");
            }

            switch (browser)
            {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions1 = new ChromeOptions();
                    chromeOptions1.setHeadless(true);
                    driverPool.set(new ChromeDriver(chromeOptions1));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    logger.error("Wrong browser name :: " + browser);
                    throw new RuntimeException("Wrong browser name :: " + browser);
            }
        }
        return driverPool.get();
    }

    public static void closeDriver()
    {
        if (driverPool.get() != null)
        {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
