package org.banking.account.test.application.command.account;

import io.jkratz.mediator.core.Request;
import org.banking.account.test.application.dto.request.account.CreateAccountRequest;

public class CreateAccountCommand extends CreateAccountRequest implements Request<Boolean> {
    public CreateAccountCommand(){
        super();
    }
}
