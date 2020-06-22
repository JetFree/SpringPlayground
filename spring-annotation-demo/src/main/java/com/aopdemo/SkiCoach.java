package com.aopdemo;

import com.aopdemo.services.Coach;
import com.aopdemo.services.FortuneService;

public class SkiCoach implements Coach {

    private FortuneService fortuneService;

    public SkiCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do ski twice a day for 2 hours";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
