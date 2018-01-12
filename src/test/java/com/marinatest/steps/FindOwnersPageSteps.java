package com.marinatest.steps;

import com.google.inject.Inject;
import com.marinatest.pages.FindOwnersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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

    @And("^I check the last names of the owners$")
    public void checkNamesForUniqueOnes() {
        findOwnersPage.checkNames();
    }

    @Then("^I should be able to filter unique owners in the command line$")
    public void writeNamesConsole (){
        findOwnersPage.writeNamesConsole();
    }
}
