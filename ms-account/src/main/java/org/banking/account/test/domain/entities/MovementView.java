package org.banking.account.test.domain.entities;

import java.time.LocalDateTime;

public interface MovementView {
    Long getId();
    LocalDateTime getDateMovement();
    String getTransactionType();
    Double getValueMovement();
    Double getBalance();
    Long getAccountId();
}
