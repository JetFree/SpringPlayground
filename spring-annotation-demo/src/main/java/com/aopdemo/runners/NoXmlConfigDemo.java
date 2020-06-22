package com.aopdemo.runners;

import com.aopdemo.services.Coach;
import com.aopdemo.configs.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXmlConfigDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach = configApplicationContext.getBean("tennisCoach", Coach.class);
        System.out.println(coach.getDailyFortune());
    }
}
