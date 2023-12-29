import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class SOAPAPI {
    @Test
    public void soapApi() throws IOException {
        File file = new File("./SoapRequest/Add.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "http://www.dneonline.com";
        given().
                log().all(). // Log the request details
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx").
                then().
                log().all(). // Log the response details
                statusCode(200).
                and().body("//*:AddResult.text()",equalTo("200")).
                and().assertThat().body(matchesXsdInClasspath("Calculator.xsd"));
    }
}
