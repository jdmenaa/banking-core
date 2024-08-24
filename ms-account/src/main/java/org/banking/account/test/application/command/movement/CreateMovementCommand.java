package org.banking.account.test.application.command.movement;

import io.jkratz.mediator.core.Request;
import org.banking.account.test.application.dto.request.movement.CreateMovementRequest;

public class CreateMovementCommand extends CreateMovementRequest implements Request<Boolean> {
    public CreateMovementCommand(){
        super();
    }
}
