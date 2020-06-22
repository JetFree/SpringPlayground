package com.aopdemo.services;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Database service fortune!";
    }
}
