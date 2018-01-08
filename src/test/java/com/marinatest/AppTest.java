package com.marinatest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (plugin={"pretty", "html:target/cucumber-html-report"},
            features={"src/test/resurces"},
            glue={"com.marinatest.steps", "com.marinatest.world"})
public class AppTest {
}
