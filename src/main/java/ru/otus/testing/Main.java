package ru.otus.testing;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("classpath:settings.properties")

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev (){
        return new PropertySourcesPlaceholderConfigurer();
    }


}
