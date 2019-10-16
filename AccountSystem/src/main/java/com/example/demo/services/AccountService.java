package com.example.demo.services;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal money, long id) throws IllegalAccessException, IllegalArgumentException;
    void transferMoney(BigDecimal money, long id) throws IllegalAccessException, IllegalArgumentException;
}
