package com.pragma.accountmanagement.infrastructure.dto;


import com.pragma.accountmanagement.domain.model.Account;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AccountDto(
    UUID id,
    
    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    String accountNumber,
    
    @NotBlank(message = "El ID del cliente es obligatorio")
    String customerId,
    
    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.0", message = "El saldo no puede ser negativo")
    BigDecimal balance,
    
    LocalDate openingDate,
    
    @NotBlank(message = "El tipo de cuenta es obligatorio")
    String accountType,
    
    @NotBlank(message = "El estado de la cuenta es obligatorio")
    String status
) {
    public static AccountDto fromDomain(Account account) {
        return new AccountDto(
            account.getId(),
            account.getAccountNumber(),
            account.getCustomerId(),
            account.getBalance(),
            account.getOpeningDate(),
            account.getAccountType(),
            account.getStatus()
        );
    }
}