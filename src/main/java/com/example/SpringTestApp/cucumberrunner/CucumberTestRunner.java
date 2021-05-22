package com.example.SpringTestApp.cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/main/java/com/example/SpringTestApp/features"},
        glue = {"com.example.SpringTestApp.steps"},
        plugin = { "pretty", "html:target/cucumber-reports/report.html"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
