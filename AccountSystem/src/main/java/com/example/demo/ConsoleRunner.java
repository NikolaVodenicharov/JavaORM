package com.example.demo;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.services.AccountServiceImpl;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService){
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        var account = new Account();
        account.setBalance(new BigDecimal("30000"));

        var user = new User();
        user.setUsername("SecondUser");
        user.setAge(30);
        user.getAccounts().add(account);

        account.setUser(user);

        this.userService.registerUser(user);

        this.accountService.withdrawMoney(new BigDecimal("20000"), account.getId());
        this.accountService.transferMoney(new BigDecimal("20000"), 1L);


    }
}
