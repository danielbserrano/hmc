package com.hmc.automation.properties;

public enum PropertyKeyImpl implements PropertyKey {

    DRIVER("hmc.automation.driver"),
    DRIVER_PATH("hmc.automation.driver.path"),
    BASE_URL("hmc.automation.url");

    private String property;

    PropertyKeyImpl (String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

}
