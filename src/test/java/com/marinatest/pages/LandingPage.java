package com.marinatest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage<LandingPage> {

    public LandingPage(WebDriver driver) {super(driver);}

    public void goToLandingPage() {
        driver.get("http://localhost:8080/");}

    @Override
    public boolean isCorrectPage() {
        return driver.getTitle().equalsIgnoreCase("Pet Clinic :: a Spring Framework Demonstration"); }

    @Override
    protected LandingPage getThis() {return this;}


    /*=================================================================*/

    @FindBy (xpath = "//a[@title='find owners']")
    private WebElement findOwnersLink;

    @FindBy (xpath = "//a[contains(@href, '/owners/find')]")
    private WebElement findOwnersButton;

    @FindBy (xpath = "//td/a")
    private WebElement tableRow;

    @FindBy (xpath = "//li[@class='active']")
    private WebElement activeNav;

    /*=================================================================*/

    public void clickFindOwnersLink() {
        findOwnersLink.click();
    }

    public void clickFindOwnersButton() {
        findOwnersButton.click();
    }

    public void checkUniqueNames() {

    }

    public void isElementActive() {
        Assert.assertEquals(activeNav.getAttribute("class"), "active");
    }


}
