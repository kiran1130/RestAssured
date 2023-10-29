package com.rest.sample;

import io.restassured.RestAssured;
//import io.restassured.RestAssured.*;
//import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
//import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class SampleGET {

    @Test(priority = 1)
    public static void simpleGet(){
        Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
        String resBody = resp.asPrettyString();
        System.out.println(resBody);
        resp.then().statusCode(200);
        
    }
}
