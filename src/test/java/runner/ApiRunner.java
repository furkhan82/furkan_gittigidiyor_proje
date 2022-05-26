package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty", "html:Reports/htmlReport.html",
                    "json:Reports/jsonReport.json"},
            features="src/test/resources/apiFeature/trello.feature",
            glue="api/stepdefinition",
            //dryRun=false,
            tags="@api",
            publish=false
    )
    public class ApiRunner {

    }


