package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException;

import java.math.BigDecimal;

public class AccountCreator {

    private final AccountRepository accountRepository;

    public AccountCreator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(String accountNumber, String customerId, BigDecimal initialBalance, String accountType) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Ya existe una cuenta con el número: " + accountNumber);
        }

        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }

        Account newAccount = new Account(accountNumber, customerId, initialBalance, accountType);
        return accountRepository.save(newAccount);
    }

    public Account createWithDefaultBalance(String accountNumber, String customerId, String accountType) {
        return create(accountNumber, customerId, BigDecimal.ZERO, accountType);
    }

    public Account createWithMinimumBalance(String accountNumber, String customerId, BigDecimal minimumBalance, String accountType) {
        if (minimumBalance == null || minimumBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo mínimo no puede ser negativo");
        }
        return create(accountNumber, customerId, minimumBalance, accountType);
    }
}