package org.banking.client.test.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto extends PersonDto {

    private Long clientId;
    private String password;
    private Boolean status;

}
