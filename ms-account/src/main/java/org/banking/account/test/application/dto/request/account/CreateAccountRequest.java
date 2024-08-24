package org.banking.account.test.application.dto.request.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Long clientId;

}
