package com.User.PetStore;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;
import pojo.UsersDetails;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateAUser {
    Response response;
  String url="https://petstore.swagger.io/v2/user/createWithArray";
 UsersDetails user1= new UsersDetails();
 UsersDetails user2=new UsersDetails();
 String name= RandomStringUtils.randomAlphabetic(8);
 int id= RandomUtils.nextInt(1,100);
 @Test
 public  void CreatingUser(){
     user1.setId(id);
     user1.setUsername(name);
     user1.setFirstName(name);
     user1.setLastName(name);
     user1.setEmail(name + "@gmail.com");
     user1.setPassword(RandomStringUtils.randomAlphanumeric(8));
     user1.setPhone(RandomStringUtils.randomNumeric(10));
     user1.setUserStatus(id);
     user2.setId(id);
     user2.setUsername(name);
     user2.setFirstName(name);
     user2.setLastName(name);
     user2.setEmail(name       + "@gmail.com");
     user2.setPassword(RandomStringUtils.randomAlphanumeric(8));
     user2.setPhone(RandomStringUtils.randomNumeric(10));
     user2.setUserStatus(id);

     List  allUsers =new ArrayList();
     allUsers.add(user1);
     allUsers.add(user2);

     response= given().accept(ContentType.JSON).contentType(ContentType.JSON).body(allUsers).when().log().all().post(URI.create(url));
     response.then().log().status();
     response.body().prettyPrint();

 }

}
