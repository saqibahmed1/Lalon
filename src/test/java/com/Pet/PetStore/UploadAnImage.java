package com.Pet.PetStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;


import static io.restassured.RestAssured.given;


public class UploadAnImage {

@Test
    public void makePostCallForUploadImageToPetStore() throws IOException {

   File photo= new File(UploadAnImage.class.getResource("/TestData/dog.png").getFile());
        Response response = given().accept(ContentType.JSON)
                .contentType("multipart/form-data")
                .multiPart("additionalMetadata", "dog.png")
                .multiPart("file",photo)
                .when().log().all().post(new URL("https://petstore.swagger.io/v2/pet/336/uploadImage"));
        response.then().log().all();
        assert response.statusCode() == 200;



    }
}
