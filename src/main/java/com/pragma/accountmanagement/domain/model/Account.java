package com.pragma.accountmanagement.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private UUID id;

    @NotBlank(message = "El número de cuenta no puede estar vacío")
    private String accountNumber;

    @NotBlank(message = "El ID del cliente no puede estar vacío")
    private String customerId;

    @NotNull(message = "El saldo inicial no puede ser nulo")
    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private BigDecimal balance;

    @NotNull(message = "La fecha de apertura no puede ser nula")
    private LocalDate openingDate;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    private String accountType;

    @NotBlank(message = "El estado de la cuenta no puede estar vacío")
    private String status;

    public Account(String accountNumber, String customerId, BigDecimal initialBalance, String accountType) {
        this.id = UUID.randomUUID();
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = initialBalance;
        this.openingDate = LocalDate.now();
        this.accountType = accountType;
        this.status = "ACTIVE";
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        this.balance = this.balance.subtract(amount);
    }

    public boolean isActive() {
        return "ACTIVE".equals(this.status);
    }
}