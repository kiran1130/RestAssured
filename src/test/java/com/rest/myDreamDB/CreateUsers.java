package com.rest.myDreamDB;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.helper.Helper;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CreateUsers {
    public static Helper helper;

    @Test
    public static void createUser() throws JsonProcessingException {
        helper = new Helper();

        Map<String, Object> header = new HashMap<String, Object>();
        header.put("x-apikey", "a156e12f0d7c915365dbf6ec81ff5cabb5d47");
        header.put("Content-Type", "application/json");

        Map<String, Object> user = new HashMap<String, Object>();
        user.put("name",helper.getFirstName());
        user.put("email",helper.getEmailID());
        user.put("mail",helper.getEmailID());
        user.put("gender","Not disclosed");
        user.put("designation",helper.getJobTitle());
        user.put("location", "Bng");
        user.put("active", true);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Creating new user record
        RestAssured.baseURI = "https://dream-56f4.restdb.io/rest";
        Response resp = RestAssured.given()
                .headers(header)
                .body(user)
                .when()
                .post("/users");

        //Storing response body in Pretty string form
        String resBody = resp.body().asPrettyString();

        //Printing the response body in console
        System.out.println(resBody);

        //Validating the status code for successful creation
        resp.then().statusCode(201);

    }

}
