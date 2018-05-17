package com.hmc.automation.properties;

public class ApplicationProperties {

    public static String getProperty (PropertyKey key) {
        return getPlainProperty(key.getProperty());
    }

    public static String getProperty (String key) {
        return getPlainProperty(key);
    }

    public static String getPlainProperty (String key) {
        return PropertiesBundle.getPropertyBundle().getProperty(key);
    }
}
