package com.hmc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidatePage  extends BasePage {

    private static final Map<String, String> rateMap = new HashMap<String, String>(){
        {
            put("1", "Fitting for different department");
            put("2", "C applicant");
            put("3", "B applicant");
            put("4", "A applicant");
            put("5", "Top");
        }
    };

    private static final String RATE_XPATH = "//*[contains(@title, '$OPTION$')]";

    @FindBy(id = "evaluationStatement")
    private WebElement commentInput;

    @FindBy(className = "c-evaluation__drop-down__btn")
    private WebElement nextStepDropdown;

    @FindBy(xpath = "//*[text()='Submit assessment']")
    private WebElement postReviewButton;

    @FindBy(className = "c-job-applicant__focus-item--sub-text")
    private WebElement reviewStep;


    public CandidatePage(WebDriver driver) {
        super(driver);
    }

    public CandidatePage addComment(String comment, String step) {
        click(nextStepDropdown);

        By stepLookup = By.xpath("//a[text()='" +  step + "']");
        WebElement stepItem = click(stepLookup) ;

        commentInput.sendKeys(comment);

        return this;
    }

    public CandidatePage rateInterview(String stars) {
        String rate = rateMap.get(stars);

        By rateLookUp = By.xpath(RATE_XPATH.replace("$OPTION$", rate));
        click(rateLookUp);

        return this;
    }

    public CandidatePage postReview(){
        click(postReviewButton);

        return this;
    }

    public Boolean isMyCurrentRatingCorrect(String stars, String nextStep){
        Boolean isCorrect = false;
        int totalStars = Integer.parseInt(stars);



        if (nextStep.equals(reviewStep.getText())) {

            //checking if all stars are with the correct state
            for (String rate : rateMap.keySet()){
                int starInt = Integer.parseInt(rate);

                By rateLookUp = By.xpath(RATE_XPATH.replace("$OPTION$", rateMap.get(rate)));
                WebElement star = find(rateLookUp);

                List<String> classes = getClasses(star);
                if (starInt <= totalStars) {
                    if (classes.contains("c-icon-svg__rating--active")){
                        isCorrect = true;
                    }
                } else if (classes.contains("c-icon-svg__rating--inactive")) {
                    isCorrect = true;
                }
            }
        };


        return isCorrect;
    }

    //TO-DO - based on new acceptance criteria
    public Boolean isPostedMyRatingCorrect(String stars, String nextStep){
        return false;
    }

    public Boolean isCommentCorrect(String comments, String nextStep) {
        Boolean isCorrect = false;

        By commentLookup = By.xpath("//*[contains(text(), '" + comments + "')]");
        WebElement element = find(commentLookup);
        if (element.isDisplayed()) {
            isCorrect = true;
        }

        return isCorrect;
    }
}
