package org.banking.account.test.infraestructure.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeMovementEnum {

    DEPOSIT("Deposito"),
    WITHDRAWAL("Retiro"),
    TRANSFER("Transferencia"),
    PAYMENT("Pagos");

    private final String value;
}
