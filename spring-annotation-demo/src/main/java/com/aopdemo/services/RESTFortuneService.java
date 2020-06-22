package com.aopdemo.services;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "REST service fortune";
    }
}
