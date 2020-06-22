package com.aopdemo.services;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private List<String> fortunes = new ArrayList<>();
    private final String FORTUNES_FILE_NAME="spring-annotation-demo/src/main/resources/fortunes.txt";

    @PostConstruct
    public void readFortunesFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FORTUNES_FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                for (String fortune : line.split(", ")) {
                    fortunes.add(fortune);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
