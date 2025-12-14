package com.cucumber.stepDefinitions;

import com.cucumberpom.base.BaseTest;
import io.cucumber.java.en.Then;
import com.cucumberpom.pages.ShoppingHomePage;
public class ShoppingCarStepDefinitions extends BaseTest {

    ShoppingHomePage shoppingHomePage= new ShoppingHomePage();

    @Then("^the user add items to the shooping Car")
    public void theUserAddItemsToTheShoopingCar(){

        shoppingHomePage.addItemsToShoppingCar();
    }
    @Then("^the user buy the items in the shopping car")
    public void theUserBuyTheItemsInTheShoopingCart(){
        shoppingHomePage.buyTheItemsInShoppingCart();
    }

    @Then("^the user shold see the items bought")
    public void theUserShouldSeeTheItemBought(){
        shoppingHomePage.SeeItemsBought();
    }

}
