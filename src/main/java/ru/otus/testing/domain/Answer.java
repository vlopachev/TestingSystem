package ru.otus.testing.domain;

import java.util.Objects;

public class Answer {
    private int id;
    private int questionId;
    private String answer;

    private boolean correct;

    public Answer(int id, int questionId, String answer, boolean correct) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id &&
                questionId == answer.questionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionId);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                '}' + "\n";
    }
}
