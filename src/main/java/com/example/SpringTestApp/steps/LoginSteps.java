package com.example.SpringTestApp.steps;

import com.example.SpringTestApp.pages.HomePage;
import com.example.SpringTestApp.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginSteps {

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private WebDriver webDriver;

    private String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    @Given("Open the application login page")
    public void openTheApplicationLoginPage() {
    }

    @And("Set user name and password")
    public void setUserNameAndPassword(DataTable dataTable) {
        var data = dataTable.asList();
        loginPage.setLogInValues(data.get(2),data.get(3));
    }

    @And("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Home page url is correct")
    public void homePageUrlIsCorrect() {
        Assert.assertTrue(expectedUrl.equals(homePage.getHomePageUrl()),
                "Actual is not equal to expected. " +
                        "Actual:" + homePage.getHomePageUrl() + ". Expected: " + expectedUrl);
    }

    @And("Then welcome is displayed")
    public void thenWelcomeIsDisplayed() {
        Assert.assertTrue(homePage.welcomeLink().isDisplayed(),"message");
    }
}
