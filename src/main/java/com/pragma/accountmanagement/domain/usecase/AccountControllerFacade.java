package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Implementa el patrón GRASP Controlador.
 * Esta clase actúa como controlador de aplicación, siendo el intermediary
 * entre la capa de presentación (controladores REST) y los casos de uso del dominio.
 * Coordina las operaciones y delega a las clases Expertas en Información y Creadoras.
 */
@Service
public class AccountControllerFacade {

    private final AccountRepository accountRepository;
    private final AccountInformationExpert informationExpert;
    private final AccountCreator accountCreator;

    public AccountControllerFacade(AccountRepository accountRepository,
                                   AccountInformationExpert informationExpert,
                                   AccountCreator accountCreator) {
        this.accountRepository = accountRepository;
        this.informationExpert = informationExpert;
        this.accountCreator = accountCreator;
    }

    /**
     * Crea una nueva cuenta en el sistema.
     * Delega la creación al AccountCreator (Patrón Creador).
     */
    public Account createAccount(String accountNumber, String customerId, 
                                  BigDecimal initialBalance, String accountType) {
        return accountCreator.create(accountNumber, customerId, initialBalance, accountType);
    }

    /**
     * Realiza un depósito en una cuenta.
     * Coordina la validación y la operación de depósito.
     */
    public Account deposit(UUID accountId, BigDecimal amount) {
        validatePositiveAmount(amount);
        informationExpert.validateAccountForOperation(accountId);
        
        Account account = informationExpert.getAccountDetails(accountId);
        account.deposit(amount);
        return accountRepository.save(account);
    }

    /**
     * Realiza un retiro de una cuenta.
     * Coordina la validación de fondos suficientes y la operación de retiro.
     */
    public Account withdraw(UUID accountId, BigDecimal amount) {
        validatePositiveAmount(amount);
        informationExpert.validateAccountForOperation(accountId);
        
        Account account = informationExpert.getAccountDetails(accountId);
        account.withdraw(amount);
        return accountRepository.save(account);
    }

    /**
     * Obtiene los detalles de una cuenta por su ID.
     */
    public Account getAccount(UUID accountId) {
        return informationExpert.getAccountDetails(accountId);
    }

    /**
     * Obtiene los detalles de una cuenta por su número.
     */
    public Account getAccountByNumber(String accountNumber) {
        return informationExpert.getAccountDetailsByNumber(accountNumber);
    }

    /**
     * Obtiene todas las cuentas de un cliente.
     */
    public List<Account> getAccountsByCustomer(String customerId) {
        return informationExpert.getCustomerAccounts(customerId);
    }

    /**
     * Obtiene el saldo de una cuenta.
     */
    public BigDecimal getBalance(UUID accountId) {
        return informationExpert.getAccountBalance(accountId);
    }

    /**
     * Obtiene el estado de una cuenta.
     */
    public String getStatus(UUID accountId) {
        return informationExpert.getAccountStatus(accountId);
    }

    /**
     * Cierra una cuenta existente.
     */
    public void closeAccount(UUID accountId) {
        Account account = informationExpert.getAccountDetails(accountId);
        
        if (account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException(
                    "No se puede cerrar una cuenta con saldo pendiente: " + 
                    account.getBalance());
        }
        
        accountRepository.deleteById(accountId);
    }

    /**
     * Obtiene el saldo total de un cliente.
     */
    public BigDecimal getTotalCustomerBalance(String customerId) {
        return informationExpert.getTotalBalanceForCustomer(customerId);
    }

    /**
     * Valida que el monto sea positivo.
     */
    private void validatePositiveAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero");
        }
    }
}