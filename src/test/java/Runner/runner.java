package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"Stepdefination","AppHoocks"},
        plugin = {"html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:test-output/html/HTMLreport.html",
                "Listner.CustomCucumberListener"
        },
        tags = "@paint"

)

public class runner {

}
