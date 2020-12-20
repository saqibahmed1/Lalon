package com.Pet.PetStore;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.net.URI;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class GetPetByStatus {

    @Parameters({"status"})
    @Test
    public static void makeGetCallWithStatusForPetStore(@Optional("available") String status){
        String url ="https://petstore.swagger.io/v2/pet/findByStatus?status=".concat(status) ;
        Response response = given().accept(ContentType.JSON)
                .when().log().all().get(URI.create(url));
        response.then().log().all();
        assert response.statusCode() == 200;
        assertThat(response.statusCode()).isEqualTo(200);

    }
}
