package CucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    //tags = "@activity2_5",
    plugin = {"html: reports/html_report.html"},
    monochrome = true
)
     


public class ActivitiesRunner {
    //empty
   
	}


