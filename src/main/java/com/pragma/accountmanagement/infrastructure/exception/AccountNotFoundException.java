package com.pragma.accountmanagement.infrastructure.exception;

public class AccountNotFoundException extends RuntimeException {
    private final String accountIdentifier;
    private final String searchType;

    public AccountNotFoundException(String accountIdentifier) {
        super(String.format("No se encontró la cuenta con identificador: %s", accountIdentifier));
        this.accountIdentifier = accountIdentifier;
        this.searchType = "ID";
    }

    public AccountNotFoundException(String accountIdentifier, String searchType) {
        super(String.format("No se encontró la cuenta con %s: %s", searchType, accountIdentifier));
        this.accountIdentifier = accountIdentifier;
        this.searchType = searchType;
    }

    public AccountNotFoundException(String message, String accountIdentifier, String searchType) {
        super(message);
        this.accountIdentifier = accountIdentifier;
        this.searchType = searchType;
    }

    public AccountNotFoundException(String message, Throwable cause, String accountIdentifier, String searchType) {
        super(message, cause);
        this.accountIdentifier = accountIdentifier;
        this.searchType = searchType;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public String getSearchType() {
        return searchType;
    }

    public String getErrorCode() {
        return "ACCOUNT_NOT_FOUND";
    }
}