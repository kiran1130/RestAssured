package com.oceanview.practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.oceanview.listeners.MainTestListeners;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(MainTestListeners.class)
public class GetAllAnimalsDetails {


    public static RestAssured rest;

    @Test
    public static void getAllAnimalDetails(){
        rest.baseURI = "https://oceanview-d5a2.restdb.io/rest";

        Response response = rest.given()
                .headers("x-apikey", "b3f79303352bccf01ba0a0aca60cf4e71123b")
                .when()
                .get("/animals");

        String respBody = response.getBody().asPrettyString();
        System.out.println(respBody);

        response.then().statusCode(200);
    }

}
