package org.banking.account.test.application.command.account;


import io.jkratz.mediator.core.CommandHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.port.IAccountRepository;
import org.banking.account.test.infraestructure.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DeleteAccountCommandHandler implements CommandHandler<DeleteAccountCommand> {

    private final IAccountRepository repository;

    @Override
    @Transactional
    public void handle(DeleteAccountCommand deleteAccountCommand) {
        log.info("Method delete account");
        AccountDto accountDto = repository.findById(deleteAccountCommand.getId());
        if(accountDto == null){
            log.info("account query not found....");
            throw new NotFoundException("Account query not found.");
        }
        repository.deleteById(deleteAccountCommand.getId());
    }
}
