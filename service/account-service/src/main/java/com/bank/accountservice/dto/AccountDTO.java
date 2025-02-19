package com.bank.accountservice.dto;

import lombok.*;

/**
 * Data Transfer Object (DTO) for transferring account data between API and service layers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {

    /** Customer's full name */
    private String customerName;

    /** Customer's email address */
    private String email;

    /** Initial balance of the account */
    private double balance;
}
