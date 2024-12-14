package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Инициализация контекста Spring
        var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

        // Получение бина ResultsReader из контейнера
        var resultsReader = applicationContext.getBean(ResultsReader.class);

        // Чтение файла results.csv
        Path filePath = new ClassPathResource("results.csv").getFile().toPath();
        List<Result> results = resultsReader.readFromFile(filePath);

        // Инициализация ResultsProcessor с загруженными результатами
        var resultsProcessor = new ResultsProcessor(results);

        // Получение трех самых быстрых мужчин на 10 км
        List<Result> fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);

        System.out.println(fastestMen);
        // Закрытие контекста Spring
        applicationContext.close();
    }
}