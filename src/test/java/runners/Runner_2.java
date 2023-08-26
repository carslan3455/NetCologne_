package runners;

import com.cucumber.listener.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;


@CucumberOptions(
        tags = "@Smoke",
        features = {"src/test/java/features"},
        glue = {"StepDefinitions"},
        dryRun = false,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary"}

)
public class Runner_2 extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void afterClass() {

        Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
        Reporter.setSystemInfo("QA Tester : ", "Cigdem Arslan");
        Reporter.setSystemInfo("Application Name : ", "NetCologne");
        Reporter.setSystemInfo("Operating System Info : ", System.getProperty("os.name"));
        Reporter.setSystemInfo("Department : ", "QA");
        Reporter.setTestRunnerOutput("Test execution Cucumber report");

    }

}
