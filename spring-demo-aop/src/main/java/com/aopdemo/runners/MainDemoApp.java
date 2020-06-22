package com.aopdemo.runners;

import com.aopdemo.Account;
import com.aopdemo.configs.DemoConfig;
import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainDemoApp {

    private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
//        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
//        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//        membershipDAO.addAccount();
//        accountDAO.addAccount();
//        accountDAO.addSillyMethod();
//        accountDAO.addAnythingToAccount(new Account(3, "General Account"));
//        accountDAO.getNothing();
//        accountDAO.setNothing();
//        membershipDAO.doRequestToApi();

//        try {
//            accountDAO.findAccounts(true);
//        } catch (Exception e) {
//            System.out.println("Main program caught exception!");
//        }
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Calling getFortune");
        String data = fortuneService.getFortune();
        myLogger.info("My fortune is: " + data);
        myLogger.info("Finished");

        context.close();
    }
}
