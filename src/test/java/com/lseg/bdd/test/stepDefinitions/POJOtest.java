package com.lseg.bdd.test.stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.List;

public class POJOtest {

    String isbn;
    String title;
    String subtitle;
    String author;
    String published;
    String publisher;
    int pages;
    String description;
    String website;

    @Test
    public void JsonPathUsage() {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Read all the books as a List of String. Each item in the list
        // represent a book node in the REST service Response
        List<POJOtest> allBooks = jsonPathEvaluator.getList("books", POJOtest.class);

        // Iterate over the list and print individual book item
        // Note that every book entry in the list will be complete Json object of book
        for (POJOtest book : allBooks) {
            System.out.println("Book: " + book.title);
        }
    }

}