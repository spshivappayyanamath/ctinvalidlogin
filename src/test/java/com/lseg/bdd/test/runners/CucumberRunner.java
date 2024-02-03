package com.lseg.bdd.test.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={
                "src/test/resources/features/"
//                "src/test/resources/features/loginFile.feature"
        },
        glue={"com.lseg.bdd.test.stepDefinitions"},
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
//        monochrome = true,
//        strict = true

)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
