package com.latam.jala;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.latam.jala.pojos.request.Args;
import com.latam.jala.pojos.request.IncomingData;
import com.latam.jala.pojos.request.Params;
import com.latam.jala.queryBuilder.QueryBuilder;
import com.latam.jala.serializer.Json;

public class app {
    public static void main(String[] args) throws JsonProcessingException {

        String json ="{\"params\":{\"questions\":[{\"question\":\"what is the most repeated publication title\",\"input_args\":[],\"output\":[\"title\",\"type\"]},{\"question\":\"show me the top ten of most repeated publication title filtered by Print book and ordered in descendant mode by frequency\",\"input_args\":[{\"name\":\"type\",\"value\":\"Print book\"},{\"name\":\"limit\",\"value\":10}],\"output\":[\"title\",\"frequency\"]}]}}";

            JsonNode node = Json.parse(json);
            Params inputJson = Json.fromJson(node, Params.class);

            for (IncomingData in : inputJson.getParams().getQuestions()){
                System.out.println(in.getQuestion());

                for(Args at: in.getInput_args()){
                    System.out.println(at.getName() + " = " + at.getValue());
                }

                for(String on : in.getOutput()){
                    System.out.println(on);
                }

                //QueryBuilder qB = new QueryBuilder();
                //System.out.println(qB.queryConstructor(in)+"\n");
            }

    }
}
