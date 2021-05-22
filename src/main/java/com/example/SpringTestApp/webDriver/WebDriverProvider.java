package com.example.SpringTestApp.webDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverProvider {

    ChromeOptions options = new ChromeOptions()
            .addArguments("--start-fullscreen");
    //https://www.linkedin.com/pulse/part-2-hands-on-test-automation-project-java-spring-reis-fernandes
    @Bean
    @Scope("cucumber-glue")
    @ConditionalOnProperty(name="browser", havingValue = "chrome")
    public WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    @Bean
    @ConditionalOnProperty(name="browser", havingValue = "firefox")
    public WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return (WebDriver) new FirefoxDriver();
    }

}