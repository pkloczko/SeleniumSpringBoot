package com.example.SpringTestApp.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.spring.CucumberTestContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberTestContextConfig {
}
