package com.latam.jala.pojos.response;


import java.util.List;

public class Response {

    private String question;
    private List<Books> response;
    private int response_size = response.size();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Books> getResponse() {
        return response;
    }

    public void setResponse(List<Books> response) {
        this.response = response;
    }

    public int getResponse_size() {
        return response_size;
    }

    public void setResponse_size(int response_size) {
        this.response_size = response_size;
    }
}
