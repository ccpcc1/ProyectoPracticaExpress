package com.cucumberpom.pages;

import com.cucumberpom.base.BaseTest;
import com.cucumberpom.utils.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ShoppingHomePage extends BaseTest {
    WebDriverWait wait= new WebDriverWait(webDriver, Duration.ofSeconds(30));
    public ShoppingHomePage(){
        PageFactory.initElements(webDriver,this);
    }

    public String getTitle(){
        return webDriver.getTitle();
    }

    public void addItemsToShoppingCar(){
        String route="src/test/resources/data.xlsx";
        String sheetName="Shopping car";
        Map<String,String> data= ExcelUtility.getDataRecord(route,sheetName);
        String itemName=data.get("Item Name");
        try{
            if(itemName!="all"){
                WebElement itemNameButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(getIdButtomItem(itemName))));
                itemNameButton.click();
            }else
            {
                //add all items using the same class
                List<WebElement> itemsButtom=webDriver.findElements(By.className("btn btn_primary btn_small btn_inventory"));
                for (int i=0;i<itemsButtom.size();i++){
                    wait.until(ExpectedConditions.visibilityOf(itemsButtom.get(i))).click();
                }
            }
            System.out.println("item"+getIdButtomItem(itemName));
            Thread.sleep(5000);

        }catch (Exception e){
            System.out.println("it was a error adding items to the shopping car");
            e.printStackTrace();
        }



    }

    private String getIdButtomItem(String item){
        String getItem=item.trim().toLowerCase();
        getItem=getItem.replace(" ","-");
        return "add-to-cart-"+getItem;
    }
}
