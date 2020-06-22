package com.aopdemo.runners;

import com.aopdemo.services.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Coach coach = context.getBean("tennisCoach", Coach.class);
//        System.out.println(coach.getDailyWorkout());
//        System.out.println(coach.getDailyFortune());

        Coach newCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println(newCoach.getDailyWorkout());
        System.out.println(newCoach.getDailyFortune());
        context.close();
    }
}
