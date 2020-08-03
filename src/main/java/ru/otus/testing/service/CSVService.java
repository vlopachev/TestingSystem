package ru.otus.testing.service;

import ru.otus.testing.domain.Question;

import java.util.List;
import java.util.Scanner;

public interface CSVService {
    List<String[]> getLines();
    void parseCSV(String delimeter);
    List<Question> getAllQuestions();
}
