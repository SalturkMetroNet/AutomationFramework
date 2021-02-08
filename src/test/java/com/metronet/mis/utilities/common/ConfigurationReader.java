package com.metronet.mis.utilities.common;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * A Class containing necessary methods to read from configuration.properties
 */
public class ConfigurationReader
{
    private static Properties configFile;

    static
    {
        try (FileInputStream input = new FileInputStream("configuration.properties"))
        {
            configFile = new Properties();
            configFile.load(input);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration.properties file
     *
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName)
    {
        return configFile.getProperty(keyName);
    }
}
