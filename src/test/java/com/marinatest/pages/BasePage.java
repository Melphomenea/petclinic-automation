package com.marinatest.pages;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

public abstract class BasePage <R extends BasePage<R>> {

    protected final WebDriver driver;

    public BasePage (WebDriver driver) { this.driver=driver; }

    public abstract boolean isCorrectPage();

    protected abstract R getThis();

    static final String BASE_URL="http://localhost:8080";

    public R refreshPage() {
        driver.navigate().refresh();
        return getThis();
    }

    public R navigateback(){
        driver.navigate().back();
        return getThis();
    }

    public String getPageURL() { return driver.getCurrentUrl(); }

    @After
    private void testCleanup()
    {
        driver.quit();
        driver.close();
    }
}
