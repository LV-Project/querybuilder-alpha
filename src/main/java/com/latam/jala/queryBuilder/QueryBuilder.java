package com.latam.jala.queryBuilder;

import com.latam.jala.pojos.request.Args;
import com.latam.jala.pojos.request.IncomingData;

import java.util.Locale;

public class QueryBuilder {

    private String query="select ";


    private void select(IncomingData data){

        if (data.getOutput() == null){
            query = query + " " + "*";
        }

        if(data.getOutput().contains("frequency") || data.getQuestion().contains("most repeated")) {

                String output = data.getOutput().stream().filter(x -> x.toLowerCase() != "frequency").findAny().get();
                    query = query + output + "," + "count(" + output + ") AS Frequency,";


        }else{
            for (String in : data.getOutput()) {
                    query = query + " " + in + ",";
            }
        }
        StringBuilder sb = new StringBuilder(query);
        sb.deleteCharAt(sb.length()-1);

        query = sb.toString() + " from publications_db_leo.library_leo ";
    }

    private void where(IncomingData data){
        if(!data.getInput_args().isEmpty()){

            query = query + "where ";

            for(Args in: data.getInput_args()){
                if(!in.getName().equals("limit")) {
                    query = query + in.getName() + " = " + "\'" + in.getValue() + "\'" + ",";
                }
            }

            StringBuilder sb = new StringBuilder(query);
            sb.deleteCharAt(sb.length()-1);
            query = sb.toString();
        }
    }

    private void frequency(IncomingData data){
        if(data.getOutput().contains("frequency") || data.getQuestion().contains("most repeated")){
            query = query + " group by " + data.getOutput().stream().filter(x -> x.toLowerCase() != "frequency").findAny().get();
        }

        if(data.getQuestion().contains("descendant") || data.getInput_args().isEmpty()){
            query = query +" order by Frequency DESC";
        } else{
            query = query +" order by Frequency ASC";
        }

    }

    private void limit(IncomingData data){
        for( Args in: data.getInput_args()){
            if (in.getName().toLowerCase().equals("limit")){
                query = query + " limit " + in.getValue();
            }
        }

        if(data.getQuestion().toLowerCase().contains("what is the most")){
            query = query + " limit 1";
        }
    }

    public String queryConstructor (IncomingData data){

        select(data);
        where(data);
        frequency(data);
        limit(data);

        return query;
    }
}
