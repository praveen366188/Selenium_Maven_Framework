package sc;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"C:\\Users\\91812\\IdeaProjects\\Selenium_Maven\\SelTest1\\src\\test\\resources\\Naukri.feature"},
glue = {"C:\\Users\\91812\\IdeaProjects\\Selenium_Maven\\SelTest1\\src\\test\\java\\stepDef"})
public class RunnerClass extends AbstractTestNGCucumberTests {




}
