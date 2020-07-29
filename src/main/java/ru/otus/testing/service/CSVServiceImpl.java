package ru.otus.testing.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVServiceImpl implements CSVService {
    private List<String[]> lines = new ArrayList<>();

    public void readCSV (String pathFile){
        try (Scanner scanner = new Scanner(new File(pathFile))){
            while (scanner.hasNext()){
                lines.add(scanner.nextLine().split(";"));


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
