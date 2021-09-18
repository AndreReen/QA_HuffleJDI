import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    tags = {"@registration"},
    features = {"src/test/resources"},
    plugin = {"pretty", "html:cucumber-report-general"}
)
public class CucumberRunner {
}
