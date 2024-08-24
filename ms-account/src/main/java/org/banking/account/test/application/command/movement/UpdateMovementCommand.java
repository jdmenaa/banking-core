package org.banking.account.test.application.command.movement;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;
import org.banking.account.test.application.dto.request.movement.UpdateMovementRequest;

@Getter
@Setter
public class UpdateMovementCommand extends UpdateMovementRequest implements Request<Boolean> {

    private Long id;
    public UpdateMovementCommand(){
        super();
    }
}
