package com.bank.accountservice.controller;

import com.bank.accountservice.dto.AccountDTO;
import com.bank.accountservice.model.Account;
import com.bank.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing bank accounts.
 */
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    /** Service layer for account management */
    private final AccountService accountService;

    /**
     * Creates a new account.
     *
     * @param accountDTO DTO containing account details.
     * @return ResponseEntity containing the created account.
     */
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
        log.info("Account created successfully!");
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }

    /**
     * Retrieves all accounts.
     *
     * @return List of accounts.
     */
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    /**
     * Retrieves an account by ID.
     *
     * @param id The account ID.
     * @return ResponseEntity containing the account.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
}
