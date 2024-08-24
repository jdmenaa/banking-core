package org.banking.client.test.application.command;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteClientCommand implements Command {

    private Long id;
    public DeleteClientCommand() {
        super();
    }
}