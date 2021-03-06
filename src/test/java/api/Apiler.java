package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import utilities.ConfigReader;
import utilities.Hooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Apiler extends TestBase {
    /*
    Hooks hooks = new Hooks();
    public Response response;
    public JsonPath jsonPath;
    public static String boardId;
    public static String listId;
    public static String cardId;
    public List<String> cardIdList=new ArrayList<>();
    ApiData apiData = new ApiData();
    public static int count=0;

@Test
    public void  createBoard() {

        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "boards");
        HashMap<String, String> requestBody1 = new HashMap<>();
        requestBody1.put("name", "boardName");
        requestBody1.put("key", ConfigReader.getProperty("key"));
        requestBody1.put("token", ConfigReader.getProperty("token"));

        System.out.println(requestBody1);
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody1).
                when().
                post("/{parametre1}/{parametre2}");

        response.prettyPrint();

        jsonPath = response.jsonPath();
        Assert.assertEquals(200, response.getStatusCode());
       Assert.assertEquals("board1", jsonPath.getString("name"));
        boardId=jsonPath.getString("id");

       //return this;
    }

    public Apiler createList() {
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "lists");
        HashMap<String, String> requestBody = apiData.requestData();
        requestBody.put("name", "list");
        requestBody.put("idBoard", boardId);
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}");
        jsonPath = response.jsonPath();
        listId=jsonPath.getString("id");
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("list", jsonPath.getString("name"));
        return this;
    }

    public Apiler createCard() {
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "cards");
        HashMap<String, String> requestBody =apiData.requestData();
        requestBody.put("name", "card");
        requestBody.put("idList", listId);
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}");
        jsonPath = response.jsonPath();
        cardId=jsonPath.getString("id");
        cardIdList.add(cardId);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("card", jsonPath.getString("name"));
        return this;
    }

    public Apiler updateCard() {
        int random=hooks.randomCount(cardIdList.size());
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "cards");
        HashMap<String, String> requestBody = apiData.requestData();
        requestBody.put("name","updatecard");
        requestBody.put("id", cardIdList.get(random));
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                put("/{parametre1}/{parametre2}");
        jsonPath = response.jsonPath();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("updatecard", jsonPath.getString("name"));
        return this;
    }
    public Apiler deleteCard() {
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "cards","parametre3",cardIdList.get(count));
        count++;
        HashMap<String, String> requestBody =apiData.requestData();
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token", ConfigReader.getProperty("token"));
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                delete("/{parametre1}/{parametre2}/{parametre3}");
        Assert.assertEquals(200, response.getStatusCode());
        return this;

    }
    public Apiler deleteBoard() {
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "cards","parametre3", boardId);
        HashMap<String, String> requestBody =apiData.requestData();
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token", ConfigReader.getProperty("token"));
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                delete("/{parametre1}/{parametre2}/{parametre3}");
        Assert.assertEquals(200, response.getStatusCode());
        return this;
    }

 */
}
