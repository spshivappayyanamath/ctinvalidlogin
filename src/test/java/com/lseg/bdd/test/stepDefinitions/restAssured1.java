package com.lseg.bdd.test.stepDefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class restAssured1 {
    String userId = "toolsqa_test";
    String baseUrl = "https://demoqa.com";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
    String isbn = "9781449325865";


    @Test()
    public void getPetDetails(){
        for (int i=0; i<5; i++){
            for (int j=0;j<i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i=0; i<5; i++){
            for (int j=0;j<i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }
    @Test
    public void readJsonData(){
        RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"");
        Headers headers=response.headers();
        for (Header header: headers){
            System.out.println(header.getName()+" :: "+ header.getName());
        }
        System.out.println("************");
        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void readJsonBody(){
        RestAssured.baseURI= "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request().get();
        ResponseBody responseBody= response.getBody();
        System.out.println("Response Body is: " + responseBody.asString());
        Assert.assertEquals(responseBody.toString().toLowerCase().contains("books"),true);
    }

    @Test
    public void readJsonTags(){
        RestAssured.baseURI= "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request().get();
        ResponseBody responseBody= response.getBody();
        System.out.println("Response Body is: " + responseBody.asString());

        JsonPath jsonPath= response.jsonPath();
        System.out.println(jsonPath.get("books").toString());
        Assert.assertEquals(jsonPath.get("books").toString().contains("9781449325862"), true);
        //        String p= jsonPath.get("books");
    }

    @Test
    public void additionalParameter(){
        RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.queryParam("ISBN","9781449325862").get("/Book");
        ResponseBody responseBody= response.getBody();
        System.out.println("Response Body is: " + responseBody.asString());

        JsonPath jsonPath= response.jsonPath();
        System.out.println(jsonPath.get("books").toString());
        Assert.assertEquals(jsonPath.get("books").toString().contains("9781449325862"), true);
        //        String p= jsonPath.get("books");
    }

@Test
    public void additionalParameteJson(){
        RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("userId", "TQ123");
        jsonObject.put("isbn", "9781449325862");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(jsonObject.toString());

        Response response = httpRequest.post("/BookStoreV1BooksPost");
        System.out.println(response.statusCode());
        System.out.println(response.getBody().toString());


    RestAssured.baseURI ="https://demoqa.com/Account/v1";
    RequestSpecification request = RestAssured.given();

    JSONObject requestParams = new JSONObject();
    requestParams.put("userName", "test_rest");
    requestParams.put("password", "Testrest@123");
    request.header("Content-Type", "application/json");
    request.body(requestParams.toString());

    Response response1 = request.post("/User");
    ResponseBody body = response1.getBody();
    System.out.println(response1.getStatusLine());
    System.out.println(body.asString());


    }
    @Test
    public void readResponseJson(){
        RestAssured.baseURI ="https://demoqa.com";
        RequestSpecification requestSpecification =RestAssured.given();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName","test_rest");
        jsonObject.put("Password","rest@123");
//        requestSpecification.header("Content-Type", "json");
        requestSpecification.body(jsonObject.toString());
        Response response= requestSpecification.post("/Account/v1/User");

        ResponseBody responseBody = response.getBody();
        System.out.println(responseBody.toString());
//        JSONSuccessResponse jsonSuccessResponse = responseBody.as(JSONSuccessResponse.class);
        List a = responseBody.as(List.class);
        for (int i=0 ; i<a.size(); i++){
            System.out.println(a.get(i));
        }


    }

    @Test
    public void tt(){
//        RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("postman", "password");
        RequestSpecification httpRequest = RestAssured.given().given().auth().form("your username", "your password", new FormAuthConfig("/perform_signIn","user","password"));
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }

    @Test
    public void t1(){
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

        //Calling the Delete API with request body
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/BookStore/v1/Book/9781449325862");

        //Fetching the response code from the request and validating the same
        System.out.println("The response code - " +res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(),200);


        }


    @Test
    public void JsonPathUsage()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Read all the books as a List of String. Each item in the list
        // represent a book node in the REST service Response
        List<String> allBooks = jsonPathEvaluator.getList("books.title");

        // Iterate over the list and print individual book item
        for(String book : allBooks)
        {
            System.out.println("Book: " + book);
        }


    }

}