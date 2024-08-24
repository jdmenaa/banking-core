package org.banking.client.test.application.command;

import io.jkratz.mediator.core.Request;
import org.banking.client.test.application.dto.request.CreateClientRequest;

public class CreateClientCommand extends CreateClientRequest implements Request<Boolean> {
    public CreateClientCommand(){
        super();
    }
}
