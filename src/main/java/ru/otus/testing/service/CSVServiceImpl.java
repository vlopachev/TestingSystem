package ru.otus.testing.service;

import ru.otus.testing.domain.Answer;
import ru.otus.testing.domain.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CSVServiceImpl implements CSVService {
    private List<String[]> lines = new ArrayList<>();
    private String pathFile;

    public List<String[]> getLines() {
        return lines;
    }

    public CSVServiceImpl(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void parseCSV(String delimeter) {
        File file = new File(pathFile);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine().split(delimeter));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            int questionId = Integer.parseInt(lines.get(i)[0]);

            List<Answer> answers;
            Question question = new Question(questionId, lines.get(i)[1]);
            Answer answer = new Answer(Integer.parseInt(lines.get(i)[2])
                    , questionId, lines.get(i)[3], Boolean.valueOf(lines.get(i)[4]));

            if (questions.contains(question)) {
                Question existQuestion = questions.get(questions.indexOf(question));
                answers = existQuestion.getAnswers();
                answers.add(answer);
            } else {
                answers = new ArrayList<>();
                answers.add(answer);
                question.setAnswers(answers);
                questions.add(question);
            }
        }
        return questions;
    }
}



