package com.aopdemo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class PropertyFortuneService implements FortuneService {

    @Value("${fortune1}")
    private String firstFortune;

    @Value("${fortune2}")
    private String secondFortune;

    @Value("${fortune3}")
    private String thirdFortune;

    String[] arr;

    @PostConstruct
    public void initializeArray() {
        arr = new String[]{firstFortune, secondFortune, thirdFortune};
    }

    @Override
    public String getFortune() {
        Random random = new Random();
        return arr[random.nextInt(3)];
    }
}
