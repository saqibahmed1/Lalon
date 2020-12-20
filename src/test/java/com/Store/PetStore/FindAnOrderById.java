package com.Store.PetStore;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.testng.annotations.Test;
import pojo.Order;
import static io.restassured.RestAssured.given;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class FindAnOrderById {
    Response response;
    Order order = new Order();
    @Before
   public void  CreatingAnOrder() {
        long id = RandomUtils.nextInt(1, 19);
        int ids = RandomUtils.nextInt(1, 19);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String date = dateFormat.format(Calendar.getInstance(Locale.getDefault()).getTime());
        order.setId(id);
        order.setPetId(ids);
        order.setQuantity(RandomUtils.nextInt(1, 100));
        order.setShipDate(date);
        order.setStatus("placed");
        order.setComplete(true);


        response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(order).when()
                .post(URI.create("https://petstore.swagger.io/v2/store/order"));
        response.then().log().all();
    }

    @Test
    public void FindTheOrder(){

        String url="https://petstore.swagger.io/v2/store/order/4"+ order.getPetId();
response= given().accept(ContentType.JSON).contentType(ContentType.JSON).when().get(URI.create(url));
response.then().log().all();

    }
}