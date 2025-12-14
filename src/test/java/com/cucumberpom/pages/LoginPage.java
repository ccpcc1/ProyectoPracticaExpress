package com.cucumberpom.pages;

import com.cucumberpom.base.BaseTest;
import  org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public ShoppingCarPage  UserEnterCredential() throws InterruptedException{
        String user=properties.getProperty("userName");
        String password=properties.getProperty("password");
        doLogin(user,password);

        return new ShoppingCarPage();
    }

    public void UserVerifyStayOnHomePage() throws InterruptedException{

    }

    public void doLogin(String user, String password)throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOf(userPassword)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(buttonLogin)).click();
        Thread.sleep(5000);
    }

}
