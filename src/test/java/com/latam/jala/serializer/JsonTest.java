package com.latam.jala.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.latam.jala.pojos.PojoTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String message = "{\"title\": \"This is a test\"}";

    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(message);
        assertEquals(node.get("title").asText(), "This is a test");
    }

    @Test
    void fromJson() throws IOException{
        JsonNode node = Json.parse(message);
        PojoTest pojo = Json.fromJson(node, PojoTest.class );

        assertEquals(pojo.title, "This is a test");
        System.out.println("Pojo class: "+ pojo.title);
    }

    @Test
    void toJson () {
        PojoTest pojo = new PojoTest();
        pojo.setTitle("Testing");
        JsonNode node = Json.toJson(pojo);

        assertEquals(node.get("title").asText(), "Testing");
    }

    @Test
    void stringify(){
        PojoTest pojo = new PojoTest();
        pojo.setTitle("Maria");
        JsonNode node = Json.toJson(pojo);

        try {
            System.out.println(Json.stringify(node));
//            System.out.println(Json.prettyPrint(node));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}