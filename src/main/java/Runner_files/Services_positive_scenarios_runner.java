package Runner_files;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = "src\\main\\java\\Services_positive_scenarios\\Services_positive_scenarios.feature",
glue= {"Services_positive_scenarios"},
monochrome = true,publish = true)
public class Services_positive_scenarios_runner extends AbstractTestNGCucumberTests{

}
