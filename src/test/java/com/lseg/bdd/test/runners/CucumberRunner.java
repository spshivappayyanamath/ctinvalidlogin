package com.lseg.bdd.test.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features/"},
        glue={"com.lseg.bdd.test.stepDefinitions"}

)
public class CucumberRunner {
}
