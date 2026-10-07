package com.pragma.accountmanagement.infrastructure.controllers;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.usecase.AccountControllerFacade;
import com.pragma.accountmanagement.infrastructure.dto.AccountDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para operaciones de gestión de cuentas.
 * Expone los endpoints para crear cuentas, realizar depósitos, retiros,
 * consultas de saldo y otras operaciones relacionadas con cuentas bancarias.
 */
@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Cuentas", description = "API para gestión de cuentas bancarias")
public class AccountController {

    private final AccountControllerFacade accountFacade;

    public AccountController(AccountControllerFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping
    @Operation(summary = "Crear cuenta", description = "Crea una nueva cuenta bancaria")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        Account account = accountFacade.createAccount(
                accountDto.accountNumber(),
                accountDto.customerId(),
                accountDto.balance() != null ? accountDto.balance() : BigDecimal.ZERO,
                accountDto.accountType()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AccountDto.fromDomain(account));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cuenta", description = "Obtiene los detalles de una cuenta por su ID")
    public ResponseEntity<AccountDto> getAccount(@PathVariable UUID id) {
        Account account = accountFacade.getAccount(id);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @GetMapping("/number/{accountNumber}")
    @Operation(summary = "Obtener cuenta por número", 
               description = "Obtiene los detalles de una cuenta por su número")
    public ResponseEntity<AccountDto> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountFacade.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Cuentas por cliente", 
               description = "Obtiene todas las cuentas de un cliente")
    public ResponseEntity<List<AccountDto>> getAccountsByCustomer(@PathVariable String customerId) {
        List<AccountDto> accounts = accountFacade.getAccountsByCustomer(customerId)
                .stream()
                .map(AccountDto::fromDomain)
                .toList();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}/balance")
    @Operation(summary = "Consultar saldo", description = "Obtiene el saldo de una cuenta")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable UUID id) {
        BigDecimal balance = accountFacade.getBalance(id);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/{id}/status")
    @Operation(summary = "Consultar estado", description = "Obtiene el estado de una cuenta")
    public ResponseEntity<String> getStatus(@PathVariable UUID id) {
        String status = accountFacade.getStatus(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/customer/{customerId}/total-balance")
    @Operation(summary = "Saldo total del cliente", 
               description = "Obtiene el saldo total de todas las cuentas de un cliente")
    public ResponseEntity<BigDecimal> getTotalCustomerBalance(@PathVariable String customerId) {
        BigDecimal totalBalance = accountFacade.getTotalCustomerBalance(customerId);
        return ResponseEntity.ok(totalBalance);
    }

    @PostMapping("/{id}/deposit")
    @Operation(summary = "Depósito", description = "Realiza un depósito en una cuenta")
    public ResponseEntity<AccountDto> deposit(@PathVariable UUID id, 
                                               @RequestParam BigDecimal amount) {
        Account account = accountFacade.deposit(id, amount);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @PostMapping("/{id}/withdraw")
    @Operation(summary = "Retiro", description = "Realiza un retiro de una cuenta")
    public ResponseEntity<AccountDto> withdraw(@PathVariable UUID id, 
                                                @RequestParam BigDecimal amount) {
        Account account = accountFacade.withdraw(id, amount);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cerrar cuenta", description = "Cierra una cuenta bancaria")
    public ResponseEntity<Void> closeAccount(@PathVariable UUID id) {
        accountFacade.closeAccount(id);
        return ResponseEntity.noContent().build();
    }
}