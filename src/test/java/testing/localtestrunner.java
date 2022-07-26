package testing;

import org.junit.runner.RunWith;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.junit.Courgette;
import io.cucumber.junit.Cucumber;

//@RunWith(Courgette.class)
//@CourgetteOptions(
//		rerunFailedScenarios = false,
//		reportTitle = "ApiTesting Report",
//		reportTargetDir = "target",
//		cucumberOptions = @CucumberOptions(
//				features = {".\\src\\main\\java\\featuref"},
//				glue={"teststeps"},
//				monochrome = true,
//				plugin = {"pretty"} )
//		)
@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(
		glue = {"."},
		features = {".\\src\\main\\java\\featuref"},
		monochrome = true,
		plugin= {"pretty"}
		)
public class localtestrunner {

}
