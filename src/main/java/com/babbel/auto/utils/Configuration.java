package com.babbel.auto.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static final Properties properties;
    private final static Logger LOGGER = LogManager.getLogger(Configuration.class);

    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream= new FileInputStream(Constants.CONFIG_PATH);
            properties.load(fileInputStream);
        } catch (IOException ex) {
            throw new RuntimeException("It was not able to read " + Constants.CONFIG_PATH + " Properties file.");
        }
    }

    private Configuration() {
        // Not able to create an instance
    }

    /**
     * Retrieve property of Configuration file.
     *
     * @param name property key
     * @return property value
     */
    public static String getPropertyValue(String name) {
        return properties.getProperty(name);
    }
}
