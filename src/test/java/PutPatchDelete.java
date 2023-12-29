import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {
    //@Test
    public void putTest(){
        baseURI="https://reqres.in/api";
        JSONObject request=new JSONObject();
        request.put("name","Shivam");
        request.put("job","sde");

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/users/2").
        then().
                statusCode(200).
                log().all();
    }
   // @Test
    public void patchTest(){
        baseURI="https://reqres.in/api";
        JSONObject request=new JSONObject();
        request.put("name","shivam");
        request.put("job","sde");

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("/users/2").
        then().
                statusCode(200).
                log().all();
    }
    @Test
    public void deleteTest(){
        baseURI="https://reqres.in/api";
        when().
                delete("/users/2").
        then().
                statusCode(204);
    }
}
