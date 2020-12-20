package com.User.PetStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.UsersDetails;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
public class FindUserByUserName {
    Response response ;
    UsersDetails user = new UsersDetails();
    String name = RandomStringUtils.randomAlphabetic(10);
    int id = RandomUtils.nextInt(1, 100);
   @Before
    public void AddingUser() {

        user.setId(id);
        user.setUsername("Maijvandari");
        user.setFirstName(name);
        user.setLastName(name);
        user.setEmail(name+ "gmail.com");
        user.setPassword(name);
        user.setPhone(name);
        user.setUserStatus(id);

        String url = "https://petstore.swagger.io/v2/user/createWithArray";
List users=new ArrayList();
users.add(user);

        response= given().accept(ContentType.JSON)
                .contentType(ContentType.JSON).body(users)
                .when().log().all().post(URI.create(url));
        response.body().prettyPrint();


    }
   @Test
   public void GettingUser(){

        response=given().accept(ContentType.JSON)
                .contentType(ContentType.JSON).when()
                .get(URI.create("https://petstore.swagger.io/v2/user/Maijvandari"));
        response.then().log().all();


   }

}