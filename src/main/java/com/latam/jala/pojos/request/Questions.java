package com.latam.jala.pojos.request;

import java.util.List;

public class Questions {

    private List<IncomingData> questions;

    public List<IncomingData> getQuestions() {
        return questions;
    }

    public void setQuestion(List<IncomingData> question) {
        this.questions = question;
    }
}
