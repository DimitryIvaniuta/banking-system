package com.bank.accountservice.repository;

import com.bank.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing Account entities in MongoDB.
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    /**
     * Finds an account by email.
     *
     * @param email Email address of the customer.
     * @return Optional containing the account if found.
     */
    Optional<Account> findByEmail(String email);
}
