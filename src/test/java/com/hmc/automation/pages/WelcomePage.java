package com.hmc.automation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {


    @FindBy(xpath = "//*[contains(text(), 'Welcome to our new Hiring Manager!')]")
    @CacheLookup
    private WebElement welcomeModal;

    public WelcomePage (WebDriver driver) {
        super(driver);
    }

    public Boolean isWelcomeModalPresented(){
        boolean isCorrect = false;

        try {
            if (welcomeModal.isDisplayed()) {
                isCorrect = true;
                //could check other itens here;
            }
        } catch (NoSuchElementException e) {
            //If we want a cleaner report. Otherwise, we could remove the try/catch.
            isCorrect = false;
        }

        return isCorrect;
    }
}
