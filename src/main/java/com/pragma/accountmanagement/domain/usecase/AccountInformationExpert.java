package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException;
import com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Implementa el patrón GRASP Experto en Información.
 * Esta clase es la experta en manejar la información relacionada con las cuentas,
 * incluyendo consultas de saldo, historial de transacciones y estado de cuenta.
 * Tiene acceso a todos los datos necesarios para realizar estos cálculos y consultas.
 */
@Component
public class AccountInformationExpert {

    private final AccountRepository accountRepository;

    public AccountInformationExpert(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Obtiene el saldo actual de una cuenta.
     * Como experto en información, tiene acceso al modelo Account y puede extraer el saldo.
     */
    public BigDecimal getAccountBalance(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getBalance();
    }

    /**
     * Consulta el estado de una cuenta (activa, inactiva, cerrada).
     */
    public String getAccountStatus(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getStatus();
    }

    /**
     * Verifica si una cuenta está activa para realizar operaciones.
     */
    public boolean isAccountActive(UUID accountId) {
        return accountRepository.findById(accountId)
                .map(Account::isActive)
                .orElse(false);
    }

    /**
     * Obtiene información completa de una cuenta por su ID.
     */
    public Account getAccountDetails(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
    }

    /**
     * Obtiene información completa de una cuenta por su número.
     */
    public Account getAccountDetailsByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con número: " + accountNumber));
    }

    /**
     * Obtiene todas las cuentas de un cliente.
     */
    public List<Account> getCustomerAccounts(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    /**
     * Calcula el saldo total de un cliente en todas sus cuentas.
     * Como experto en información, tiene acceso a todas las cuentas del cliente
     * y puede realizar el cálculo agregado.
     */
    public BigDecimal getTotalBalanceForCustomer(String customerId) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return accounts.stream()
                .filter(Account::isActive)
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Obtiene la fecha de apertura de una cuenta.
     */
    public LocalDate getAccountOpeningDate(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getOpeningDate();
    }

    /**
     * Obtiene el tipo de cuenta (ahorro, corriente, etc.).
     */
    public String getAccountType(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getAccountType();
    }

    /**
     * Valida si una cuenta existe y está activa para realizar operaciones.
     */
    public void validateAccountForOperation(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        
        if (!account.isActive()) {
            throw new IllegalStateException(
                    "La cuenta no está activa para realizar operaciones");
        }
    }
}