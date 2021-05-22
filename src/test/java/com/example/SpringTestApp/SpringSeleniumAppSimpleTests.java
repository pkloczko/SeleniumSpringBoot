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
		webDriver.get(appUrl);
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		loginPage.setLogInValues("Admin","admin123").clickLoginButton();
		Assert.assertTrue(homePage.welcomeLink().isDisplayed(),"message");
		Assert.assertTrue(expectedUrl.equals(homePage.getHomePageUrl()),
				"Actual is not equal to expected. " +
						"Actual:" + homePage.getHomePageUrl() + ". Expected: " + expectedUrl);
		webDriver.close();
	}

	@Test
	void shouldNotLogInWithIncorrectCredentials() {

		loginPage.setLogInValues("invalid","invalid").clickLoginButton();
		System.out.println(loginPage.getSpanInvalidCredentials().getText());
		Assert.assertTrue(loginPage.getSpanInvalidCredentials().isDisplayed());
	}
}
