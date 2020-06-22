package com.aopdemo.runners;

import com.aopdemo.SwimCoach;
import com.aopdemo.configs.SportConfig;
import com.aopdemo.services.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SnowSwimJavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach coach = configApplicationContext.getBean("swimCoach", SwimCoach.class);
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getTeam());
        System.out.println(coach.getEmail());

        Coach coach1 = configApplicationContext.getBean("skiCoach", Coach.class);
        System.out.println(coach1.getDailyFortune());
        System.out.println(coach1.getDailyWorkout());
    }
}
