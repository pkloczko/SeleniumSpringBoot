package com.example.SpringTestApp.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {

    @Autowired
    private WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

    @Before
    public void startTest(Scenario scenario){
        webDriver.get(appUrl);
    }

    @After
    public void TearDownTest(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("Scenario failed");
        }
        webDriver.quit();
    }

}
