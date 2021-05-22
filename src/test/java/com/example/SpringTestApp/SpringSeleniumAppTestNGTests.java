package com.example.SpringTestApp;

import com.example.SpringTestApp.pages.HomePage;
import com.example.SpringTestApp.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//https://www.javainuse.com/spring/springboot_testng

@SpringBootTest
class SpringSeleniumAppTestNGTests extends AbstractTestNGSpringContextTests {

	@Value("${app.url}")
	private String appUrl;

	@Autowired
	private HomePage homePage;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private WebDriver webDriver;

	private String loginInPageExpectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	private String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

	@BeforeTest
	public void startWebDriver() throws Exception {
		webDriver.get(appUrl);
		Assert.assertTrue(loginInPageExpectedUrl.equals(loginPage.getLoginPageUrl()),"");
	}

	@Test
	void shouldLogInWithCorrectCredentials() {
		loginPage.setLogInValues("Admin","admin123").clickLoginButton();
		Assert.assertTrue(homePage.welcomeLink().isDisplayed(),"message");
		Assert.assertTrue(expectedUrl.equals(homePage.getHomePageUrl()),
				"Actual is not equal to expected. " +
						"Actual:" + homePage.getHomePageUrl() + ". Expected: " + expectedUrl);
	}

	@AfterTest
	protected void stopWebDriver(){
		webDriver.close();
	}

	@BeforeSuite(alwaysRun = true)
	@BeforeClass(alwaysRun = true)
	@BeforeTest(alwaysRun = true)
	@AfterTest(alwaysRun = true)
	@Override
	protected void springTestContextPrepareTestInstance() throws Exception {
		super.springTestContextPrepareTestInstance();
	}

}
