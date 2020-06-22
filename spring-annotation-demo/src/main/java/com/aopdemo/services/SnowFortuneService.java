package com.aopdemo.services;

public class SnowFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "There is a lot of snow today!";
    }
}
