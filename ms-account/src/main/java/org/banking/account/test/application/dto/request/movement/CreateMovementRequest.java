package org.banking.account.test.application.dto.request.movement;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovementRequest {

//    @NotNull(message = "La fecha del movimiento es obligatoria")
//    private LocalDateTime dateMovement;

    @NotNull(message = "El tipo de movimiento es obligatorio")
    private String transactionType;

    @NotNull(message = "El valor del movimiento es obligatorio")
    private Double valueMovement;

    private Double balance;

    @NotNull(message = "El numero de la cuenta es obligatorio")
    private String accountNumber;

}
