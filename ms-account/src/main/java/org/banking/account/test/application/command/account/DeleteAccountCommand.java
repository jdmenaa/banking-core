package org.banking.account.test.application.command.account;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteAccountCommand implements Command {

    private Long id;
    public DeleteAccountCommand() {
        super();
    }
}