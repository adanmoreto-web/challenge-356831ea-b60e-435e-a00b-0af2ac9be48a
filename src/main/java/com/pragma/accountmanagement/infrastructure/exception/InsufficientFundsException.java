package com.pragma.accountmanagement.infrastructure.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {
    private final String accountNumber;
    private final BigDecimal currentBalance;
    private final BigDecimal requestedAmount;

    public InsufficientFundsException(String accountNumber, BigDecimal currentBalance, BigDecimal requestedAmount) {
        super(String.format("Fondos insuficientes en la cuenta %s. Saldo actual: %s, monto solicitado: %s",
                accountNumber, currentBalance, requestedAmount));
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public InsufficientFundsException(String message, String accountNumber, BigDecimal currentBalance, BigDecimal requestedAmount) {
        super(message);
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public InsufficientFundsException(String message, Throwable cause, String accountNumber, 
                                       BigDecimal currentBalance, BigDecimal requestedAmount) {
        super(message, cause);
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public BigDecimal getDeficit() {
        return requestedAmount.subtract(currentBalance);
    }

    public String getErrorCode() {
        return "INSUFFICIENT_FUNDS";
    }
}