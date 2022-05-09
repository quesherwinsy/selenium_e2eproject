package cucumberOptions;

//import org.junit.runner.RunWith;

//Cucumber junit
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//Cucumber testng
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
//feature = path of feature file
//glue = path of step definition file
@CucumberOptions(features = "src/test/java/feature", glue = "stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
