package com.hmc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ApplicationsPage extends BasePage {

    private static final String CANDIDATE_CONTAINER_XPATH = "//*[text()='$OPTION$']";

    public ApplicationsPage(WebDriver driver) {
        super(driver);
    }

    public CandidatePage selectCandidate (String candidate) {
        By applicationToBeSelected = By.xpath(CANDIDATE_CONTAINER_XPATH.replace("$OPTION$", candidate));
        click(applicationToBeSelected);

        return PageFactory.initElements(driver, CandidatePage.class);
    }
}
