package com.example.SpringTestApp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class LoginPage extends BasePage{

    @Autowired
    private WebDriver webDriver;

    @FindBy (xpath = "//input[@id='txtUsername']")
    public WebElement txtUsername;

    @FindBy (xpath = "//input[@id='txtPassword']")
    public WebElement txtPassword;

    @FindBy (id = "btnLogin")
    public WebElement btnLogin;

    @FindBy (id = "spanMessage")
    public WebElement spanInvalidCredentials;

    public WebElement getSpanInvalidCredentials() {
        return spanInvalidCredentials;
    }

    public LoginPage setLogInValues(String userName, String password) {
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton(){
        btnLogin.click();
        return new HomePage();
    }

    public String getLoginPageUrl(){
        return webDriver.getCurrentUrl();
    }
}
