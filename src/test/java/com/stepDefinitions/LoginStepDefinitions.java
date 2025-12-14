package com.stepDefinitions;

import com.cucumberpom.base.BaseTest;
import com.cucumberpom.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends BaseTest {
    LoginPage loginPage;

    @Before
    public void openBrowser(){
        BaseTest.initBrowser();
    }

    @Given("^open the website successfully")
    public void openTheWebsiteSuccessfully(){
        String url=properties.getProperty("aplicationUrl");
        webDriver.get(url);
        loginPage= new LoginPage();
    }

    @When("^the user enter the credentials")
    public void theUserEnterTheCredentials() throws InterruptedException {
        loginPage.UserEnterCredential();
    }

    @Then("^the user should see the home page successfully")
    public void theUserShouldSeeTheHomePageSuccessfull() throws InterruptedException {
       loginPage.UserVerifyStayOnHomePage();
    }


    @After
    public void closeBrowser() throws InterruptedException{
        webDriver.close();
    }
}
