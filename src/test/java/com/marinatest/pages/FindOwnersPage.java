package com.marinatest.pages;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

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

    @FindBy (tagName = "tbody")
    private WebElement tableOwners;

    /*===*/

    public void clickFindOwnersButton() {
        findOwnersButton.click();
    }

    public void checkNames() {
        //Locate rows of the dynamic Owners table
        List<WebElement> table_rows = tableOwners.findElements(By.tagName("tr"));
        //calculate number of rows in the table
        int row_count = table_rows.size();
        //Go through the table
        List <String> lastnames = new ArrayList<>();
        for (int row=0; row < row_count; row++)
        {
            //Locate columns of the row:
            List <WebElement> cols_row = table_rows.get(row).findElements(By.tagName("td"));
            //calculate number of cells in a row
            //int col_count =cols_row.size();
            //write the content of every cell
            //for (int col=0; col<col_count; col++) {
                //String celltext = cols_row.get(col).getText(); - writes all cells
                //String celltext = cols_row.get(0).getText();
                //System.out.println(row +" row and " + col + " cell: " + celltext);
            //}
            String celltext = cols_row.get(0).getText();
            System.out.println(row +" row and first cell: " + celltext);
        }
    }

    public void writeNamesConsole () {
        List <String> lastnames = new ArrayList<>();
        List<WebElement> table_rows = tableOwners.findElements(By.tagName("tr"));
        int row_count = table_rows.size();
        for (int row=0; row < row_count; row++)
        {
            List <WebElement> cols_row = table_rows.get(row).findElements(By.tagName("td"));
            String celltext = cols_row.get(0).getText();
            String ss[]=celltext.split(" ");
            lastnames.add(ss[1]);
        }
        System.out.println("\n\n The unique ones are:\n");
        lastnames.stream().distinct().forEach(System.out::println);

    }
}
