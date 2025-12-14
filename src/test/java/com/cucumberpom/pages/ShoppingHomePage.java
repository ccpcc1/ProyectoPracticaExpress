package com.cucumberpom.pages;

import com.cucumberpom.base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class ShoppingHomePage extends BaseTest {

    public ShoppingHomePage(){
        PageFactory.initElements(webDriver,this);
    }

    public String getTitle(){
        return webDriver.getTitle();
    }

    public void addItemsToShoppingCar(){

    }
    public void buyTheItemsInShoppingCart(){

    }

    public void SeeItemsBought(){

    }
}
