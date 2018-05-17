package com.hmc.automation.drivers;

import com.hmc.automation.properties.ApplicationProperties;
import com.hmc.automation.properties.PropertyKey;
import com.hmc.automation.properties.PropertyKeyImpl;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver extends BaseWebDriver {

    @Override
    public void startDriver() {
        System.setProperty(ApplicationProperties.getProperty(PropertyKeyImpl.DRIVER), ApplicationProperties.getProperty(PropertyKeyImpl.DRIVER_PATH));

        //Any chrome specific capabilities could be setup here

        driver = new ChromeDriver();

        //initialization of the test

        driver.navigate().to(ApplicationProperties.getProperty(PropertyKeyImpl.BASE_URL));
        driver.manage().window().maximize();
    }
}
