package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK AN ACCOUNT");
    }

    public List<Account> findAccounts(boolean tripWire) throws Exception {
        if (tripWire) {
            throw new RuntimeException("Simple exception");
        }
        return Arrays.asList(new Account(1, "Main Account"), new Account(2, "Home account"));
    }

    public boolean addSillyMethod() {
        System.out.println(getClass() + ": DOING MY SILLY WORK AN ACCOUNT");
        return true;
    }

    public boolean addAnythingToAccount(Account account) {
        System.out.println(getClass() + ": RUNNING METHOD addAnythingToAccount");
        return true;
    }

    public void getNothing() {
        System.out.println("Running getter method");
    }

    public void setNothing() {
        System.out.println("Running setter method");
    };
}
