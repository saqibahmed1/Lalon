package com.Pet.PetStore;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Status;


import java.net.URI;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class GetPetByStatusDataProvider {

    @DataProvider(name = "data")
    public Object[] data(){
        return Status.values();
    }

    @Test(dataProvider = "data")
    public static void makeAvailableGetCallForPetStore(Status status){
        String url ="https://petstore.swagger.io/v2/pet/findByStatus?status=".concat(status.getStatus()) ;
        Response response = given().accept(ContentType.JSON)
                .when().log().all().get(URI.create(url));
        response.then().log().body(true);
        assert response.statusCode() == 200;
        assertThat(response.statusCode()).isEqualTo(200);
    }
}
