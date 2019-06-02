package gradle.cucumber;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Eynar.
 */
@RunWith(Cucumber.class)
public class Runner {

    @Before()
    public void beforeScenario(Scenario scenario) {

    }


    @After()
    public void afterScenario(Scenario scenario) {
    }
}