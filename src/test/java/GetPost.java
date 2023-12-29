import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetPost {
    @Test
    public void getTest(){
        baseURI="https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[4].first_name",equalTo("George")).
                body("data.first_name",hasItems("George","Rachel"));
    }
    @Test
    public void postTes(){
//        Map<String, Object> map=new HashMap<>();
//        map.put("name","shivam");
//        map.put("job","sde");
//
//        JSONObject request=new JSONObject(map);

        JSONObject request=new JSONObject();
        request.put("name","Shivam");
        request.put("job","sde");

        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                post("/users").
        then().
                statusCode(201).
                log().all();
    }
}
