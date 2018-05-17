package com.hmc.automation.steps;

import com.hmc.automation.drivers.BaseWebDriver;
import com.hmc.automation.drivers.ChromeWebDriver;
import com.hmc.automation.pages.CandidatePage;
import com.hmc.automation.pages.DashboardPage;
import com.hmc.automation.pages.LoginPage;
import com.hmc.automation.pages.WelcomePage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class StepDefinition {

    private static BaseWebDriver baseDriver = new ChromeWebDriver();

    @After
    public void after(){
        // could capture screenshots here and append on the report (@ end of each scenario)
        baseDriver.stopDriver();
    }

    @Given("^I am logged into HMC Portal")
    public void log_in() {
        LoginPage loginPage = PageFactory.initElements(baseDriver.getDriver(), LoginPage.class);
        loginPage.loginAs("Test.barcelona", "TestBCN1");
    }

    @Then("^I can see the Information Page displayed")
    public void information_page() {
        WelcomePage welcomePage = PageFactory.initElements(baseDriver.getDriver(), WelcomePage.class);
        Assert.assertTrue("Information Page was not displayed", welcomePage.isWelcomeModalPresented());
    }

    @When("^I rate the interview '(.*)' with a comment '(.*)' for candidate '(.*)' over '(.*)' for job '(.*)'$")
    public void user_add_comment_for_application(String stars, String comment, String candidate, String nextSteps, String job){
        DashboardPage dashboardPage =  PageFactory.initElements(baseDriver.getDriver(), DashboardPage.class);

        dashboardPage.selectApplication(job)
                .selectCandidate(candidate)
                .rateInterview(stars)
                .addComment(comment, nextSteps)
                .postReview();
    }

    @Then ("^I see my comment '(.*)' for '(.*)' with '(.*)'$")
    public void is_my_review_correct(String comments, String nextStep, String stars) {
        CandidatePage candidatePage = PageFactory.initElements(baseDriver.getDriver(), CandidatePage.class);

        Assert.assertTrue("My rating has not been persisted correctly", candidatePage.isMyCurrentRatingCorrect(stars, nextStep));
        Assert.assertTrue("My comment has not been persisted correctly", candidatePage.isCommentCorrect(comments, nextStep));
    }
}