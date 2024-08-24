package org.banking.account.test.infraestructure.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeAccountEnum {

    SAVINGS("Ahorro"),
    CURRENT("Corriente");

    private final String value;
}
