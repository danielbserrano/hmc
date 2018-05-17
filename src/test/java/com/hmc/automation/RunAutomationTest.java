package com.hmc.automation;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", format = {
        "json:target/cucumber/hcm-automation.json",
        "html:target/cucumber/hcm-automation.html",
        "pretty"
}, tags = { "@Critical" })
public class RunAutomationTest {

}
