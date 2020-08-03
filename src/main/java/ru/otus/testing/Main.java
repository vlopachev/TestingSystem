package ru.otus.testing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.otus.testing.service.CSVService;
import ru.otus.testing.service.CSVServiceImpl;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan
@PropertySource("classpath:settings.properties")

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        CSVService csvService = (CSVService) context.getBean(CSVServiceImpl.class);
        csvService.parseCSV(",");

        for (String [] line: csvService.getLines()) {
            System.out.println(line[3]);
        }

        System.out.println(csvService.getAllQuestions());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev (){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CSVService csvService(@Value("${path.to.csv.file}")String pathFile){
        return new CSVServiceImpl(pathFile);
    }

}
