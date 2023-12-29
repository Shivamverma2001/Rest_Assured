import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest {
    @Test
    void test1(){
        //Response response= RestAssured.get("https://regres.in/api/users?page=2");
        Response response= get("https://reqres.in/api/users?page=2");


        System.out.println("Response: "+response.asString());
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Body "+response.getBody().toString());
        System.out.println("Time taken: "+response.getTime());
        System.out.println("Header: "+response.getHeader("content-type"));

        int statusCode=response.getStatusCode();
        assertEquals(200,statusCode);
    }
    @Test
    void test2(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }
    @Test
    void test3(){
        baseURI="https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].id",equalTo(8)).
                log().all();
    }
}
