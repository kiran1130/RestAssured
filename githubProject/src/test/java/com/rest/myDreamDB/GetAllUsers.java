package com.rest.myDreamDB;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetAllUsers {

    @Test(priority = 1)
    public static void getAllUsers(){
        RestAssured.baseURI = "https://dream-56f4.restdb.io/rest";

        Response resp = RestAssured.given()
                .header("x-apikey", "a156e12f0d7c915365dbf6ec81ff5cabb5d47")
                .when()
                .get("/users/63d585de62144c6900004bfe");
        resp.then().statusCode(200);

        String resBody = resp.body().asPrettyString();
        System.out.println(resBody);
    }
    
}
