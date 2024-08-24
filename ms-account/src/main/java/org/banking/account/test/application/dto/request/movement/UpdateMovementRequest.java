package org.banking.account.test.application.dto.request.movement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovementRequest {

    private LocalDateTime dateMovement;
    private String transactionType;
    private Double valueMovement;
    private Double balance;
    private Long accountId;

}
