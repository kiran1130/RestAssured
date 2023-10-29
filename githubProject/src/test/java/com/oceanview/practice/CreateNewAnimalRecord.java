package com.oceanview.practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.helper.Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateNewAnimalRecord {

    public static RestAssured rest;
    public static String animalID;

    @Test(priority = 1)
    public void createNewAnimalRecord(){
        Helper helper = new Helper();

        rest.baseURI = "https://oceanview-d5a2.restdb.io/rest";

        Map<String, Object> animalReqBody = new HashMap<>();
        animalReqBody.put("animal_name", helper.getAnimalName());
        animalReqBody.put("color", helper.getAnimalColor());
        animalReqBody.put("age",helper.getAnimalAge());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(animalReqBody);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

            Response response = rest.given()
                    .headers("x-apikey", "b3f79303352bccf01ba0a0aca60cf4e71123b")
                    .and().headers("Content-Type", "application/json")
                    .body(animalReqBody)
                    .when()
                    .post("/animals");

        String animalID = response.getBody().jsonPath().getString("_id");
        System.out.println(animalID);
        CreateNewAnimalRecord.animalID = animalID;

        System.out.println(response.asPrettyString());

    }


    @Test(priority = 2)
    public static void getAnimalDetails(){
        rest.baseURI = "https://oceanview-d5a2.restdb.io/rest";

        Response response = rest.given()
                .headers("x-apikey", "b3f79303352bccf01ba0a0aca60cf4e71123b")
                .when()
                .get("/animals/"+CreateNewAnimalRecord.animalID);

        String respBody = response.getBody().asPrettyString();
        System.out.println(respBody);

        response.then().statusCode(200);
    }

    @Test(priority = 3)
    public void updateNewAnimalRecord(){
        Helper helper = new Helper();

        rest.baseURI = "https://oceanview-d5a2.restdb.io/rest";

        Map<String, Object> animalReqBody = new HashMap<>();
        animalReqBody.put("animal_name", helper.getAnimalName());
        animalReqBody.put("color", helper.getAnimalColor());
        animalReqBody.put("age",helper.getAnimalAge());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(animalReqBody);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = rest.given()
                .headers("x-apikey", "b3f79303352bccf01ba0a0aca60cf4e71123b")
                .and().headers("Content-Type", "application/json")
                .body(animalReqBody)
                .when()
                .put("/animals/"+CreateNewAnimalRecord.animalID);

        response.then().statusCode(900);

        System.out.println(response.asPrettyString());

    }
}
