package com.Store.PetStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.testng.annotations.Test;
import pojo.Order;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class DeletePurchaseOrderById {
    Order order= new Order();
    Response response;

    @Before
    public void PostCallToCreateOrder(){


        long id= RandomUtils.nextInt(1,19);
        int ids=RandomUtils.nextInt(1,19);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String date = dateFormat.format(Calendar.getInstance(Locale.getDefault()).getTime());
        order.setId(id);
        order.setPetId(ids);
        order.setQuantity(RandomUtils.nextInt(1,100));
        order.setShipDate(date);
        order.setStatus("placed");
        order.setComplete(true);
String url="https://petstore.swagger.io/v2/store/order";

        response= given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(order).when()
                .post(URI.create(url));
        response.then().log().all();
        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    public void DeleteCallToDeleteAnOrder() {

        String url="https://petstore.swagger.io/v2/store/order/" + RandomUtils.nextInt(1,10);

        response =given().accept(ContentType.JSON).contentType(ContentType.JSON).when().log().all().delete(URI.create(url));
        response.then().log().all();
        //assertThat(response.statusCode()).isEqualTo(200);
    }
}
