package org.banking.client.test.application.command;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;
import org.banking.client.test.application.dto.request.UpdateClientRequest;

@Getter
@Setter
public class UpdateClientCommand extends UpdateClientRequest implements Request<Boolean> {

    private Long id;
    public UpdateClientCommand(){
        super();
    }
}
