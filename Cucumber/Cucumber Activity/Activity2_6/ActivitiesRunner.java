package CucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    strict = true,
    plugin = {"html: test-reports.html"},
    monochrome = true
)
 

public class ActivitiesRunner {
    //empty
   
	}


