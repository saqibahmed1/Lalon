package com.Pet.PetStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pojo.Category;
import pojo.Pets;
import pojo.Tags;


import java.io.File;
import java.net.URI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static io.restassured.RestAssured.given;


public class AddPetInStore {




    @Test
    public  void makePostCallForAddingPetToPetStore() {
        String name= RandomStringUtils.randomAlphabetic(10);
        int id= RandomUtils.nextInt(1, 20);
        Pets pet = new Pets();
        Category category = new Category();
        Tags tags = new Tags();
        tags.setId(id);
        category.setId(id);
        category.setName(name);
        pet.setId(id);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tags));
        pet.setStatus("Available");

        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when().log().all().post(URI.create("https://petstore.swagger.io/v2/pet"));
        response.then().log().body();
    }}


