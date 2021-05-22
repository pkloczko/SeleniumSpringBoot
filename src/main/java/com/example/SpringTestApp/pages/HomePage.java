package com.example.SpringTestApp.pages;

import io.cucumber.spring.CucumberTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class HomePage extends BasePage {

    @Autowired
    private WebDriver webDriver;

    @FindBy (id = "welcome")
    public WebElement welcomeLink;

    public WebElement welcomeLink(){
        WebDriverWait wait = new WebDriverWait(this.webDriver,10);
        wait.until(ExpectedConditions.visibilityOf(welcomeLink));
        return welcomeLink;
    }

    public String getHomePageUrl(){
        return webDriver.getCurrentUrl();
    }

}
