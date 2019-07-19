package ru.com.otus;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/html", "json:target/cucumber/json/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"ru.com.otus.steps", "ru.com.otus.config"}
)
public class CucumberTest {
}

