package com.marinatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindOwnersPage extends BasePage <FindOwnersPage> {

    public FindOwnersPage (WebDriver driver) {super(driver);}

    @Override
    public boolean isCorrectPage() {
        return driver.findElement(By.xpath("//h2[contains(text(), 'Find Owners')]")).equals("Find Owners");}

    @Override
    protected FindOwnersPage getThis() {return this;}


    /*===*/
    @FindBy(xpath = "//button[contains(@class, 'btn')]")
    private WebElement findOwnersButton;

    /*===*/

    public void clickFindOwnersButton() {
        findOwnersButton.click();
    }
}
