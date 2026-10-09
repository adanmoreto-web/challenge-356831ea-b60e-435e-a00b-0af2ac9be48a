package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountControllerFacadeTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountInformationExpert informationExpert;

    @Mock
    private AccountCreator accountCreator;

    @InjectMocks
    private AccountControllerFacade facade;

    private Account account;
    private UUID accountId;

    @BeforeEach
    void setUp() {
        accountId = UUID.randomUUID();
        account = new Account("123", "CUST", new BigDecimal("100"), "SAVINGS");
        account.setId(accountId);
    }

    @Test
    void createAccount_Success() {
        when(accountCreator.create(any(), any(), any(), any())).thenReturn(account);

        Account result = facade.createAccount("123", "CUST", new BigDecimal("100"), "SAVINGS");

        assertNotNull(result);
        verify(accountCreator).create("123", "CUST", new BigDecimal("100"), "SAVINGS");
    }

    @Test
    void deposit_Success() {
        when(informationExpert.getAccountDetails(accountId)).thenReturn(account);
        when(accountRepository.save(any())).thenReturn(account);

        Account result = facade.deposit(accountId, new BigDecimal("50"));

        assertNotNull(result);
        assertEquals(new BigDecimal("150"), account.getBalance());
        verify(informationExpert).validateAccountForOperation(accountId);
    }

    @Test
    void withdraw_Success() {
        when(informationExpert.getAccountDetails(accountId)).thenReturn(account);
        when(accountRepository.save(any())).thenReturn(account);

        Account result = facade.withdraw(accountId, new BigDecimal("50"));

        assertNotNull(result);
        assertEquals(new BigDecimal("50"), account.getBalance());
        verify(informationExpert).validateAccountForOperation(accountId);
    }
}
