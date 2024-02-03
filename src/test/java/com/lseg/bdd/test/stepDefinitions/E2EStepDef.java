package com.lseg.bdd.test.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class E2EStepDef {
    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com/";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;


    @Given("authorised user")
    public void authorised_user() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification= RestAssured.given();

        requestSpecification.header("Content-Type","application/json");
        JSONObject para = new JSONObject();
        para.put("userName",USERNAME);
        para.put("password",PASSWORD);

        response =requestSpecification.body(para.toString()).post("/Account/v1/GenerateToken");

        token = JsonPath.from(response.toString()).get("token");
        System.out.println(token);

    }

    @Given("list of books")
    public void list_of_books() {
      RestAssured.baseURI =BASE_URL;
      RequestSpecification requestSpecification = RestAssured.given();

      response = requestSpecification.get("/BookStore/v1/Books");

      List<Map<String, String>> books = JsonPath.from(response.toString()).get("books");
        Assert.assertTrue(books.size()>0);
    }

    @When("add a book to reading list")
    public void add_a_book_to_reading_list() {
    RestAssured.baseURI =BASE_URL;
    RequestSpecification requestSpecification = RestAssured.given();

    requestSpecification.head("Authorization",token);
    requestSpecification.head("Content-Type","application/json");


    JSONObject jsonObject = new JSONObject();
    jsonObject.put("userId",USER_ID );
    jsonObject.put("isbn",bookId );

    response=requestSpecification.body(jsonObject.toString()).post("/BookStore/v1/Books");

    }

    @Then("book should be added")
    public void book_should_be_added() {
      Assert.assertEquals(200, response.getStatusCode());
    }

    @When("remove book")
    public void remove_book() {
        RestAssured.baseURI =BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.head("Authorization",token);
        requestSpecification.head("Content-Type","application/json");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isbn",bookId  );
        jsonObject.put("userId",USER_ID );

        response=requestSpecification.body(jsonObject.toString()).delete("/BookStore/v1/Book");


    }
    @Then("book should be removed")
    public void book_should_be_removed() {
        Assert.assertEquals(204, response.getStatusCode());
    }



}
