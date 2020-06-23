package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.formatter.MonochromeFormats;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/", 
                 glue = { "seleniumgluecode"},
                 dryRun = false,
                 tags = "@Smoke",
                 plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)

public class testrunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
}
