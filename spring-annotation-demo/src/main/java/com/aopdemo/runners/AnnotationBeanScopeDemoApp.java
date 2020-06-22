package com.aopdemo.runners;

import com.aopdemo.services.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach newCoach = context.getBean("tennisCoach", Coach.class);

        boolean result = (coach == newCoach);
        System.out.println("Result is: " + result);
        System.out.println("Memory location for the first Coach: " + coach);
        System.out.println("Memory location for the second Coach: " + newCoach);

        context.close();
    }
}
