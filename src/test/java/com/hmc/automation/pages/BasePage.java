package com.hmc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.Arrays.asList;

public class BasePage {

    private static final int DEFAULT_TIMEOUT_IN_MILLISECONDS = 10000;
    private static final int DEFAULT_POOLING_IN_MILLISECONDS = 500;


    WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }


    public void wait(WebElement element) {
        wait(element, DEFAULT_TIMEOUT_IN_MILLISECONDS, DEFAULT_POOLING_IN_MILLISECONDS);
    }

    public void wait(WebElement element, int timeoutInMilli, int poolingInMilli) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInMilli/1000);
        wait.pollingEvery(poolingInMilli, TimeUnit.MILLISECONDS);

        ExpectedCondition condition = ExpectedConditions.visibilityOf(element);

        wait.until(condition);
    }

    public WebElement find (By criteria) {
        Function<WebDriver, WebElement> function = driver1 -> driver1.findElement((By) criteria);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(DEFAULT_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
                .pollingEvery(DEFAULT_POOLING_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(function);
    }

    public <T> WebElement click(T criteria) {
        WebElement element;

        if (criteria.getClass().getName().contains("By")){
            Function<WebDriver, WebElement> function = driver1 -> driver1.findElement((By) criteria);
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(DEFAULT_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
                    .pollingEvery(DEFAULT_POOLING_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);

            element = wait.until(function);
        } else {
            element = (WebElement) criteria;
        }

        waitLoading();
        element.click();

        return element;
    }

    public void waitLoading(){

        try {
            Thread.sleep(DEFAULT_POOLING_IN_MILLISECONDS);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

    }

    public List<String> getClasses(WebElement element) {
        List<String> classes = new ArrayList<>(asList(element.getAttribute("class").replaceAll(" ", ",").split(",")));
        return classes;
    }
}
