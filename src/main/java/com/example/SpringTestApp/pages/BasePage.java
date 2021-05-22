package com.example.SpringTestApp.pages;
import io.cucumber.spring.CucumberTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Scope("cucumber-glue")
@Configuration
public abstract class BasePage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitHomePage(){
        PageFactory.initElements(webDriver,this);
    }
}
