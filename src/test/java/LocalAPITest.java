import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class LocalAPITest {
    @Test
    public void getTest(){
        baseURI="http://localhost:3000";
        given().
                get("/posts").
        then().
                statusCode(200).
                log().all();
    }
    @Test
    public void postTest(){
        baseURI="http://localhost:3000";
        JSONObject request=new JSONObject();
        request.put("id",2);
        request.put("title","json-server");
        request.put("author","typicode");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                post("/posts").
        then().
                statusCode(201).
                log().all();
    }
    @Test
    public void putTest(){
        baseURI="http://localhost:3000";
        JSONObject request=new JSONObject();
        request.put("id",1);
        request.put("title","sv title");
        request.put("author","sv");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                post("/posts").
                then().
                statusCode(201).
                log().all();
    }
}
