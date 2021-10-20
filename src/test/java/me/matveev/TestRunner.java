package me.matveev;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources",
        glue = "me/matveev/steps",
        plugin = "pretty"
)
@RunWith(Cucumber.class)
public class TestRunner {
}
