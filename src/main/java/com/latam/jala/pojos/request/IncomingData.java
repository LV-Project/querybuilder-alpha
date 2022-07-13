package com.latam.jala.pojos.request;

import java.util.List;

public class IncomingData {

    private String question;
    private List<Args> input_args;
    private List<String> output;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Args> getInput_args() {
        return input_args;
    }

    public void setInput_args(List<Args> input_args) {
        this.input_args = input_args;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> outputs) {
        this.output = outputs;
    }


}
