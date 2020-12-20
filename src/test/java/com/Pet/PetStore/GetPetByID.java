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

public class GetPetByID {
    Response response;
    @Before
    public void creatingPet() {
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
        pet.setStatus("Available");
         response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when().post(URI.create("https://petstore.swagger.io/v2/pet"));
        response.getBody().prettyPrint();
    }
    @Test
    public void GetCallToFindPetById(){
        int id=RandomUtils.nextInt(1,20);
        String url="https://petstore.swagger.io/v2/pet/"+id;
        response =given().accept(ContentType.JSON).contentType(ContentType.JSON).when().get(URI.create(url));
        response.then().log().all();

    }



}