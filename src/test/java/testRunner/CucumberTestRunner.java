package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/features"},
                 glue={"stepDefinition"},
                    dryRun = false,
        plugin={"pretty","html:target/cucumberReports/Report.html",
                "json:target/cucumberReports/Report.json",
                "junit:target/cucumberReports/Report.xml"},
        tags="@all"
)
public class CucumberTestRunner {
}
