package com.cucumberpom.pages;

import com.cucumberpom.base.BaseTest;
import  org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    @FindBy(css="input[id='user-name']")
    WebElement userName;

    @FindBy(css="input[id='password']")
    WebElement password;

    @FindBy(css="input[id='login-button']")
    WebElement btnButton;

    //construcctor
    public LoginPage(){
        PageFactory.initElements(webDriver,this);
    }


}
