package com.cucumberpom.pages;

import com.cucumberpom.base.BaseTest;
import com.cucumberpom.utils.ExcelUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class ShoppingCarPage extends BaseTest{

    @FindBy(css="div[id='shopping_cart_container']")
    WebElement shoppingCarButton;

    @FindBy(id="checkout")
    WebElement checkoutButton;

    @FindBy(id="first-name")
    WebElement firstNameField;

    @FindBy(id="last-name")
    WebElement lastNameField;

    @FindBy(id="postal-code")
    WebElement postalCodeField;

    @FindBy(id="continue")
    WebElement continueButton;

    @FindBy(id="finish")
            WebElement finishButton;

    WebDriverWait wait= new WebDriverWait(webDriver, Duration.ofSeconds(30));

    public ShoppingCarPage(){
        PageFactory.initElements(webDriver,this);
    }

    public void buyTheItemsInShoppingCart() throws InterruptedException{
        String route="src/test/resources/data.xlsx";
        String sheetName="Shopping car";
        Map<String,String> data= ExcelUtility.getDataRecord(route,sheetName);
        String firstName=data.get("First name");
        String lastName=data.get("Last Name");
        String postalCode=data.get("Postal Code");

        try{
            wait.until(ExpectedConditions.visibilityOf(shoppingCarButton)).click();
            wait.until(ExpectedConditions.visibilityOf(checkoutButton)).click();
            wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
            wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
            wait.until(ExpectedConditions.visibilityOf(postalCodeField)).sendKeys(postalCode);
            wait.until(ExpectedConditions.visibilityOf(continueButton)).click();
            wait.until(ExpectedConditions.visibilityOf(finishButton)).click();
            ExcelUtility.markFistRecordLikeUsed(route); //mark like used the record
        }catch (Exception e){
            System.out.println("it was a error buying items");
            e.printStackTrace();
        }

    }

    public void SeeItemsBought(){
        try {
            String spectedText="Thank you for your order!";
            WebElement succesMessage = webDriver.findElement(By.className("complete-header"));
            String actalMessage=succesMessage.getText();
            Assert.assertEquals(spectedText, actalMessage);
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
