package api.stepdefinition;

import api.TestBase;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import utilities.ConfigReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteCard2 extends TestBase {

    public Response response1;

    @Given("iki karti sil")
    public void iki_karti_sil() {
        char[] dizi = new char[1000];

        try {
            FileReader fr = new FileReader("C:/Users/furkan/Desktop/cardId2.txt");
            fr.read(dizi);
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String x = new String(dizi);
        String idCard= StringUtils.substringBetween(x,"id\": \"","\",");

        System.out.println("1. Kart İD si : "+ idCard);


        setUp();
        spec.pathParams("parametre1",1,"parametre2","cards","parametre3",idCard);
        HashMap<String,String> requestBody1 = new HashMap<>();
        requestBody1.put("key", ConfigReader.getProperty("key"));
        requestBody1.put("token",ConfigReader.getProperty("token"));

        System.out.println(requestBody1);

        response1 =given().
                spec(spec).
                contentType("application/json").
                body(requestBody1).
                when().
                delete("/{parametre1}/{parametre2}/{parametre3}");



    }


}
