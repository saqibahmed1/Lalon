package com.Pet.PetStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import org.junit.Before;

import org.testng.annotations.Test;
import pojo.Category;
import pojo.Pets;
import pojo.Tags;

import java.net.URI;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class UpdateAnExistingPet {

    @Before
    public void createPet() {

        String name = RandomStringUtils.randomAlphabetic(10);
        int id = RandomUtils.nextInt(1, 20);
        Pets pet = new Pets();
        Category category = new Category();
        Tags tags = new Tags();
        tags.setId(id);
        category.setId(id);
        category.setName(name);
        pet.setId(id);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tags));
        pet.setStatus("Pending");
        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when().post(URI.create("https://petstore.swagger.io/v2/pet"));
        response.getBody().prettyPrint();
    }

    @Test
    public void updatePet() {

        int id = RandomUtils.nextInt(1, 20);
        Pets pet = new Pets();
        Category category = new Category();
        Tags tags = new Tags();
        tags.setId(id);
        category.setId(id);
        category.setName("Tommy");
        pet.setId(id);
        pet.setCategory(category);
        pet.setTags(Arrays.asList(tags));
        pet.setStatus("Available");
        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet).log().all()
                .when().post(URI.create("https://petstore.swagger.io/v2/pet"));
        response.then().log().all();



    }
}