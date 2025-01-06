package fit.man.sys.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="use_cases",
        plugin= {"pretty","html:target/cucumber/wikipedia.html"},
        monochrome=true,
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        glue="fit.man.sys.project",
        publish=true)


public class AcceptanceTest {
}
