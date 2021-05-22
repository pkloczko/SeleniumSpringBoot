package com.example.SpringTestApp;

import com.example.SpringTestApp.pages.HomePage;
import com.example.SpringTestApp.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringSeleniumAppSimpleTests {

	@Autowired
	private HomePage homePage;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private WebDriver webDriver;

	@Value("${app.url}")
	private String appUrl;

	private String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

	@Test
	void shouldLogInWithCorrectCredentials() {
		//Given I open the application log in page
		webDriver.get(appUrl);
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//When I log in with correct credentials
		loginPage.setLogInValues("Admin","admin123").clickLoginButton();
		//Then User name is displayed
		Assert.assertTrue(homePage.welcomeLink().isDisplayed(),"message");
		//And Home page Url is correct
		Assert.assertTrue(expectedUrl.equals(homePage.getHomePageUrl()),
				"Actual is not equal to expected. " +
						"Actual:" + homePage.getHomePageUrl() + ". Expected: " + expectedUrl);
		webDriver.close();
	}

	//@Test
	void shouldNotLogInWithIncorrectCredentials() {
		//Given I opened the application log in page
		//apiRunner.start(appUrl);
		//When I log in with incorrect credentials
		loginPage.setLogInValues("invalid","invalid").clickLoginButton();
		//Then incorrect credentials message is displayed
		System.out.println(loginPage.getSpanInvalidCredentials().getText());
		Assert.assertTrue(loginPage.getSpanInvalidCredentials().isDisplayed());
		//apiRunner.stop();
	}
}
