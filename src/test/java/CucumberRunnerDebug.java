import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true
//    tags = {"@debug", "@smoke"}
)
public class CucumberRunnerDebug {
}
