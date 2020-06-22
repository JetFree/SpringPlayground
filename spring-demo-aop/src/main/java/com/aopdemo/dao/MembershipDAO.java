package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK AN ACCOUNT");
    }

    public void doRequestToApi() {
        System.out.println(getClass() + ": DOING MY API WORK ");
    }
}
