package api.stepdefinition;

import api.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.ConfigReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateList  extends TestBase {

     public CreateBoard A =new CreateBoard();

    public Response response1;
    JsonPath jsonPath;

    @Given("Post List yapmak {string}")
    public void Post_List_yapmak(String listname1) {
        char[] dizi = new char[100];

        try {
            FileReader fr = new FileReader("C:/Users/furkan/Desktop/boardId.txt");
            fr.read(dizi);
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(dizi);
        String idBoard = new String();
        idBoard = str.substring(13, 37);

        setUp();
        spec.pathParams("parametre1",1,"parametre2","lists");
        HashMap<String,String> requestBody1 = new HashMap<>();
        requestBody1.put("name", listname1);
        requestBody1.put("idBoard",idBoard);
        requestBody1.put("key", ConfigReader.getProperty("key"));
        requestBody1.put("token",ConfigReader.getProperty("token"));

        System.out.println(requestBody1);

        response1 =given().
                spec(spec).
                contentType("application/json").
                body(requestBody1).
                when().
                post("/{parametre1}/{parametre2}");

        response1.prettyPrint();
        jsonPath=response1.jsonPath();

        try {

            FileWriter fw = new FileWriter("C:/Users/furkan/Desktop/listId.txt");
            fw.write(response1.prettyPrint());
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
