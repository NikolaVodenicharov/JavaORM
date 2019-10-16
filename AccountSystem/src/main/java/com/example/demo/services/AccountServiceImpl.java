package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, long id) throws IllegalAccessException, IllegalArgumentException {
        if (money.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Money must be positive number.");
        }

        if (!this.accountRepository.existsById(id)){
            throw new IllegalAccessException("id does not exist.");
        }

        var account = this.accountRepository.findById(id).get();

        if (account.getBalance().compareTo(money) < 0){
            throw new IllegalArgumentException("Not enough money.");
        }

        var updatedBalance = account.getBalance().subtract(money);
        account.setBalance(updatedBalance);

        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, long id) throws IllegalAccessException, IllegalArgumentException {
        if (money.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Money must be positive number.");
        }

        if (!this.accountRepository.existsById(id)){
            throw new IllegalAccessException("id does not exist.");
        }

        var account = this.accountRepository.findById(id).get();

        var updatedBalance = account.getBalance().add(money);
        account.setBalance(updatedBalance);

        this.accountRepository.save(account);
    }
}
