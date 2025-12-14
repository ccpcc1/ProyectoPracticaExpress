package com.cucumber.stepDefinitions;

import com.cucumberpom.base.BaseTest;
import com.cucumberpom.pages.ShoppingCarPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import com.cucumberpom.pages.ShoppingHomePage;

import java.io.IOException;

public class ShoppingCarStepDefinitions extends BaseTest {

    ShoppingHomePage shoppingHomePage= new ShoppingHomePage();
    ShoppingCarPage shoppingCarPage= new ShoppingCarPage();

    @Then("^the user add items to the shooping Car")
    public void theUserAddItemsToTheShoopingCar()throws InterruptedException{

        shoppingHomePage.addItemsToShoppingCar();
    }
    @Then("^the user buy the items in the shopping car")
    public void theUserBuyTheItemsInTheShoopingCart()throws InterruptedException, IOException{

        shoppingCarPage.buyTheItemsInShoppingCart();
    }

    @Then("^the user shold see the items bought")
    public void theUserShouldSeeTheItemBought()throws InterruptedException, IOException {
        shoppingCarPage.SeeItemsBought();
    }


}
