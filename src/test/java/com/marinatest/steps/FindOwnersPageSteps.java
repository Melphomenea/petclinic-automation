package com.marinatest.steps;

import com.google.inject.Inject;
import com.marinatest.pages.FindOwnersPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FindOwnersPageSteps {

    private WebDriver webDriver;
    private final FindOwnersPage findOwnersPage;

    @Inject
    public FindOwnersPageSteps (WebDriver webDriver){
        this.webDriver = webDriver;
        findOwnersPage= PageFactory.initElements(this.webDriver, FindOwnersPage.class);
    }

    @And("^I click Find Owners button$")
    public void iClickFindOwnersButton() {
        findOwnersPage.clickFindOwnersButton();
    }

    @And("^I check the last name for unique ones$")
    public void checkNamesForUniqueOnes() {
        findOwnersPage.checkUniqueNames();
    }
}
