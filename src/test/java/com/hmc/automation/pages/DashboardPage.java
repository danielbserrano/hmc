package com.hmc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    private static final String APPLICATION_CONTAINER_XPATH = "//*[text()='$OPTION$']";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public ApplicationsPage selectApplication (String application) {
        By applicationToBeSelected = By.xpath(APPLICATION_CONTAINER_XPATH.replace("$OPTION$", application));
        click(applicationToBeSelected);
        return PageFactory.initElements(driver, ApplicationsPage.class);
    }
}