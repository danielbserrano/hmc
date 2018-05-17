package com.hmc.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "input_UserName")
    @CacheLookup
    private WebElement userInput;

    @FindBy(id = "input_password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(css = "button[name='Login']")
    @CacheLookup
    private WebElement loginButton;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public WelcomePage loginAs(String username, String password) {
        wait(userInput);

        typeUsername(username);
        typePassword(password);
        submitLogin();

        return PageFactory.initElements(driver, WelcomePage.class);
    }

    private void typeUsername(String username){
        userInput.sendKeys(username);
    }

    private void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    private void submitLogin(){
        loginButton.click();
    }


}