package org.banking.client.test.domain.producer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClientProducerDto implements Serializable {

    private Long clientId;
    private String name;
    private String identification;

}
