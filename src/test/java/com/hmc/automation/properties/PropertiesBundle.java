package com.hmc.automation.properties;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesBundle {

    private static final String PROPERTY_BASE_NAME = "src/test/resources/hmc.properties";

    private static Properties properties;

    private static void loadProperties(){
        try {
            properties = new Properties();
            InputStream input = new FileInputStream(PROPERTY_BASE_NAME);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getPropertyBundle() {
        if (properties == null) {
            loadProperties();
        }

        return properties;
    }
}
