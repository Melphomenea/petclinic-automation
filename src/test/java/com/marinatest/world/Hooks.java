package com.marinatest.world;

import com.google.inject.Inject;
import cucumber.api.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

public class Hooks {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    private final WebDriver webDriver;

    @Inject
    public Hooks (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @After
    public void shutDownWebDriver (Scenario scenario) {
        if (scenario.isFailed() || "skipped".equals(scenario.getStatus())) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }
        try {
            webDriver.quit();
        }
        catch (Exception e) {
            logger.error ("error quitting webdriver",e);
        }
    }
}

