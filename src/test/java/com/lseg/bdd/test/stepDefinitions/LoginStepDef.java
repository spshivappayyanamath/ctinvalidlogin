package com.lseg.bdd.test.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDef {
    @Given("user navigates to login page")
    public void navigates(){
        System.out.println("page");
    }

    @When("user enters correct <username> AND <password> values")
    public void signIn(){
        System.out.println("page");
    }

    @Then("user directs to home page")
    public void homePage(){
        System.out.println("page");
    }

    @Given("list of books1")
    public void listOfBooks() {
    }

    public void listOfBooks12() {
    }
}
