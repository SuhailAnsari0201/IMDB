package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "com.qait.stepDefination" }, monochrome = true, plugin = {
		"pretty", "json:target/JSONReports/report.json", 
		"html:target/HTMLReports/report.html" })
public class RunnerTest {

	
	
}
