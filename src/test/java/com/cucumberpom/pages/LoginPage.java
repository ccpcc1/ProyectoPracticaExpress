package com.cucumberpom.pages;

import com.cucumberpom.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import  org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends BaseTest {

    @FindBy(css="input[id='user-name']")
    WebElement userName;

    @FindBy(css="input[id='password']")
    WebElement userPassword;

    @FindBy(css="input[id='login-button']")
    WebElement buttonLogin;


    WebDriverWait wait =new WebDriverWait(webDriver, Duration.ofSeconds(30));
    //construcctor
    public LoginPage(){
        PageFactory.initElements(webDriver,this);
    }

    public ShoppingHomePage UserEnterCredential() throws InterruptedException, IOException {
        String user=properties.getProperty("userName");
        String password=properties.getProperty("password");
        doLogin(user,password);

        return new ShoppingHomePage();
    }

    public void UserVerifyStayOnHomePage() throws InterruptedException, IOException{
        try {
            WebElement homePageTitle = webDriver.findElement(By.className("title"));
            String titleHomePage = homePageTitle.getText().trim();
            String spectedText = "Products";
            Assert.assertEquals(spectedText, titleHomePage);
            this.takeScreenshot(webDriver,"Loggin sucessfully");
        }catch (Exception e){
            System.out.println("Title isn't visible");
            e.printStackTrace();
        }
    }

    public void doLogin(String user, String password) throws InterruptedException, IOException {
        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOf(userPassword)).sendKeys(password);
        this.takeScreenshot(webDriver,"Loggin");
        wait.until(ExpectedConditions.visibilityOf(buttonLogin)).click();
        Thread.sleep(1000);
    }

}
