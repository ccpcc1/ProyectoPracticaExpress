package com.stepDefinitions;

import com.cucumberpom.base.BaseTest;
import io.cucumber.java.en.Then;
import com.cucumberpom.pages.ShoppingCarPage;
public class ShoppingCarStepDefinitions extends BaseTest {

    ShoppingCarPage shoppingCarPage= new ShoppingCarPage();

    @Then("^the user add items to the shooping Car")
    public void theUserAddItemsToTheShoopingCar(){

        shoppingCarPage.addItemsToShoppingCar();
    }
    @Then("^the user buy the items in the shopping car")
    public void theUserBuyTheItemsInTheShoopingCart(){
        shoppingCarPage.buyTheItemsInShoppingCart();
    }

    @Then("^the user shold see the items bought")
    public void theUserShouldSeeTheItemBought(){
        shoppingCarPage.SeeItemsBought();
    }

}
