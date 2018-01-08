package com.marinatest.world;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.marinatest.properties.AppProperties;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class E2EModule extends AbstractModule {

    @Override
    protected void configure() {}

    @Provides
    @ScenarioScoped
    public synchronized WebDriver provideWebDriver() {

        String webDrivername = AppProperties.getinstance().getProperty("webdriver");
        String chromeWebDriverPath = AppProperties.getinstance().getProperty("chrome.webdriver.path");

        if (chromeWebDriverPath != null) {
            System.setProperty("webdriver.chrome.driver", chromeWebDriverPath);
        }

        WebDriver driver;

        switch (webDrivername) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return driver;
    }
}

