package com.bank.accountservice.service;

import com.bank.accountservice.dto.AccountDTO;
import com.bank.accountservice.exception.AccountNotFoundException;
import com.bank.accountservice.model.Account;
import com.bank.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for handling business logic related to accounts.
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    /** Repository for accessing account data */
    private final AccountRepository accountRepository;

    /**
     * Creates a new account.
     *
     * @param accountDTO Data Transfer Object containing account details.
     * @return The created Account object.
     */
    public Account createAccount(AccountDTO accountDTO) {
        Account account = Account.builder()
                .customerName(accountDTO.getCustomerName())
                .email(accountDTO.getEmail())
                .balance(accountDTO.getBalance())
                .build();
        return accountRepository.save(account);
    }

    /**
     * Retrieves all accounts.
     *
     * @return List of all accounts.
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Retrieves an account by ID.
     *
     * @param id The account ID.
     * @return The Account object.
     * @throws AccountNotFoundException If the account is not found.
     */
    public Account getAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + id));
    }
}
