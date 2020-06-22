package com.aopdemo;

import com.aopdemo.services.Coach;
import com.aopdemo.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SnowboardCoach implements Coach {

    @Autowired
    @Qualifier("propertyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Do exercise for your legs and back";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
