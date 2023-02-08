package stepDefinitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "OrangeHrmApplication",glue="stepDefinitions",monochrome = true//, dryRun = true
)
						

public class TestRunner
{
	
	
	
}
