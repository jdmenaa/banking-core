package org.banking.account.test.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovementDto {
    private Long id;
    private LocalDateTime dateMovement;
    private String transactionType;
    private Double valueMovement;
    private Double balance;
    private Long accountId;
}
