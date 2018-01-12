package com.marinatest.steps;

import com.marinatest.pages.LandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

public class LandingPageSteps {

    private WebDriver webDriver;
    private final LandingPage landingPage;

    @Inject
    public LandingPageSteps (WebDriver webDriver) {
        this.webDriver = webDriver;
        landingPage= PageFactory.initElements(this.webDriver, LandingPage.class);
    }

    @Given("^I am on the Landing page$")
    public void iOpenTheLandingPage() {
        landingPage.goToLandingPage();
    }

    @And ("^I click the Find Owners link$")
    public void iClickFindOwnersLink() {
        landingPage.clickFindOwnersLink();
    }

    @And("^I enter my name in the search field$")
    public void iEnterMyNameInTheSearchBox() {
    }
}
