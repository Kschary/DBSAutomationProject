package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Properties.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/shivakumar/eclipse-workspace/"+
                   "DBSTestDemo/src/main/java/Features/DBSAwards.feature",
		           glue= {"stepDefination"},
		           plugin= {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		           monochrome = true
		)

public class TestRunner {
	
	@AfterClass
	 public static void writeExtentReport() {
		 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		 }

}
 