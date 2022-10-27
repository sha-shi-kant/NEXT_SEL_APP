package com.test.runner;
import org.testng.annotations.*;

import com.test.base.Webdriverfactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = { "src/test/resources/features" },
    glue = { "com.test.stepdefination" },
    //tags = "@LoginSF,@LoginKimble,@MAJmanager,@VerifEmp,@CreationCollaborateur",
    strict = true,
    plugin = {"json:reports/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters("browserName")
    @BeforeMethod
    public void setupTest(String browserName) throws Exception {
        Webdriverfactory.setupDriver(browserName);
    }

    @AfterMethod
    public void tearDown() {
        Webdriverfactory.quitDriver();
    }
}

