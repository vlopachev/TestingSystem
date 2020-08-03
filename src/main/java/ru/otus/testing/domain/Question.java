package ru.otus.testing.domain;

import java.util.List;
import java.util.Objects;

public class Question {
    private int id;
    private String question;
    private List<Answer> answers;

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' + "\n" +
                ", answers=" + answers +
                '}';
    }
}
