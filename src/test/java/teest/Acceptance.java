package teest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "uses",
        plugin = {"summary","html:target/cucumber/report.html"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        glue = "teest",
        publish = true
)
public class Acceptance {

}