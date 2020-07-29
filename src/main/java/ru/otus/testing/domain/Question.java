package ru.otus.testing.domain;

import java.util.List;

public class Question {
    private String question;
    private List<Answer> answers;

    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }
}
