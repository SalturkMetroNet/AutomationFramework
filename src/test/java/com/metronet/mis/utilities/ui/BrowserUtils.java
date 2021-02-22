package com.metronet.mis.utilities.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BrowserUtils
{
    private static final Logger logger = Logger.getLogger(BrowserUtils.class);

    /**
     * A custom method to wait without any type of condition attached to it
     *
     * @param seconds amount of seconds to wait for
     */
    public static void wait(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * A method which wait until the Web Element
     *
     * @param max how much should the method wait to throw exception (timelimit)
     */
    public static void impWait(int max)
    {
        Driver.getDriver().manage().timeouts().implicitlyWait(max, TimeUnit.SECONDS);
    }

    /**
     * This method takes a screenshot and saves it with a date&time stamp.
     *
     */
    public static void takeAScreenshotAndSave(String testName)
    {
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + testName + "/";
        path = path.replace("/", File.separator);
        File file = new File(path);
        file.mkdirs();
        path += "screenshot.jpeg";
        path += dateFormat.format(date) + "screenshot.jpeg";
        try (OutputStream outputStream = new FileOutputStream(path))
        {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            outputStream.write(screenshot);
        }
        catch (IOException e)
        {
            logger.error(e);
            e.printStackTrace();
            throw new RuntimeException("Failed to create a screenshot :: " + path);
        }
        logger.info("Screenshot saved here :: " + path);
    }
}
