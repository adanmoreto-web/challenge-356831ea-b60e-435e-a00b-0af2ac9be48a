package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String accountNumber, String customerId, BigDecimal initialBalance, String accountType) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Ya existe una cuenta con ese número");
        }

        Account account = new Account(accountNumber, customerId, initialBalance, accountType);
        return accountRepository.save(account);
    }

    public Account getAccountById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada con ID: " + id));
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada con número: " + accountNumber));
    }

    public List<Account> getAccountsByCustomerId(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    public Account deposit(UUID accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        if (!account.isActive()) {
            throw new IllegalStateException("No se puede depositar en una cuenta inactiva");
        }
        account.deposit(amount);
        return accountRepository.save(account);
    }

    public Account withdraw(UUID accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        if (!account.isActive()) {
            throw new IllegalStateException("No se puede retirar de una cuenta inactiva");
        }
        account.withdraw(amount);
        return accountRepository.save(account);
    }

    public void closeAccount(UUID accountId) {
        Account account = getAccountById(accountId);
        if (account.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo diferente de cero");
        }
        account.setStatus("CLOSED");
        accountRepository.save(account);
    }
}