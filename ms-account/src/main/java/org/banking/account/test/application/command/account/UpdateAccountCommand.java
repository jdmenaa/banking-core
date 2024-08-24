package org.banking.account.test.application.command.account;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;
import org.banking.account.test.application.dto.request.account.UpdateAccountRequest;

@Getter
@Setter
public class UpdateAccountCommand extends UpdateAccountRequest implements Request<Boolean> {

    private Long id;
    public UpdateAccountCommand(){
        super();
    }
}
