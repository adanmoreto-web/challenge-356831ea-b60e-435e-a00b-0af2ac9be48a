package com.pragma.accountmanagement.domain.ports;

import com.pragma.accountmanagement.domain.model.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByCustomerId(String customerId);
    void deleteById(UUID id);
    boolean existsByAccountNumber(String accountNumber);
}