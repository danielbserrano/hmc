package com.hmc.automation.drivers;

import org.openqa.selenium.WebDriver;

public abstract class BaseWebDriver {

    protected static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            startDriver();
        }

        return driver;
    }

    public void stopDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public abstract void startDriver();
}
