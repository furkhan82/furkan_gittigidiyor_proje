package api.stepdefinition;

import api.TestBase;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Update extends TestBase {
    public Response response1;
    JsonPath jsonPath;
    @Given("rastgele bir karti update")
    public void rastgele_bir_karti_update() {
        char[] dizi = new char[1000];

        try {
            FileReader fr = new FileReader("C:/Users/furkan/Desktop/cardId1.txt");
            fr.read(dizi);
            fr.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        String x = new String(dizi);
        String idCard= StringUtils.substringBetween(x,"id\": \"","\",");

        System.out.println("Kart İD si : "+ idCard);
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "cards");
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("name","updatecard");
        requestBody.put("id", idCard);
        response1 = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                put("/{parametre1}/{parametre2}");
        response1.prettyPrint();
        jsonPath = response1.jsonPath();

    }
}
