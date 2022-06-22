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
//tags = specify @test definition to run
//plugin = specify type of output and path
@CucumberOptions(features = "src/test/java/feature", glue = "stepDefinitions", tags = "@Guru99Test1")
public class TestRunner extends AbstractTestNGCucumberTests {

}
