package org.banking.account.test.application.command.movement;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteMovementCommand implements Command {

    private Long id;
    public DeleteMovementCommand() {
        super();
    }
}