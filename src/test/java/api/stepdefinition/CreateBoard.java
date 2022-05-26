package api.stepdefinition;

import api.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateBoard extends TestBase {
    // public String idBoard;
    public Response response1;
    JsonPath jsonPath;

    @Given("Send POST request for create {string} board")
    public void send_post_request_for_create_board(String boardName) {
        //url tanımla
        //expected data-request data
        // request gönder
        //resposu al
        //assert et
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "boards");
        HashMap<String, String> requestBody1 = new HashMap<>();
        requestBody1.put("name", boardName);
        requestBody1.put("key", ConfigReader.getProperty("key"));
        requestBody1.put("token", ConfigReader.getProperty("token"));

        System.out.println(requestBody1);

        response1 = given().
                spec(spec).
                contentType("application/json").
                body(requestBody1).
                when().
                post("/{parametre1}/{parametre2}");

        response1.prettyPrint();

        jsonPath = response1.jsonPath();

    }

    @Then("yazdirma")
    public void yazdirma() {
        try {

            FileWriter fw = new FileWriter("C:/Users/furkan/Desktop/boardId.txt");
            fw.write(response1.prettyPrint());
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Then("okuma")
    public void okuma() {

        char[] dizi = new char[1000];

        try {
            FileReader fr = new FileReader("C:/Users/furkan/Desktop/boardId.txt");
            fr.read(dizi);
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(dizi);
        //String x = new String();
        //String idBoard = StringUtils.substringBetween();
        String idBoard = str.substring(13, 37);
        System.out.println(idBoard);

    }


    @Then("Assert status code {int}")
    public void assert_status_code(int statusCode) {

        Assert.assertEquals(statusCode,response1.getStatusCode());
        //Assert.assertEquals(id,response1.getSessionId());

    }
    @Then("Assert board name is {string}")
    public void assert_board_name_is(String boardName) {

        Assert.assertEquals(boardName,jsonPath.getString("name"));

    }


}
