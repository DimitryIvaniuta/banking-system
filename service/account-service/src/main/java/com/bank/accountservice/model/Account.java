package com.bank.accountservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a bank account entity stored in MongoDB.
 */
@Document(collection = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    /** Unique identifier for the account */
    @Id
    private String id;

    /** Customer's full name */
    private String customerName;

    /** Customer's email address */
    private String email;

    /** Current balance of the account */
    private double balance;
}
